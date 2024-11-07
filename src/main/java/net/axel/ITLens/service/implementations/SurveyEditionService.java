package net.axel.ITLens.service.implementations;

import jakarta.transaction.Transactional;
import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionRequestDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionResponseDTO;
import net.axel.ITLens.domain.entities.Survey;
import net.axel.ITLens.domain.entities.SurveyEdition;
import net.axel.ITLens.mapper.SurveyEditionMapper;
import net.axel.ITLens.repository.SurveyEditionRepository;
import net.axel.ITLens.service.interfaces.ISurveyEditionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class SurveyEditionService extends BaseService<SurveyEdition, SurveyEditionRequestDTO, SurveyEditionResponseDTO, UUID> implements ISurveyEditionService {

    private final SurveyService surveyService;

    public SurveyEditionService(SurveyEditionRepository repository, SurveyEditionMapper mapper, SurveyService surveyService) {
        super(repository, mapper);
        this.surveyService = surveyService;
    }

//    @Override the create method.


    @Override
    protected void updateEntity(SurveyEdition surveyEdition, SurveyEditionRequestDTO dto) {

        Survey survey = surveyService
                .mapper
                .toEntityFromResponseDto(
                        surveyService.getById(dto.surveyId())
                );

        surveyEdition.setCreationDate(dto.creationDate())
                .setStartDate(dto.startDate())
                .setYear(dto.year())
                .setSurvey(survey);
    }
}
