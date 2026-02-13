package br.com.fiap_tc5.hackaton.controller.interfaceSwagger;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyMedicineStockResponse;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface FeedbackController {

    @PostMapping("/medication")
    @ResponseStatus(HttpStatus.CREATED)
    void registerFeedbackMedication(@RequestBody List<PharmacyMedicineStockResponse> request);

    @PostMapping("/pharmacy")
    @ResponseStatus(HttpStatus.CREATED)
     void registerFeedbackPharmacy(@RequestBody List<PharmacyResponse> request);
}
