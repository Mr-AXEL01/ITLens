package net.axel.ITLens.domain.dtos.surveyEdition;

import net.axel.ITLens.domain.dtos.chapter.NestedChapterDTO;
import net.axel.ITLens.domain.dtos.survey.EmbeddedSurveyDTO;

import java.util.List;

public record ResultsDTO(
        EmbeddedSurveyDTO survey,

        List<NestedChapterDTO> chapters
) {
}
