package net.axel.ITLens.service.implementations;

import jakarta.transaction.Transactional;
import net.axel.ITLens.domain.dtos.survey.SurveyRequestDTO;
import net.axel.ITLens.domain.dtos.survey.SurveyResponseDTO;
import net.axel.ITLens.domain.entities.Owner;
import net.axel.ITLens.domain.entities.Survey;
import net.axel.ITLens.mapper.SurveyMapper;
import net.axel.ITLens.repository.SurveyRepository;
import net.axel.ITLens.service.interfaces.ISurveyService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class SurveyService extends BaseService<Survey, SurveyRequestDTO, SurveyResponseDTO, UUID> implements ISurveyService {

    private final OwnerService ownerService;

    public SurveyService(SurveyRepository repository, SurveyMapper mapper, OwnerService ownerService) {
        super(repository, mapper);
        this.ownerService = ownerService;
    }

    @Override
    public SurveyResponseDTO create(SurveyRequestDTO dto) {
        Survey survey = mapper.toEntity(dto)
                .setOwner(owner(dto.ownerId()));

        Survey savedSurvey = repository.save(survey);

        return mapper.toResponseDto(savedSurvey);
    }

    @Override
    protected void updateEntity(Survey survey, SurveyRequestDTO dto) {
        survey.setTitle(dto.title())
                .setDescription(dto.description())
                .setOwner(owner(dto.ownerId()));
    }

    private Owner owner(UUID ownerId) {
        return ownerService
                .mapper
                .toEntityFromResponseDto(
                        ownerService.getById(ownerId)
                );
    }
}
