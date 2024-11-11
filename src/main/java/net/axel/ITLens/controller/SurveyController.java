package net.axel.ITLens.controller;

import net.axel.ITLens.domain.dtos.survey.*;
import net.axel.ITLens.domain.entities.Survey;
import net.axel.ITLens.service.interfaces.ISurveyService;
import org.springframework.boot.actuate.management.HeapDumpWebEndpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(SurveyController.CONTROLLER_PATH)
public class SurveyController extends BaseController<Survey, SurveyRequestDTO, SurveyResponseDTO, UUID> {
    public final static String CONTROLLER_PATH = "/api/v1/surveys";

    private final ISurveyService surveyService;

    public SurveyController(ISurveyService baseService, ISurveyService surveyService) {
        super(baseService);
        this.surveyService = surveyService;
    }

    @PostMapping("/{surveyId}/participate")
    public ResponseEntity<Void> participate(@PathVariable("surveyId") UUID surveyId,
                                            @RequestBody Payload surveyParticipateRequestDTO) {
        surveyService.participate(surveyId, surveyParticipateRequestDTO.submissions());
        return ResponseEntity.noContent().build();
    }
}
