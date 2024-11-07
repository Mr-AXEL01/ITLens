package net.axel.ITLens.controller;

import net.axel.ITLens.domain.dtos.chapter.ChapterRequestDTO;
import net.axel.ITLens.domain.dtos.chapter.ChapterResponseDTO;
import net.axel.ITLens.domain.entities.Chapter;
import net.axel.ITLens.service.interfaces.IChapterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ChapterController.CONTROLLER_PATH)
public class ChapterController extends BaseController<Chapter, ChapterRequestDTO, ChapterResponseDTO, UUID> {

    public final static String CONTROLLER_PATH = "/api/v1/chapters";

    public ChapterController(IChapterService baseService) {
        super(baseService);
    }
}
