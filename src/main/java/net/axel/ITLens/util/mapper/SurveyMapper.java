package net.axel.ITLens.util.mapper;

import net.axel.ITLens.domain.dtos.survey.SurveyRequestDTO;
import net.axel.ITLens.domain.dtos.survey.SurveyResponseDTO;
import net.axel.ITLens.domain.entities.Survey;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyMapper extends BaseMapper<Survey, SurveyResponseDTO, SurveyRequestDTO> {
}
