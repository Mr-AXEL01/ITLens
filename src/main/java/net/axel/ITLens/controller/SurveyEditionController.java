package net.axel.ITLens.controller;

import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionRequestDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.SurveyEditionResponseDTO;
import net.axel.ITLens.domain.entities.SurveyEdition;
import net.axel.ITLens.service.interfaces.ISurveyEditionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(SurveyEditionController.CONTROLLER_PATH)
public class SurveyEditionController extends BaseController<SurveyEdition, SurveyEditionRequestDTO, SurveyEditionResponseDTO, UUID> {
    public final static String CONTROLLER_PATH = "/api/v1/survey_editions";

    public SurveyEditionController(ISurveyEditionService baseService) {
        super(baseService);
    }
}
