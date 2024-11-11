package net.axel.ITLens.mapper;

import net.axel.ITLens.domain.dtos.surveyEdition.ResultsDTO;
import net.axel.ITLens.domain.entities.SurveyEdition;

public interface SurveyEditionResultMapper {

    ResultsDTO mapToResultDto(SurveyEdition surveyEdition);
}