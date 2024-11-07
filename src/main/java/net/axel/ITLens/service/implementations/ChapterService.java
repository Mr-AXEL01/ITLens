package net.axel.ITLens.service.implementations;

import jakarta.transaction.Transactional;
import net.axel.ITLens.domain.dtos.chapter.ChapterRequestDTO;
import net.axel.ITLens.domain.dtos.chapter.ChapterResponseDTO;
import net.axel.ITLens.domain.entities.Chapter;
import net.axel.ITLens.mapper.ChapterMapper;
import net.axel.ITLens.repository.ChapterRepository;
import net.axel.ITLens.service.interfaces.IChapterService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class ChapterService extends BaseService<Chapter, ChapterRequestDTO, ChapterResponseDTO, UUID> implements IChapterService {

    public ChapterService(ChapterRepository repository, ChapterMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected void updateEntity(Chapter chapter, ChapterRequestDTO dto) {

    }
}
