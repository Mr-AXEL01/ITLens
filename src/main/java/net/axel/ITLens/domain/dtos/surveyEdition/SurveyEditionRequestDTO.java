package net.axel.ITLens.domain.dtos.surveyEdition;

import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.entities.Survey;
import net.axel.ITLens.validation.Exists;

import java.time.LocalDate;
import java.time.Year;
import java.util.UUID;

public record SurveyEditionRequestDTO(
        @NotNull LocalDate creationDate,

        @NotNull LocalDate startDate,

        @NotNull Year year,

        @Exists(entityClass = Survey.class, fieldName = "id", message = "Survey does not exists.")
        @NotNull UUID surveyId
) {
}
