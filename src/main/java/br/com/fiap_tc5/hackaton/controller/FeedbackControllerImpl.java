package br.com.fiap_tc5.hackaton.controller;

import br.com.fiap_tc5.hackaton.business.FeedBackService;
import br.com.fiap_tc5.hackaton.controller.interfaceSwagger.FeedbackController;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyMedicineStockResponse;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackControllerImpl implements FeedbackController {

    private final FeedBackService feedBackService;

    @PostMapping("/medication")
    public void registerFeedbackMedication(@RequestBody List<PharmacyMedicineStockResponse> request){
        feedBackService.saveFeedbackPharmacyandMedication(request);
    }

    @PostMapping("/pharmacy")
    public void registerFeedbackPharmacy(@RequestBody List<PharmacyResponse> request){
        feedBackService.saveFeedbackPharmacy(request);
    }

}
