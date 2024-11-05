package net.axel.ITLens.service.interfaces;

import net.axel.ITLens.domain.dtos.owner.OwnerRequestDTO;
import net.axel.ITLens.domain.dtos.owner.OwnerResponseDTO;
import net.axel.ITLens.domain.entities.Owner;

import java.util.UUID;

public interface IOwnerService extends IBaseService<Owner, OwnerRequestDTO, OwnerResponseDTO, UUID> {
}
