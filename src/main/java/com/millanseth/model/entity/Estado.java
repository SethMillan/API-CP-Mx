package com.millanseth.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
