package com.millanseth.service.impl;

import com.millanseth.model.dao.EstadoDAO;
import com.millanseth.model.entity.Estado;
import com.millanseth.service.IEstado;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton//en springboot se usa service, aqui es singleton
public class EstadoIMPL implements IEstado {
//aqui hacemos el match con lo que se tiene en el dao, para que la informacion que se reciba
//se procese y se envie hacia alla
    @Inject//en springboot se usa autowired, aqui es inject
    private EstadoDAO estadoDAO;//a esto necesitamos hacerle una inyeccion de dependencias
    @Transactional
    @Override
    public Estado save(Estado estado) {
        return estadoDAO.save(estado);
    }
    @Transactional(readOnly = true)
    @Override
    public Estado findById(Integer id) {
        return estadoDAO.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Estado estado) {
        estadoDAO.delete(estado);
    }
}
