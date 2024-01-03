package com.millanseth.model.dto;

import com.millanseth.model.entity.Asentamiento;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class CodigoPostalDto implements Serializable {
    private Integer idEdo;
    private Integer idMunicipio;
    private String estado;
    private String municipio;
    private Asentamiento asentamiento;



}
