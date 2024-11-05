package net.axel.ITLens.service.implementations;

import net.axel.ITLens.domain.dtos.survey.SurveyRequestDTO;
import net.axel.ITLens.domain.dtos.survey.SurveyResponseDTO;
import net.axel.ITLens.domain.entities.Survey;
import net.axel.ITLens.mapper.SurveyMapper;
import net.axel.ITLens.repository.SurveyRepository;
import net.axel.ITLens.service.interfaces.ISurveyService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SurveyService extends BaseService<Survey, SurveyRequestDTO, SurveyResponseDTO, UUID> implements ISurveyService {

    public SurveyService(SurveyRepository repository, SurveyMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected void updateEntity(Survey survey, SurveyRequestDTO dto) {

    }
}
