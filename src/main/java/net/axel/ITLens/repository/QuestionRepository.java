package net.axel.ITLens.repository;

import net.axel.ITLens.domain.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
    List<Question> findQuestionsByChapterId(UUID chapterId);
}
