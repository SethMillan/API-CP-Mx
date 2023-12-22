package com.millanseth.model.dto;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder
public class EstadoDto implements Serializable {

    private Integer idEdo;
    private String Estado;
}
