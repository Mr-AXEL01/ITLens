package net.axel.ITLens.domain.dtos.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.dtos.answer.EmbeddedAnswerDTO;

import java.util.List;
import java.util.UUID;

public record NestedQuestion(
        @NotNull UUID id,

        @NotBlank String text,

        List<EmbeddedAnswerDTO> answers,

        int answerCount
) {
}
