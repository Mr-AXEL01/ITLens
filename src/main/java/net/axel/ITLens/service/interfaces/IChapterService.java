package net.axel.ITLens.service.interfaces;

import net.axel.ITLens.domain.dtos.chapter.ChapterRequestDTO;
import net.axel.ITLens.domain.dtos.chapter.ChapterResponseDTO;
import net.axel.ITLens.domain.entities.Chapter;

import java.util.UUID;

public interface IChapterService extends IBaseService<Chapter, ChapterRequestDTO, ChapterResponseDTO, UUID> {
}
