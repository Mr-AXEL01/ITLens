package net.axel.ITLens.service.interfaces;

import net.axel.ITLens.domain.dtos.question.QuestionRequestDTO;
import net.axel.ITLens.domain.dtos.question.QuestionResponseDTO;
import net.axel.ITLens.domain.entities.Question;

import java.util.List;
import java.util.UUID;

public interface IQuestionService extends IBaseService<Question, QuestionRequestDTO, QuestionResponseDTO, UUID> {
    List<QuestionResponseDTO> findByChapter(UUID chapterId);
}
