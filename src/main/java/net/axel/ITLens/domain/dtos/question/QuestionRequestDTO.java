package net.axel.ITLens.domain.dtos.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.dtos.answer.AnswerRequestDTO;
import net.axel.ITLens.domain.entities.Chapter;
import net.axel.ITLens.domain.enums.QuestionType;
import net.axel.ITLens.validation.Exists;

import java.util.List;
import java.util.UUID;

public record QuestionRequestDTO(
        @NotBlank String text,

        @NotNull QuestionType questionType,

        @Exists(entityClass = Chapter.class, fieldName = "id", message = "chapter parent does not exists.")
        @NotNull UUID chapterId,

        @NotNull List<AnswerRequestDTO> answers
) {
}
