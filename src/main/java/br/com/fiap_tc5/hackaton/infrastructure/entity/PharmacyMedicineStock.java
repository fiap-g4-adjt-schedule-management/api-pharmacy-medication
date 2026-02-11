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
@Table(name = "pharmacy_medicine_stock")
public class PharmacyMedicineStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacy_id", nullable = false)
    private Pharmacy pharmacyId;

    @Column(name = "medicine_code", nullable = false)
    private String medicineCode;//entidade de medicamento

    @Column(name = "medicine_name", nullable = false)
    private String medicineName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indication_category_id", nullable = false)
    private IndicationCategory indicationCategoryId;//entidade de categoria de indicação

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "stock_status", nullable = false)
    private StockStatus stockStatus;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime updatedAt;

}
