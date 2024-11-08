package net.axel.ITLens.service.implementations;

import jakarta.transaction.Transactional;
import net.axel.ITLens.domain.dtos.answer.AnswerRequestDTO;
import net.axel.ITLens.domain.dtos.chapter.ChapterResponseDTO;
import net.axel.ITLens.domain.dtos.question.QuestionRequestDTO;
import net.axel.ITLens.domain.dtos.question.QuestionResponseDTO;
import net.axel.ITLens.domain.entities.Answer;
import net.axel.ITLens.domain.entities.Chapter;
import net.axel.ITLens.domain.entities.Question;
import net.axel.ITLens.mapper.AnswerMapper;
import net.axel.ITLens.mapper.ChapterMapper;
import net.axel.ITLens.mapper.QuestionMapper;
import net.axel.ITLens.repository.QuestionRepository;
import net.axel.ITLens.service.interfaces.IChapterService;
import net.axel.ITLens.service.interfaces.IQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuestionService extends BaseService<Question, QuestionRequestDTO, QuestionResponseDTO, UUID> implements IQuestionService {

    private final IChapterService chapterService;
    private final ChapterMapper chapterMapper;
    private final AnswerMapper answerMapper;

    public QuestionService(QuestionRepository repository, QuestionMapper mapper, IChapterService chapterService, ChapterMapper chapterMapper, AnswerMapper answerMapper) {
        super(repository, mapper);
        this.chapterService = chapterService;
        this.chapterMapper = chapterMapper;
        this.answerMapper = answerMapper;
    }

    @Override
    public QuestionResponseDTO create(QuestionRequestDTO dto) {
        Question question = mapper.toEntity(dto)
                .setChapter(chapter(dto.chapterId()))
                .setAnswers(mapAnswersRequestToEntity(dto.answers()));

        Question savedChapter = repository.save(question);

        return mapper.toResponseDto(savedChapter);
    }

    @Override
    protected void updateEntity(Question question, QuestionRequestDTO dto) {
        question.setQuestionType(dto.questionType())
                .setText(dto.text())
                .setChapter(chapter(dto.chapterId()))
                .setAnswers(mapAnswersRequestToEntity(dto.answers()));
    }

    private Chapter chapter(UUID chapterId) {
        ChapterResponseDTO chapterResponse = chapterService.getById(chapterId);
        return chapterMapper.toEntityFromResponseDto(chapterResponse);
    }

    private Set<Answer> mapAnswersRequestToEntity(List<AnswerRequestDTO> answersRequest) {
        return answersRequest.stream()
                .map(answerMapper::toEntity)
                .collect(Collectors.toSet());
    }
}
