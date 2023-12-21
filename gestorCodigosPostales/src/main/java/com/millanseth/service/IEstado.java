package com.millanseth.service;

import com.millanseth.model.entity.Estado;

public interface IEstado {
    Estado save(Estado estado);//save guarda y actualiza la informacion
    Estado findById(Integer id);
    void delete(Estado estado);


}
