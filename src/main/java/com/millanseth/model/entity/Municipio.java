package com.millanseth.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tablamcpio")
public class Municipio implements Serializable {
    @Id
    @Column(name="id_Mcpio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMcpio;
    @Column(name="mcpio")
    private String Municipio;
    @Column(name="id_Edo")
    private Integer idEdo;
}
