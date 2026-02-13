package br.com.fiap_tc5.hackaton.business;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyMedicineStockResponse;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyResponse;
import br.com.fiap_tc5.hackaton.infrastructure.entity.FeedBack;
import br.com.fiap_tc5.hackaton.infrastructure.repository.FeedbackRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedBackService {

    private final FeedbackRepository feedbackRepository;
    private final ObjectMapper objectMapper;

    public void savedFeedback(List<?> request) {
        try {
            String consultationJson = objectMapper.writeValueAsString(request);

            FeedBack feedBack = new FeedBack(
                    consultationJson,
                    true
            );
            feedbackRepository.save(feedBack);

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter lista para JSON", e);
        }
    }
}
