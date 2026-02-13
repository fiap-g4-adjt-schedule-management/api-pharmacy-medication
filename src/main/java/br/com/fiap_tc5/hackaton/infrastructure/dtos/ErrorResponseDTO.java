package br.com.fiap_tc5.hackaton.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponseDTO {

    private String type;
    private String title;
    private int status;
    private String detail;
    private String instance;

}
