package net.axel.ITLens.controller;

import net.axel.ITLens.domain.dtos.question.QuestionRequestDTO;
import net.axel.ITLens.domain.dtos.question.QuestionResponseDTO;
import net.axel.ITLens.domain.entities.Question;
import net.axel.ITLens.service.interfaces.IQuestionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(QuestionController.CONTROLLER_PATH)
public class QuestionController extends BaseController<Question, QuestionRequestDTO, QuestionResponseDTO, UUID> {

    public final static String CONTROLLER_PATH = "/api/v1/questions";

    public QuestionController(IQuestionService baseService) {
        super(baseService);
    }
}
