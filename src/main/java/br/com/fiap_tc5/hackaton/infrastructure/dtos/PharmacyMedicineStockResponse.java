package br.com.fiap_tc5.hackaton.infrastructure.dtos;

import br.com.fiap_tc5.hackaton.infrastructure.dtos.type.StockStatus;

public record PharmacyMedicineStockResponse(String medicineCode,
                                            String medicineName,
                                            Integer quantity,
                                            StockStatus stockStatus,
                                            PharmacyResponse pharmacyUnit) {
}
