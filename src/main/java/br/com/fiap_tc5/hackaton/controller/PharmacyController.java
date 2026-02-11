package br.com.fiap_tc5.hackaton.controller;

import br.com.fiap_tc5.hackaton.business.MedicineService;
import br.com.fiap_tc5.hackaton.business.PharmacyService;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyResponse;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyMedicineStockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PharmacyController {

    private final PharmacyService pharmacyService;
    private final MedicineService medicineService;

    @GetMapping("/farmacias")
    public List<PharmacyResponse> getAllPharmacy(@RequestParam String state,
                                                 @RequestParam String city,
                                                 @RequestParam String neighb){
        return pharmacyService.listPharmacy(state,city,neighb);
    }

    @GetMapping("/indicacao/{condicao}")
    public List<PharmacyMedicineStockResponse> listarIndicacao(@PathVariable String condicao,
                                                               @RequestParam String medication) {
        return medicineService.listByIndication(condicao, medication);
    }
}
