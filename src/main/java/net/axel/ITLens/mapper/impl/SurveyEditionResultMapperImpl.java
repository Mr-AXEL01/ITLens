package net.axel.ITLens.mapper.impl;

import net.axel.ITLens.domain.dtos.answer.EmbeddedAnswerDTO;
import net.axel.ITLens.domain.dtos.chapter.NestedChapterDTO;
import net.axel.ITLens.domain.dtos.question.NestedQuestion;
import net.axel.ITLens.domain.dtos.survey.EmbeddedSurveyDTO;
import net.axel.ITLens.domain.dtos.surveyEdition.ResultsDTO;
import net.axel.ITLens.domain.entities.*;
import net.axel.ITLens.mapper.SurveyEditionResultMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
public class SurveyEditionResultMapperImpl implements SurveyEditionResultMapper {
    @Override
    public ResultsDTO mapToResultDto(SurveyEdition surveyEdition) {
        Survey survey = surveyEdition.getSurvey();

        EmbeddedSurveyDTO embeddedSurveyDTO = new EmbeddedSurveyDTO(
                survey.getId(),
                survey.getTitle(),
                survey.getDescription()
        );

        List<NestedChapterDTO> chapters = mapToNestedChapter(
                getParentChapters(surveyEdition)
        );
        return new ResultsDTO(embeddedSurveyDTO, chapters);
    }

    private List<Chapter> getParentChapters(SurveyEdition surveyEdition) {
        return surveyEdition.getChapters()
                .stream().filter(Chapter::isParentChapter)
                .toList();
    }

    private List<NestedChapterDTO> mapToNestedChapter(Collection<Chapter> chapters) {
        return chapters.stream()
                .map(chapter -> new NestedChapterDTO(
                                chapter.getId(),
                                chapter.getTitle(),
                                mapToNestedChapter(chapter.getSubChapters()),
                                mapToQuestion(chapter.getQuestions()))
                )
                .toList();
    }

    private List<NestedQuestion> mapToQuestion(List<Question> questions) {
        return questions.stream()
                .map(question -> new NestedQuestion(
                                question.getId(),
                                question.getText(),
                                mapToAnswerEmbeddable(question.getAnswers()),
                                question.getAnswerCount()
                        ))
                .toList();
    }

    private List<EmbeddedAnswerDTO> mapToAnswerEmbeddable(Set<Answer> answers) {
        return answers.stream()
                .map(answer -> new EmbeddedAnswerDTO(
                                answer.getId(),
                                answer.getText(),
                                answer.getSelectionCount()
                ))
                .toList();
    }
}