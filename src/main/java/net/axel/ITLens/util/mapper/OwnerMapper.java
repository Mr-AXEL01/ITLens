package net.axel.ITLens.util.mapper;

import net.axel.ITLens.domain.dtos.owner.OwnerRequestDTO;
import net.axel.ITLens.domain.dtos.owner.OwnerResponseDTO;
import net.axel.ITLens.domain.entities.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper extends BaseMapper<Owner, OwnerResponseDTO, OwnerRequestDTO>{
}
