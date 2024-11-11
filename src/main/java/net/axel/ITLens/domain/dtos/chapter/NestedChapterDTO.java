package net.axel.ITLens.domain.dtos.chapter;

import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.dtos.question.NestedQuestion;

import java.util.List;
import java.util.UUID;

public record NestedChapterDTO(
        @NotNull UUID id,

        @NotNull String title,

        List<NestedChapterDTO> subChapters,

        List<NestedQuestion> questions
) {
}
