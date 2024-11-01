package net.axel.ITLens.repository;

import net.axel.ITLens.domain.entities.SurveyEdition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SurveyEditionRepository extends JpaRepository<SurveyEdition, UUID> {
}
