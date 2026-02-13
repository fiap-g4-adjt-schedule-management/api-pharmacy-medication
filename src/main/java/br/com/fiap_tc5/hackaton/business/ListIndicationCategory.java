package br.com.fiap_tc5.hackaton.business;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.IndicationCategoryResponse;
import br.com.fiap_tc5.hackaton.infrastructure.repository.IndicationCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListIndicationCategory {

    private final IndicationCategoryRepository indicationCategoryRepository;

    public List<IndicationCategoryResponse> run(){
        return indicationCategoryRepository.findAll()
                .stream()
                .map(i -> new IndicationCategoryResponse(
                        i.getId(),
                        i.getIndication()
                )).toList();
    }
}
