package net.axel.ITLens.domain.dtos.owner;

import jakarta.validation.constraints.NotBlank;
import net.axel.ITLens.domain.dtos.survey.EmbeddedSurveyDTO;

import java.util.List;
import java.util.UUID;

public record OwnerResponseDTO (
        @NotBlank UUID id,

        @NotBlank String name,

        List<EmbeddedSurveyDTO> surveys
) {
}
