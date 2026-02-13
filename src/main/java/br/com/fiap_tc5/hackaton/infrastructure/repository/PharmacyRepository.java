package br.com.fiap_tc5.hackaton.infrastructure.repository;

import br.com.fiap_tc5.hackaton.infrastructure.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, String> {

    List<Pharmacy> findPharmaciesByStateAndCityAndNeighborhood(String state, String city, String neighborhood);
}
