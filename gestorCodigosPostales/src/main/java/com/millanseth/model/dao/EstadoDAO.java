package com.millanseth.model.dao;

import com.millanseth.model.entity.Estado;
import io.micronaut.data.repository.CrudRepository;
//ocupamos el crud repository si tenemos poquillos datos, aqui son bastantes
//entonces mejor que sea paginado jeje
import io.micronaut.data.repository.PageableRepository;
import jakarta.inject.Singleton;

public interface EstadoDAO extends CrudRepository<Estado, Integer> {

}
