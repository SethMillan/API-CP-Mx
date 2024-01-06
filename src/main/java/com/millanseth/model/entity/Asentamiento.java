package com.millanseth.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tablaasenta")
public class Asentamiento {
    @Id
    @Column(name="Asenta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String asenta;

    @ManyToOne
    @JoinColumn(name="CP")
    private CodigoPostal codigoPostal;
}
