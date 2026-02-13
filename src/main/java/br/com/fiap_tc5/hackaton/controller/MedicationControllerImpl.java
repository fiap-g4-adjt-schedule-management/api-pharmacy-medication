package br.com.fiap_tc5.hackaton.controller;

import br.com.fiap_tc5.hackaton.business.ListIndicationCategory;
import br.com.fiap_tc5.hackaton.business.ListAllMedicationService;
import br.com.fiap_tc5.hackaton.business.ListPharmacyWithMedicationService;
import br.com.fiap_tc5.hackaton.controller.interfaceSwagger.MedicationController;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.IndicationCategoryResponse;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.MedicationNameResponse;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyMedicineStockResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/medication")
@RequiredArgsConstructor
public class MedicationControllerImpl implements MedicationController {

    private final ListPharmacyWithMedicationService listPharmacyWithMedicationService;
    private final ListAllMedicationService listAllMedicationService;
    private final ListIndicationCategory listIndicationCategory;


    @Override
    public List<IndicationCategoryResponse> listIndicationCategory() {
        return listIndicationCategory.run();
    }

    @GetMapping("/{id}")
    public List<MedicationNameResponse> listMedication(@PathVariable Long id) {
        return listAllMedicationService.run(id);
    }

    @GetMapping("/{medication}/pharmacys")
    public List<PharmacyMedicineStockResponse> listPharmacyWithMedication(
            @PathVariable String medication,
            @RequestParam @NotBlank String state,
            @RequestParam @NotBlank String city,
            @RequestParam @NotBlank String neighb
    ) {
        return listPharmacyWithMedicationService.run(medication,state,city,neighb);
    }
}
