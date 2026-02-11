package br.com.fiap_tc5.hackaton.infrastructure.dtos;

public record PharmacyResponse(String name,
                               String address,
                               String neighborhood,
                               String city,
                               String state) {
}
