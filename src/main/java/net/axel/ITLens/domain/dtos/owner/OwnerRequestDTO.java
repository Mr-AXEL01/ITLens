package net.axel.ITLens.domain.dtos.owner;

import jakarta.validation.constraints.NotBlank;

public record OwnerRequestDTO(
        @NotBlank String name
) {
}
