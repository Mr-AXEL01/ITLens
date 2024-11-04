package net.axel.ITLens.domain.dtos.answer;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EmbeddedAnswerDTO(
        @NotNull UUID id,

        @NotNull String text,

        @NotNull Integer selectionCount
) {
}
