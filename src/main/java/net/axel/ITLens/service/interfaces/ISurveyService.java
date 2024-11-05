package net.axel.ITLens.service.interfaces;

import net.axel.ITLens.domain.dtos.survey.SurveyRequestDTO;
import net.axel.ITLens.domain.dtos.survey.SurveyResponseDTO;
import net.axel.ITLens.domain.entities.Survey;

import java.util.UUID;

public interface ISurveyService extends IBaseService<Survey, SurveyRequestDTO, SurveyResponseDTO, UUID> {
}
