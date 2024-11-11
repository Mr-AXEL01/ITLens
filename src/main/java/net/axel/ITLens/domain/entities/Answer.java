package net.axel.ITLens.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "answers")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(name = "text")
    private String text;

    @Column(name = "selection_count")
    private int selectionCount;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

}
