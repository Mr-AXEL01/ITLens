package net.axel.ITLens.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;
import java.util.UUID;

@Entity
@Table(name = "survey_editions")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class SurveyEdition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @NotNull
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotNull
    @Size(min = 4, max = 4)
    @Column(name = "year")
    private Year year;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;
}
