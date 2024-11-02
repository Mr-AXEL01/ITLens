package net.axel.ITLens.util.mapper;

import net.axel.ITLens.domain.dtos.question.QuestionRequestDTO;
import net.axel.ITLens.domain.dtos.question.QuestionResponseDTO;
import net.axel.ITLens.domain.entities.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends BaseMapper<Question, QuestionResponseDTO, QuestionRequestDTO> {
}
