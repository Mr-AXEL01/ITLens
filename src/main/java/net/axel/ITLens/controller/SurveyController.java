package net.axel.ITLens.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SurveyController.CONTROLLER_PATH)
public class SurveyController {
    public final static String CONTROLLER_PATH = "/api/v1/surveys";

    public SurveyController(ISurvey) {

    }
}
