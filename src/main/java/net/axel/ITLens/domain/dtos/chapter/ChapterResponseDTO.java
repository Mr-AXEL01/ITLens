package net.axel.ITLens.domain.dtos.chapter;

import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.dtos.surveyEdition.EmbeddedSurveyEditionDTO;

import java.util.List;
import java.util.UUID;

public record ChapterResponseDTO (
        @NotNull UUID id,

        @NotNull String title,

        String parentChapter,

        List<EmbeddedChapterDTO> subChapters,

        @NotNull EmbeddedSurveyEditionDTO surveyEdition
) {
}
