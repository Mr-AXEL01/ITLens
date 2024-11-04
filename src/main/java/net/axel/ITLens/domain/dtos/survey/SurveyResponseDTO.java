package net.axel.ITLens.domain.dtos.survey;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.dtos.owner.EmbeddedOwnerDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.EmbeddedSurveyEditionDTO;

import java.util.List;
import java.util.UUID;

public record SurveyResponseDTO(
        @NotNull UUID id,

        @NotBlank String title,

        @NotBlank String description,

        @NotNull EmbeddedOwnerDTO owner,

        List<EmbeddedSurveyEditionDTO> surveyEditions
) {
}
