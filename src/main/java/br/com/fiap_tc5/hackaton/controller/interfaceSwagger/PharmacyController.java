package br.com.fiap_tc5.hackaton.controller.interfaceSwagger;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.ErrorResponseDTO;
import br.com.fiap_tc5.hackaton.infrastructure.dtos.PharmacyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Tag(name = "Pharmacy Management", description = "API that provides information about pharmacies accredited to the \"Farmacia Popular\" program.")
public interface PharmacyController {

    @GetMapping("/pharmacys")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "See all accredited pharmacies.", description = "Find all available pharmacies in a specific region, filtering by state, city, and neighborhood.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Displays list of accredited pharmacies found."),
            @ApiResponse(responseCode = "400", description = "The request lacks resources.",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "No accredited pharmacies were found in the specified region.",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    List<PharmacyResponse> getAllPharmacy(@RequestParam @NotBlank String state,
                                          @RequestParam @NotBlank String city,
                                          @RequestParam @NotBlank String neighb);

}
