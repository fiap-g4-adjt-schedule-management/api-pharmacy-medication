package br.com.fiap_tc5.hackaton.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "feedback")
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "consultation", columnDefinition =  "TEXT")
    private String consultation;

    @Column
    private boolean isEvaluated = false;

    public FeedBack(String string, boolean b) {
        this.consultation = string;
        this.isEvaluated = true;
    }
}
