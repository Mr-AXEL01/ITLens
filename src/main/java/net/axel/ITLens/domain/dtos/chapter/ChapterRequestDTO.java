package net.axel.ITLens.domain.dtos.chapter;

import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.entities.Chapter;
import net.axel.ITLens.domain.entities.SurveyEdition;
import net.axel.ITLens.validation.Exists;

import java.util.UUID;

public record ChapterRequestDTO (
        @NotNull String title,

        @Exists(entityClass = SurveyEdition.class, fieldName = "id", message = "surveyEdition does not exists.")
        @NotNull UUID  surveyEditionId,

        @Exists(entityClass = Chapter.class, fieldName = "id", message = "chapter parent does not exists.")
        UUID chapterId
) {
}
