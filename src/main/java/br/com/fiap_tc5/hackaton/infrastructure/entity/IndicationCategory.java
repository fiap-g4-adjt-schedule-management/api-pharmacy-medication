package br.com.fiap_tc5.hackaton.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "indication_category")
public class IndicationCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "indication", length = 150, nullable = false)
    private String indication;

    @OneToMany(mappedBy = "indicationCategory")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<MedicationName> medicationName;

}
