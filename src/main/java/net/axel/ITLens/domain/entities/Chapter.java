package net.axel.ITLens.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chapters")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Chapter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(name = "chapter_title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "parent_chapter_id")
    private Chapter parentChapter;

    @OneToMany(mappedBy = "parentChapter")
    private List<Chapter> subChapters = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "survey_edition_id", nullable = false)
    private SurveyEdition surveyEdition;
}
