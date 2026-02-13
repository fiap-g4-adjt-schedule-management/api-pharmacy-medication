package br.com.fiap_tc5.hackaton.controller;

import br.com.fiap_tc5.hackaton.business.PharmacyService;
import br.com.fiap_tc5.hackaton.controller.interfaceSwagger.PharmacyController;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/pharmacy")
@RequiredArgsConstructor
public class PharmacyControllerImpl implements PharmacyController {

    private final PharmacyService pharmacyService;

    @GetMapping
    public List<PharmacyResponse> getAllPharmacy(@RequestParam @NotBlank String state,
                                                 @RequestParam @NotBlank String city,
                                                 @RequestParam @NotBlank String neighb){
        return pharmacyService.listPharmacy(state,city,neighb);
    }

}
