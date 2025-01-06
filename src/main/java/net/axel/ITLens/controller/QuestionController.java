package net.axel.ITLens.controller;

import net.axel.ITLens.domain.dtos.question.QuestionRequestDTO;
import net.axel.ITLens.domain.dtos.question.QuestionResponseDTO;
import net.axel.ITLens.domain.entities.Question;
import net.axel.ITLens.service.interfaces.IQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(QuestionController.CONTROLLER_PATH)
public class QuestionController extends BaseController<Question, QuestionRequestDTO, QuestionResponseDTO, UUID> {

    public final static String CONTROLLER_PATH = "/api/v1/questions";

    private final IQuestionService questionService;

    public QuestionController(IQuestionService questionService) {
        super(questionService);
        this.questionService = questionService;
    }

    @GetMapping("/chapter/{chapterId}")
    public ResponseEntity<List<QuestionResponseDTO>> getByChapterId(@PathVariable("chapterId") UUID chapterId) {
        List<QuestionResponseDTO> questions = questionService.findByChapter(chapterId);
        return ResponseEntity.ok(questions);
    }
}
