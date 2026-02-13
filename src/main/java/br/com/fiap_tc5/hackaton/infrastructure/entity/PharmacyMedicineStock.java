package br.com.fiap_tc5.hackaton.infrastructure.entity;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.type.StockStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "pharmacy_medicine_stock",
        indexes = {
                @Index(name = "idx_pharmacy", columnList = "pharmacy_id"),
                @Index(name = "idx_medicine", columnList = "medicine_code")
        })
public class PharmacyMedicineStock {

    @EmbeddedId
    private PharmacyMedicineStockId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacy_id", nullable = false)
    @MapsId("cnpj")
    private Pharmacy pharmacy;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "medicine_code",nullable = false)
    @MapsId("medicineCode")
    private MedicationName medication;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "stock_status", nullable = false)
    private StockStatus stockStatus;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime    updatedAt;

}
