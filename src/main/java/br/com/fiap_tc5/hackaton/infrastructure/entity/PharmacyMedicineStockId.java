package br.com.fiap_tc5.hackaton.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PharmacyMedicineStockId implements Serializable {

    @Column(name = "pharmacy_id", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "medicine_code", nullable = false)
    private String medicineCode;
}

