package br.com.fiap_tc5.hackaton.infrastructure.repository;

import br.com.fiap_tc5.hackaton.infrastructure.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack, String> {
}
