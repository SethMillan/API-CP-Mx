package com.millanseth.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class MunicipioDto {

    private Integer idMcpio;
    private String Municipio;
    private Integer idEdo;
}
