package net.axel.ITLens.domain.dtos.surveyEdition;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.Year;
import java.util.UUID;

public record SurveyEditionRequestDTO(
        @NotNull LocalDate creationDate,

        @NotNull LocalDate startDate,

        @NotNull Year year,

        @NotNull UUID surveyId
) {
}
