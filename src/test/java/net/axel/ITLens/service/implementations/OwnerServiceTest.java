package net.axel.ITLens.service.implementations;

import net.axel.ITLens.domain.dtos.owner.OwnerRequestDTO;
import net.axel.ITLens.domain.dtos.owner.OwnerResponseDTO;
import net.axel.ITLens.domain.dtos.survey.EmbeddedSurveyDTO;
import net.axel.ITLens.domain.entities.Owner;
import net.axel.ITLens.mapper.OwnerMapper;
import net.axel.ITLens.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private OwnerMapper ownerMapper;

    @InjectMocks
    private OwnerService ownerService;

    private Owner owner;
    private OwnerRequestDTO ownerRequestDTO;
    private OwnerResponseDTO ownerResponseDTO;
    private EmbeddedSurveyDTO embeddedSurveyDTO;
    private final UUID ownerId = UUID.randomUUID();
    private final UUID surveyId = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        embeddedSurveyDTO = new EmbeddedSurveyDTO(surveyId, "Survey Title", "Survey Description");
        owner = new Owner(ownerId, "Test Owner");
        ownerRequestDTO = new OwnerRequestDTO("Test Owner");
        ownerResponseDTO = new OwnerResponseDTO(ownerId, "Test Owner", List.of(embeddedSurveyDTO));
    }

    @Test
    void givenOwnersInDatabase_whenGetAllOwners_thenReturnAllOwnersWithSurveys() {
        when(ownerRepository.findAll()).thenReturn(Collections.singletonList(owner));
        when(ownerMapper.toResponseDto(owner)).thenReturn(ownerResponseDTO);

        var result = ownerService.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(ownerResponseDTO, result.get(0));
        assertNotNull(result.get(0).surveys());
        assertEquals(1, result.get(0).surveys().size());
        assertEquals(embeddedSurveyDTO, result.get(0).surveys().get(0));
    }

    @Test
    void givenExistingOwnerId_whenGetOwnerById_thenReturnOwnerWithSurveys() {
        when(ownerRepository.findById(ownerId)).thenReturn(Optional.of(owner));
        when(ownerMapper.toResponseDto(owner)).thenReturn(ownerResponseDTO);

        var result = ownerService.getById(ownerId);

        assertEquals(ownerResponseDTO, result);
        assertNotNull(result.surveys());
        assertEquals(1, result.surveys().size());
        assertEquals(embeddedSurveyDTO, result.surveys().get(0));
    }

    @Test
    void givenValidOwnerDto_whenCreateOwner_thenReturnCreatedOwnerWithSurveys() {
        when(ownerMapper.toEntity(ownerRequestDTO)).thenReturn(owner);
        when(ownerRepository.save(owner)).thenReturn(owner);
        when(ownerMapper.toResponseDto(owner)).thenReturn(ownerResponseDTO);

        var result = ownerService.create(ownerRequestDTO);

        assertEquals(ownerResponseDTO, result);
        assertNotNull(result.surveys());
        assertEquals(1, result.surveys().size());
        assertEquals(embeddedSurveyDTO, result.surveys().get(0));
    }
}