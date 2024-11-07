package net.axel.ITLens.domain.dtos.surveyEdition;

import jakarta.validation.constraints.NotNull;
import net.axel.ITLens.domain.dtos.chapter.EmbeddedChapterDTO;
import net.axel.ITLens.domain.dtos.survey.EmbeddedSurveyDTO;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.UUID;

public record SurveyEditionResponseDTO (
        @NotNull UUID id,

        @NotNull LocalDate creationDate,

        @NotNull LocalDate startDate,

        @NotNull Year year,

        @NotNull EmbeddedSurveyDTO survey,

        List<EmbeddedChapterDTO> chapters
) {
}
