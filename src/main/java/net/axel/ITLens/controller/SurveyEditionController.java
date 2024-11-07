package net.axel.ITLens.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SurveyEditionController.CONTROLLER_PATH)
public class SurveyEditionController {
    public final static String CONTROLLER_PATH = "/api/v1/survey_editions";

    public SurveyEditionController() {
        super();
    }
}
