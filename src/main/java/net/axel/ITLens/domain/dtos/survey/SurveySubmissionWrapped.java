package net.axel.ITLens.domain.dtos.survey;

import java.util.List;

public record SurveySubmissionWrapped(
        List<SurveyParticipateResponseDTO> submissions
) {
}
