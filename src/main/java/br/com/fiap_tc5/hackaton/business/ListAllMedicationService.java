package br.com.fiap_tc5.hackaton.business;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.MedicationNameResponse;
import br.com.fiap_tc5.hackaton.infrastructure.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListAllMedicationService {

    private final MedicationRepository medicationRepository;

    public List<MedicationNameResponse> run(Long id){
        return medicationRepository.findByIndicationCategoryId(id);
    }
}
