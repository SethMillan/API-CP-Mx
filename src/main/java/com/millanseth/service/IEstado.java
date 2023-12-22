package com.millanseth.service;

import com.millanseth.model.entity.Estado;

public interface IEstado {
    Estado save(Estado estado);
    Estado findById(Integer id);
     void delete(Estado estado);
}
