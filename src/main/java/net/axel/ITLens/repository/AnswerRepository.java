package net.axel.ITLens.repository;

import net.axel.ITLens.domain.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnswerRepository extends JpaRepository<Answer, UUID> {
}
