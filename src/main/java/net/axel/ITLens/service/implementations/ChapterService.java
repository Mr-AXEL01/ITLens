package net.axel.ITLens.service.implementations;

import jakarta.transaction.Transactional;
import net.axel.ITLens.domain.dtos.chapter.ChapterRequestDTO;
import net.axel.ITLens.domain.dtos.chapter.ChapterResponseDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionResponseDTO;
import net.axel.ITLens.domain.entities.Chapter;
import net.axel.ITLens.domain.entities.SurveyEdition;
import net.axel.ITLens.mapper.ChapterMapper;
import net.axel.ITLens.mapper.SurveyEditionMapper;
import net.axel.ITLens.repository.ChapterRepository;
import net.axel.ITLens.service.interfaces.IChapterService;
import net.axel.ITLens.service.interfaces.ISurveyEditionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class ChapterService extends BaseService<Chapter, ChapterRequestDTO, ChapterResponseDTO, UUID> implements IChapterService {

    private final ISurveyEditionService surveyEditionService;

    private final SurveyEditionMapper surveyEditionMapper;

    public ChapterService(ChapterRepository repository, ChapterMapper mapper, ISurveyEditionService surveyEditionService, SurveyEditionMapper surveyEditionMapper) {
        super(repository, mapper);
        this.surveyEditionService = surveyEditionService;
        this.surveyEditionMapper = surveyEditionMapper;
    }

    @Override
    public ChapterResponseDTO create(ChapterRequestDTO dto) {
        Chapter chapter = mapper.toEntity(dto)
                .setSurveyEdition(surveyEdition(dto.surveyEditionId()));

        if(dto.chapterId() != null) {
            chapter.setParentChapter(chapter(dto.chapterId()));
        }

        Chapter savedChapter = repository.save(chapter);

        return mapper.toResponseDto(savedChapter);
    }

    @Override
    protected void updateEntity(Chapter chapter, ChapterRequestDTO dto) {
        chapter.setTitle(dto.title())
                .setSurveyEdition(surveyEdition(dto.surveyEditionId()));
        if(dto.chapterId() != null) {
            chapter.setParentChapter(chapter(dto.chapterId()));
        }
    }

    private SurveyEdition surveyEdition(UUID surveyEditionId) {
        SurveyEditionResponseDTO surveyEditionResponse = surveyEditionService.getById(surveyEditionId);
        return surveyEditionMapper.toEntityFromResponseDto(surveyEditionResponse);
    }

    private Chapter chapter(UUID chapterId) {
        return mapper
                .toEntityFromResponseDto(
                        getById(chapterId)
                );
    }
}
