package br.com.fiap_tc5.hackaton.infrastructure.repository;

import br.com.fiap_tc5.hackaton.infrastructure.entity.PharmacyMedicineStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PharmacyMedicineStockRepository extends JpaRepository<PharmacyMedicineStock, Long> {

    List<PharmacyMedicineStock> findByIndicationCategoryId_IndicationAndMedicineName(String indication, String medicine);

    @Query("""
        SELECT p 
        FROM PharmacyMedicineStock p
        WHERE p.indicationCategoryId.indication = :indication
        AND p.medicineName = :medicine
    """)
    List<PharmacyMedicineStock> findByIndicationAndMedication(
            @Param("indication") String indication,
            @Param("medicine") String medication
    );
}
