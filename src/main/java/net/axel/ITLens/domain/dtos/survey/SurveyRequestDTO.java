package net.axel.ITLens.domain.dtos.survey;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.entities.Owner;
import net.axel.ITLens.validation.Exists;

import java.util.UUID;

public record SurveyRequestDTO(
        @NotBlank String title,

        @NotBlank String description,

        @Exists(entityClass = Owner.class, fieldName = "id", message = "Owner does not exists")
        @NotNull UUID ownerId
) {
}
