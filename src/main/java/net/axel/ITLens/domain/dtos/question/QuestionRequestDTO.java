package net.axel.ITLens.domain.dtos.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.dtos.answer.AnswerRequestDTO;
import net.axel.ITLens.domain.enums.QuestionType;

import java.util.List;
import java.util.UUID;

public record QuestionRequestDTO(
        @NotBlank String text,

        @NotBlank QuestionType questionType,

        @NotNull UUID chapterId,

        @NotNull List<AnswerRequestDTO> answers
) {
}
