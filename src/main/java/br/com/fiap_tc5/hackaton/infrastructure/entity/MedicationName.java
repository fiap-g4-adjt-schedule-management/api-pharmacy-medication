package br.com.fiap_tc5.hackaton.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "medication_name")
public class MedicationName {

    @Id
    @Column(name = "medicine_code", nullable = false)
    private String medicineCode;

    private String medicineName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indication_category_id", nullable = false)
    private IndicationCategory indicationCategory;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "medication", fetch = FetchType.LAZY)
    private List<PharmacyMedicineStock> pharmacyMedicineStock = new ArrayList<>();
}
