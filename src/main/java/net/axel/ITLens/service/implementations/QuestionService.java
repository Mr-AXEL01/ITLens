package net.axel.ITLens.service.implementations;

import jakarta.transaction.Transactional;
import net.axel.ITLens.domain.dtos.chapter.ChapterResponseDTO;
import net.axel.ITLens.domain.dtos.question.QuestionRequestDTO;
import net.axel.ITLens.domain.dtos.question.QuestionResponseDTO;
import net.axel.ITLens.domain.entities.Chapter;
import net.axel.ITLens.domain.entities.Question;
import net.axel.ITLens.mapper.ChapterMapper;
import net.axel.ITLens.mapper.QuestionMapper;
import net.axel.ITLens.repository.QuestionRepository;
import net.axel.ITLens.service.interfaces.IChapterService;
import net.axel.ITLens.service.interfaces.IQuestionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class QuestionService extends BaseService<Question, QuestionRequestDTO, QuestionResponseDTO, UUID> implements IQuestionService {

    private final IChapterService chapterService;

    private final ChapterMapper chapterMapper;

    public QuestionService(QuestionRepository repository, QuestionMapper mapper, IChapterService chapterService, ChapterMapper chapterMapper) {
        super(repository, mapper);
        this.chapterService = chapterService;
        this.chapterMapper = chapterMapper;
    }

    @Override
    public QuestionResponseDTO create(QuestionRequestDTO dto) {
        Question question = mapper.toEntity(dto)
                .setChapter(chapter(dto.chapterId()));

        Question savedChapter = repository.save(question);

        return mapper.toResponseDto(savedChapter);
    }

    @Override
    protected void updateEntity(Question question, QuestionRequestDTO dto) {
        question.setQuestionType(dto.questionType())
                .setText(dto.text())
                .setChapter(chapter(dto.chapterId()));
    }

    private Chapter chapter(UUID chapterId) {
        ChapterResponseDTO chapterResponse = chapterService.getById(chapterId);
        return chapterMapper.toEntityFromResponseDto(chapterResponse);
    }
}
