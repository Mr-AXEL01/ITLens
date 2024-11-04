package net.axel.ITLens.domain.dtos.owner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EmbeddedOwnerDTO(
        @NotNull UUID id,

        @NotBlank String name
) {
}
