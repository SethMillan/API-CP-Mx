package com.millanseth.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class AsentamientoDto implements Serializable {
    private String asenta;
    private Integer codigoPostal;
    private Integer municipioID;
}
