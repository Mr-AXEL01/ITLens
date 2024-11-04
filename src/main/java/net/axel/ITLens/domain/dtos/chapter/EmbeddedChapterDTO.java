package net.axel.ITLens.domain.dtos.chapter;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record EmbeddedChapterDTO(
        @NotNull UUID id,

        @NotNull String title,

        String parentChapter,

        List<EmbeddedChapterDTO> subChapters
) {
}
