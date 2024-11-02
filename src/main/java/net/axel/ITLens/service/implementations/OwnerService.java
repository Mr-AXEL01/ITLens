package net.axel.ITLens.service.implementations;

import net.axel.ITLens.domain.dtos.owner.OwnerRequestDTO;
import net.axel.ITLens.domain.dtos.owner.OwnerResponseDTO;
import net.axel.ITLens.domain.entities.Owner;
import net.axel.ITLens.mapper.OwnerMapper;
import net.axel.ITLens.repository.OwnerRepository;
import net.axel.ITLens.service.interfaces.IOwnerService;

import java.util.UUID;

public class OwnerService extends BaseService<Owner, OwnerRequestDTO, OwnerResponseDTO, UUID> implements IOwnerService {

    public OwnerService(OwnerRepository repository, OwnerMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected void updateEntity(Owner owner, OwnerRequestDTO dto) {
        owner.setName(dto.name());
    }
}
