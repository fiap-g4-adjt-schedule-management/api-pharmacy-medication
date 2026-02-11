package br.com.fiap_tc5.hackaton.business;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyResponse;
import br.com.fiap_tc5.hackaton.medicamentos.infrastructure.entity.farmacia.CadFarmacia;
import br.com.fiap_tc5.hackaton.medicamentos.infrastructure.entity.farmacia.Municipio;
import br.com.fiap_tc5.hackaton.medicamentos.infrastructure.entity.farmacia.UF;
import br.com.fiap_tc5.hackaton.infrastructure.repository.PharmacyRepository;
import br.com.fiap_tc5.hackaton.medicamentos.infrastructure.repository.farmacia.CadFarmaciaRepository;
import br.com.fiap_tc5.hackaton.medicamentos.infrastructure.repository.farmacia.MunicipioRepository;
import br.com.fiap_tc5.hackaton.medicamentos.infrastructure.repository.farmacia.UFRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    public List<PharmacyResponse> listPharmacy(String state, String city, String neighborhood){
        //state = StringNormalize.normalize(state);
        //city = StringNormalize.normalize(city);
        //neighborhood = StringNormalize.normalize(neighborhood);
        return pharmacyRepository.findPharmaciesByStateAndCityAndNeighborhood(state, city, neighborhood)
                .stream()
                .map(p -> new PharmacyResponse(
                        p.getName(),
                        p.getAddress(),
                        p.getNeighborhood(),
                        p.getCity(),
                        p.getState()
                )).toList();
    }

}
