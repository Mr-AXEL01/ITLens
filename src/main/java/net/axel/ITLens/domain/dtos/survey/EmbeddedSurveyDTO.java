package net.axel.ITLens.domain.dtos.survey;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EmbeddedSurveyDTO(
        @NotNull UUID id,

        @NotBlank String title,

        @NotBlank String description
) {
}
