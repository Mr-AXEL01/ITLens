package net.axel.ITLens.service.implementations;

import jakarta.transaction.Transactional;
import net.axel.ITLens.domain.dtos.survey.SurveyResponseDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.ResultsDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionRequestDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionResponseDTO;
import net.axel.ITLens.domain.entities.Survey;
import net.axel.ITLens.domain.entities.SurveyEdition;
import net.axel.ITLens.mapper.SurveyEditionMapper;
import net.axel.ITLens.mapper.SurveyEditionResultMapper;
import net.axel.ITLens.mapper.SurveyMapper;
import net.axel.ITLens.repository.SurveyEditionRepository;
import net.axel.ITLens.service.interfaces.ISurveyEditionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class SurveyEditionService extends BaseService<SurveyEdition, SurveyEditionRequestDTO, SurveyEditionResponseDTO, UUID> implements ISurveyEditionService {

    private final SurveyService surveyService;
    private final SurveyMapper surveyMapper;
    private final SurveyEditionResultMapper surveyEditionResultMapper;

    public SurveyEditionService(SurveyEditionRepository repository, SurveyEditionMapper mapper, SurveyService surveyService, SurveyMapper surveyMapper, SurveyEditionResultMapper surveyEditionResultMapper) {
        super(repository, mapper);
        this.surveyService = surveyService;
        this.surveyMapper = surveyMapper;
        this.surveyEditionResultMapper = surveyEditionResultMapper;
    }

    @Override
    public SurveyEditionResponseDTO create(SurveyEditionRequestDTO dto) {
        SurveyEdition surveyEdition = mapper.toEntity(dto)
                .setSurvey(survey(dto.surveyId()));

        SurveyEdition savedSurveyEdition = repository.save(surveyEdition);

        return mapper.toResponseDto(savedSurveyEdition);
    }

    @Override
    protected void updateEntity(SurveyEdition surveyEdition, SurveyEditionRequestDTO dto) {
        surveyEdition.setCreationDate(dto.creationDate())
                .setStartDate(dto.startDate())
                .setYear(dto.year())
                .setSurvey(survey(dto.surveyId()));
    }

    private Survey survey(UUID surveyId) {
        SurveyResponseDTO surveyResponse = surveyService.getById(surveyId);
        return surveyMapper.toEntityFromResponseDto(surveyResponse);
    }

    @Override
    public ResultsDTO results(UUID surveyEditionId) {
        return repository.findById(surveyEditionId)
                .map(surveyEditionResultMapper::mapToResultDto)
                .orElseThrow(() -> new RuntimeException("No SurveyEdition found with this ID :" + surveyEditionId));
    }

}