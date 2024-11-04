package net.axel.ITLens.domain.dtos.answer;

import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.dtos.question.EmbeddedQuestionDTO;

import java.util.UUID;

public record AnswerResponseDTO (
        @NotNull UUID id,

        @NotNull String text,

        @NotNull Integer selectionCount,

        @NotNull EmbeddedQuestionDTO question
) {
}
