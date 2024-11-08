package net.axel.ITLens.domain.dtos.answer;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AnswerRequestDTO(
        @NotNull String text
) {
}
