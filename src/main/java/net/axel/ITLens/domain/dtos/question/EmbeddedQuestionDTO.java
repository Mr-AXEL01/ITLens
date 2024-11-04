package net.axel.ITLens.domain.dtos.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.enums.QuestionType;

import java.util.UUID;

public record EmbeddedQuestionDTO(
        @NotNull UUID id,

        @NotBlank String text,

        @NotBlank QuestionType questionType,

        @NotNull Integer answerCount
) {
}
