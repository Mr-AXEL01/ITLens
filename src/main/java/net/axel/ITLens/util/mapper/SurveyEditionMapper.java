package net.axel.ITLens.util.mapper;

import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionRequestDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionResponseDTO;
import net.axel.ITLens.domain.entities.SurveyEdition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyEditionMapper extends BaseMapper<SurveyEdition, SurveyEditionResponseDTO, SurveyEditionRequestDTO>{
}
