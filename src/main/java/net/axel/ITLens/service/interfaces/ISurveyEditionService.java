package net.axel.ITLens.service.interfaces;

import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionRequestDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionResponseDTO;
import net.axel.ITLens.domain.entities.SurveyEdition;

import java.util.UUID;

public interface ISurveyEditionService extends IBaseService<SurveyEdition, SurveyEditionRequestDTO, SurveyEditionResponseDTO, UUID> {
}
