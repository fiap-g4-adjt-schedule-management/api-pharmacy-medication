package br.com.fiap_tc5.hackaton.infrastructure.repository;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.MedicationNameResponse;
import br.com.fiap_tc5.hackaton.infrastructure.entity.MedicationName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<MedicationName, String> {

    @Query("""
       SELECT new br.com.fiap_tc5.hackaton.infrastructure.dtos.MedicationNameResponse(
            m.medicineCode,
            m.medicineName
       )
       FROM MedicationName m
       WHERE m.indicationCategory.id = :id
       """)
    List<MedicationNameResponse> findByIndicationCategoryId(Long id);
}
