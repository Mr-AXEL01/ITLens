package net.axel.ITLens.controller;

import net.axel.ITLens.domain.dtos.survey.SurveyRequestDTO;
import net.axel.ITLens.domain.dtos.survey.SurveyResponseDTO;
import net.axel.ITLens.domain.entities.Survey;
import net.axel.ITLens.service.interfaces.ISurveyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(SurveyController.CONTROLLER_PATH)
public class SurveyController extends BaseController<Survey, SurveyRequestDTO, SurveyResponseDTO, UUID> {
    public final static String CONTROLLER_PATH = "/api/v1/surveys";

    public SurveyController(ISurveyService baseService) {
        super(baseService);
    }
}
