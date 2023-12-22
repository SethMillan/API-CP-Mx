package com.millanseth.service;

import com.millanseth.model.dto.EstadoDto;
import com.millanseth.model.entity.Estado;

public interface IEstado {
    EstadoDto save(Estado estado);
    EstadoDto findById(Integer id);
     void delete(EstadoDto estado);
}
