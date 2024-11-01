package net.axel.ITLens.repository;

import net.axel.ITLens.domain.entities.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChapterRepository extends JpaRepository<Chapter, UUID> {
}
