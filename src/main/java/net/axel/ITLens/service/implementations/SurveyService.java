package net.axel.ITLens.service.implementations;

import jakarta.transaction.Transactional;
import net.axel.ITLens.domain.dtos.owner.OwnerResponseDTO;
import net.axel.ITLens.domain.dtos.survey.SurveyRequestDTO;
import net.axel.ITLens.domain.dtos.survey.SurveyResponseDTO;
import net.axel.ITLens.domain.entities.Owner;
import net.axel.ITLens.domain.entities.Survey;
import net.axel.ITLens.mapper.OwnerMapper;
import net.axel.ITLens.mapper.SurveyMapper;
import net.axel.ITLens.repository.SurveyRepository;
import net.axel.ITLens.service.interfaces.ISurveyService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class SurveyService extends BaseService<Survey, SurveyRequestDTO, SurveyResponseDTO, UUID> implements ISurveyService {

    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;

    public SurveyService(SurveyRepository repository, SurveyMapper mapper, OwnerService ownerService, OwnerMapper ownerMapper) {
        super(repository, mapper);
        this.ownerService = ownerService;
        this.ownerMapper = ownerMapper;
    }

    @Override
    protected void updateEntity(Survey survey, SurveyRequestDTO dto) {
        OwnerResponseDTO ownerResponse = ownerService.getById(dto.ownerId());
        Owner owner = ownerMapper.toEntityFromResponseDto(ownerResponse);

        survey.setTitle(dto.title())
                .setDescription(dto.description())
                .setOwner(owner);
    }
}
