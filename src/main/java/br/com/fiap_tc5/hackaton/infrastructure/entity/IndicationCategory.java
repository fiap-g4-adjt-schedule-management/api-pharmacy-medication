package br.com.fiap_tc5.hackaton.infrastructure.entity;

import br.com.fiap_tc5.hackaton.medicamentos.infrastructure.entity.medicamento.Medicamento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "indiciation_category")
public class IndicationCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "indication", length = 150, nullable = false)
    private String indication;

    @OneToMany(mappedBy = "indicationCategoryId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<PharmacyMedicineStock> pharmacyMedicineStocks;

}
