package com.millanseth.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "TablaEdo")
public class Estado implements Serializable {
    //esto es necesario para que la entidad relacione las variables con la tabla
    @Id
    @Column(name = "id_Edo")
    private Integer id;
    @Column(name="Estado")
    private String nombre;
}
