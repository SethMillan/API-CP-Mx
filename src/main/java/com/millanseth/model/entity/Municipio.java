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
    @Column(name="id_mcpio")
    private Integer id;
    @Column(name="mcpio")
    private String Municipio;
    @ManyToOne
    @JoinColumn(name="id_Edo")
    private Estado estado;
}
