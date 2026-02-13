package br.com.fiap_tc5.hackaton.infrastructure.repository;

import br.com.fiap_tc5.hackaton.infrastructure.entity.IndicationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicationCategoryRepository extends JpaRepository<IndicationCategory, Long> {
}
