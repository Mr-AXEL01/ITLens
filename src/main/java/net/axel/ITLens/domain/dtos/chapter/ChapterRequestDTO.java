package net.axel.ITLens.domain.dtos.chapter;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ChapterRequestDTO (
        @NotNull String title,

        @NotNull UUID  surveyEditionId,

        UUID chapterId
) {
}
