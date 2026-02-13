package br.com.fiap_tc5.hackaton.business;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyMedicineStockResponse;
import br.com.fiap_tc5.hackaton.infrastructure.exception.ResourceNotFoundException;
import br.com.fiap_tc5.hackaton.infrastructure.repository.PharmacyMedicineStockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListPharmacyWithMedicationService {

    private final PharmacyMedicineStockRepository pharmacyMedicineStockRepository;
    private final FeedBackService feedBackService;

    public List<PharmacyMedicineStockResponse> run(String medicineCode,
                                                   String state,
                                                   String city,
                                                   String neighborhood){
        state = state.toUpperCase();
        city = city.toUpperCase();
        neighborhood = neighborhood.toUpperCase();
        log.info("Consult pharmacies accredited by: state={}, city={}, neighborhood={} and with medication {}", state, city, neighborhood, medicineCode);
        List<PharmacyMedicineStockResponse> stock = pharmacyMedicineStockRepository.findStockByLocationAndMedicine(state, city, neighborhood, medicineCode);

        if (stock.isEmpty()) {
            log.warn("No stock information found for accredited pharmacies in the specified location: state={}, city={}, neighborhood={} and with medication {}", state, city, neighborhood, medicineCode);
            throw  new ResourceNotFoundException("No stock information is available for accredited pharmacies in the specified region.");
        }

        feedBackService.savedFeedback(stock);

        return  stock;
    }

}
