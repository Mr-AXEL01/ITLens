package net.axel.ITLens.util.mapper;

import net.axel.ITLens.domain.dtos.answer.AnswerRequestDTO;
import net.axel.ITLens.domain.dtos.answer.AnswerResponseDTO;
import net.axel.ITLens.domain.entities.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper extends BaseMapper<Answer, AnswerResponseDTO, AnswerRequestDTO>{
}
