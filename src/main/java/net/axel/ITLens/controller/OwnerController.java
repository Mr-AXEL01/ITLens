package net.axel.ITLens.controller;

import net.axel.ITLens.domain.dtos.owner.OwnerRequestDTO;
import net.axel.ITLens.domain.dtos.owner.OwnerResponseDTO;
import net.axel.ITLens.domain.entities.Owner;
import net.axel.ITLens.service.interfaces.IOwnerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(OwnerController.CONTROLLER_PATH)
public class OwnerController extends BaseController<Owner, OwnerRequestDTO, OwnerResponseDTO, UUID> {
    public final static String CONTROLLER_PATH = "/api/v1/owners";

    public OwnerController(IOwnerService ownerService) {
        super(ownerService);
    }
}
