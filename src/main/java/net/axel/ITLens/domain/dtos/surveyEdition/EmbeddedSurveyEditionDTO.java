package net.axel.ITLens.domain.dtos.surveyEdition;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.Year;
import java.util.UUID;

public record EmbeddedSurveyEditionDTO(
        @NotNull UUID id,

        @NotNull LocalDate creationDate,

        @NotNull LocalDate startDate,

        @NotNull Year year
) {
}
