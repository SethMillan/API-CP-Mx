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
@Table(name = "tablaedo")
public class Estado implements Serializable {
    @Id
    @Column(name="id_Edo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEdo;
    @Column(name="Estado")
    private String Estado;
}
