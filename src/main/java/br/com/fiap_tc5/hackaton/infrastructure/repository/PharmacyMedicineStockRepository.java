package br.com.fiap_tc5.hackaton.infrastructure.repository;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyMedicineStockResponse;
import br.com.fiap_tc5.hackaton.infrastructure.entity.PharmacyMedicineStock;
import br.com.fiap_tc5.hackaton.infrastructure.entity.PharmacyMedicineStockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyMedicineStockRepository extends JpaRepository<PharmacyMedicineStock, PharmacyMedicineStockId> {

    @Query("""
        SELECT new br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyMedicineStockResponse(
            m.medicineCode,
            m.medicineName,
            s.quantity,
            s.stockStatus,
            new br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyResponse(
                p.name,
                p.address,
                p.neighborhood,
                p.city,
                p.state
            )
        )
        FROM PharmacyMedicineStock s
        JOIN s.pharmacy p
        JOIN s.medication m
        WHERE p.state = :state
          AND p.city = :city
          AND p.neighborhood = :neighborhood
          AND m.medicineCode = :medicineCode
    """)
    List<PharmacyMedicineStockResponse> findStockByLocationAndMedicine(
            @Param("state") String state,
            @Param("city") String city,
            @Param("neighborhood") String neighborhood,
            @Param("medicineCode") String medicineCode
    );
}
