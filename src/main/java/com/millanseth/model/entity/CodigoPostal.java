package com.millanseth.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="tablacp")
public class CodigoPostal {
    @Id
    @Column(name="CP")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cp;
    @ManyToOne
    @JoinColumn(name="id_Mcpio")
    private Municipio municipio;
}
