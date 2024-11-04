package net.axel.ITLens.domain.dtos.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.dtos.answer.EmbeddedAnswerDTO;
import net.axel.ITLens.domain.dtos.chapter.EmbeddedChapterDTO;
import net.axel.ITLens.domain.enums.QuestionType;

import java.util.List;
import java.util.UUID;

public record QuestionResponseDTO(
        @NotNull UUID id,

        @NotBlank String text,

        @NotBlank QuestionType questionType,

        @NotNull Integer answerCount,

        @NotNull EmbeddedChapterDTO chapter,

        List<EmbeddedAnswerDTO> answers
) {
}
