package net.axel.ITLens.repository;

import net.axel.ITLens.domain.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SurveyRepository extends JpaRepository<Survey, UUID> {
}