package com.millanseth.service;

import com.millanseth.model.dto.EstadoDto;
import com.millanseth.model.entity.Estado;

public interface IEstado {
    Estado save(EstadoDto estado);
    Estado findById(Integer id);
     void delete(Estado estado);
}
