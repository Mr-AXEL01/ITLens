package net.axel.ITLens.domain.dtos.survey;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record SurveyParticipateResponseDTO(
        @NotNull UUID questionId,

        @NotNull List<UUID> answersIds
) {
}
