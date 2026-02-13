package br.com.fiap_tc5.hackaton.business;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyResponse;
import br.com.fiap_tc5.hackaton.infrastructure.exception.ResourceNotFoundException;
import br.com.fiap_tc5.hackaton.infrastructure.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    public List<PharmacyResponse> listPharmacy(String state, String city, String neighborhood){
        state = state.toUpperCase();
        city = city.toUpperCase();
        neighborhood = neighborhood.toUpperCase();
        log.info("check pharmacies accredited by: state={}, city={}, neighborhood={}", state, city, neighborhood);
        List<PharmacyResponse> list = pharmacyRepository.findPharmaciesByStateAndCityAndNeighborhood(state, city, neighborhood)
                .stream()
                .map(p -> new PharmacyResponse(
                        p.getName(),
                        p.getAddress(),
                        p.getNeighborhood(),
                        p.getCity(),
                        p.getState()
                )).toList();

        if (list.isEmpty()) {
            log.warn("No accredited pharmacies found for the specified location: state={}, city={}, neighborhood={}", state, city, neighborhood);
            throw new ResourceNotFoundException("No accredited pharmacies were found in the specified region.");
        }

        return list;
    }

}
