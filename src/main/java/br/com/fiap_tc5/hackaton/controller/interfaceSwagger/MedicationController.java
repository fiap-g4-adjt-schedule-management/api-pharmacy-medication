package br.com.fiap_tc5.hackaton.controller.interfaceSwagger;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Tag(name = "Medication Management", description = "API that provides information about pharmacies accredited to the \"Farmacia Popular\" program.")
public interface MedicationController {

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "list of Indication Category \"Farmácia Popular\".", description = "Displays the list of Indication Category from the government's \"Popular Pharmacy\" program.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List all Indication Category."),
            @ApiResponse(responseCode = "400", description = "The request lacks resources.",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping
    List<IndicationCategoryResponse> listIndicationCategory();

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Displays the list of medications available at the \"Farmácia Popular\".", description = "Displays the list of medications from the government's \"Popular Pharmacy\" program.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List all medication."),
            @ApiResponse(responseCode = "400", description = "The request lacks resources.",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/{id}")
    List<MedicationNameResponse> listMedication(@PathVariable Long id);


    @GetMapping("/{medication}/pharmacys")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "List of pharmacies authorized to purchase this medication.", description = "Lists accredited pharmacies that carry the medication you are looking for.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of accredited pharmacies found."),
            @ApiResponse(responseCode = "400", description = "The request lacks resources.",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "No accredited pharmacies were found in the specific region that carry the medication.",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    List<PharmacyMedicineStockResponse> listPharmacyWithMedication(@PathVariable String medication,
                                                                   @RequestParam @NotBlank String state,
                                                                   @RequestParam @NotBlank String city,
                                                                   @RequestParam @NotBlank String neighb);

}
