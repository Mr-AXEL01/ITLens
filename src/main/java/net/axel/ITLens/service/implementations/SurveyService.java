package net.axel.ITLens.service.implementations;

import jakarta.transaction.Transactional;
import net.axel.ITLens.domain.dtos.owner.OwnerResponseDTO;
import net.axel.ITLens.domain.dtos.survey.SurveyParticipateResponseDTO;
import net.axel.ITLens.domain.dtos.survey.SurveyRequestDTO;
import net.axel.ITLens.domain.dtos.survey.SurveyResponseDTO;
import net.axel.ITLens.domain.entities.Answer;
import net.axel.ITLens.domain.entities.Owner;
import net.axel.ITLens.domain.entities.Question;
import net.axel.ITLens.domain.entities.Survey;
import net.axel.ITLens.mapper.OwnerMapper;
import net.axel.ITLens.mapper.SurveyMapper;
import net.axel.ITLens.repository.AnswerRepository;
import net.axel.ITLens.repository.QuestionRepository;
import net.axel.ITLens.repository.SurveyRepository;
import net.axel.ITLens.service.interfaces.ISurveyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SurveyService extends BaseService<Survey, SurveyRequestDTO, SurveyResponseDTO, UUID> implements ISurveyService {

    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public SurveyService(SurveyRepository repository, SurveyMapper mapper, OwnerService ownerService, OwnerMapper ownerMapper, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        super(repository, mapper);
        this.ownerService = ownerService;
        this.ownerMapper = ownerMapper;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public SurveyResponseDTO create(SurveyRequestDTO dto) {
        Survey survey = mapper.toEntity(dto)
                .setOwner(owner(dto.ownerId()));

        Survey savedSurvey = repository.save(survey);

        return mapper.toResponseDto(savedSurvey);
    }

    @Override
    protected void updateEntity(Survey survey, SurveyRequestDTO dto) {
        survey.setTitle(dto.title())
                .setDescription(dto.description())
                .setOwner(owner(dto.ownerId()));
    }

    private Owner owner(UUID ownerId) {
        OwnerResponseDTO ownerResponse = ownerService.getById(ownerId);
        return ownerMapper.toEntityFromResponseDto(ownerResponse);
    }

    @Override
    public void participate(UUID surveyId, List<SurveyParticipateResponseDTO> responses) {
        Survey survey = repository.findById(surveyId)
                .orElseThrow(() -> new RuntimeException("Survey not found with id: " + surveyId));

        for (SurveyParticipateResponseDTO responseDTO : responses) {

            Question question = questionRepository.findById(responseDTO.questionId())
                    .orElseThrow(() -> new IllegalArgumentException("question not found"));

            question.setAnswerCount(question.getAnswerCount() + 1);

            questionRepository.save(question);

            for (UUID answerId : responseDTO.answersIds()) {
                Answer answer = answerRepository.findById(answerId)
                        .orElseThrow(() -> new IllegalArgumentException("Answer not found"));

                answer.setSelectionCount(answer.getSelectionCount() + 1);
                answerRepository.save(answer);
            }
        }
    }
}
