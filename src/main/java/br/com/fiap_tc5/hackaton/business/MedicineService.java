package br.com.fiap_tc5.hackaton.business;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyResponse;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyMedicineStockResponse;
import br.com.fiap_tc5.hackaton.infrastructure.repository.PharmacyMedicineStockRepository;
import br.com.fiap_tc5.hackaton.infrastructure.utils.StringNormalize;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final PharmacyMedicineStockRepository pharmacyMedicineStockRepository;

    public List<PharmacyMedicineStockResponse> listByIndication(String indication, String medication){
        indication = StringNormalize.normalize(indication);
        return pharmacyMedicineStockRepository.findByIndicationCategoryId_IndicationAndMedicineName(indication, medication)
                .stream()
                .map(p -> {
                    return new PharmacyMedicineStockResponse(
                            p.getMedicineCode(),
                            p.getMedicineName(),
                            p.getQuantity(),
                            p.getStockStatus(),
                            new PharmacyResponse(
                                    p.getPharmacyId().getName(),
                                    p.getPharmacyId().getAddress(),
                                    p.getPharmacyId().getNeighborhood(),
                                    p.getPharmacyId().getCity(),
                                    p.getPharmacyId().getState()
                            )
                    );
                }).toList();
    }

}
