package net.axel.ITLens.service.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.ITLens.domain.dtos.chapter.ChapterResponseDTO;
import net.axel.ITLens.domain.dtos.chapter.EmbeddedChapterDTO;
import net.axel.ITLens.domain.dtos.survey.SurveyResponseDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.ResultsDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionRequestDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionResponseDTO;
import net.axel.ITLens.domain.entities.Chapter;
import net.axel.ITLens.domain.entities.Survey;
import net.axel.ITLens.domain.entities.SurveyEdition;
import net.axel.ITLens.mapper.SurveyEditionMapper;
import net.axel.ITLens.mapper.SurveyEditionResultMapper;
import net.axel.ITLens.mapper.SurveyMapper;
import net.axel.ITLens.repository.SurveyEditionRepository;
import net.axel.ITLens.service.interfaces.ISurveyEditionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SurveyEditionService implements ISurveyEditionService {

    private final SurveyEditionRepository repository;
    private final SurveyEditionMapper mapper;
    private final SurveyService surveyService;
    private final SurveyMapper surveyMapper;
    private final SurveyEditionResultMapper surveyEditionResultMapper;

    @Override
    public List<SurveyEditionResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public SurveyEditionResponseDTO getById(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        SurveyEdition surveyEdition = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("SurveyEdition not found with id: " + id));

        List<Chapter> filteredChapters = surveyEdition.getChapters()
                .stream()
                .filter(chapter -> chapter.getParentChapter() == null)
                .toList();

        surveyEdition.setChapters(filteredChapters);

        return mapper.toResponseDto(surveyEdition);
    }

    public SurveyEditionResponseDTO create(SurveyEditionRequestDTO dto) {
        SurveyEdition surveyEdition = mapper.toEntity(dto)
                .setSurvey(survey(dto.surveyId()));

        SurveyEdition savedSurveyEdition = repository.save(surveyEdition);

        return mapper.toResponseDto(savedSurveyEdition);
    }

    public SurveyEditionResponseDTO update(UUID id, SurveyEditionRequestDTO dto) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        SurveyEdition surveyEdition = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("SurveyEdition not found with id: " + id));

        surveyEdition.setCreationDate(dto.creationDate())
                .setStartDate(dto.startDate())
                .setYear(dto.year())
                .setSurvey(survey(dto.surveyId()));

        return mapper.toResponseDto(surveyEdition);
    }

    @Override
    public void delete(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        if (!repository.existsById(id)) {
            throw new RuntimeException("SurveyEdition not found with id: " + id);
        }

        repository.deleteById(id);
    }

    private Survey survey(UUID surveyId) {
        SurveyResponseDTO surveyResponse = surveyService.getById(surveyId);
        return surveyMapper.toEntityFromResponseDto(surveyResponse);
    }


    public ResultsDTO results(UUID surveyEditionId) {
        return repository.findById(surveyEditionId)
                .map(surveyEditionResultMapper::mapToResultDto)
                .orElseThrow(() -> new RuntimeException("No SurveyEdition found with this ID :" + surveyEditionId));
    }

}