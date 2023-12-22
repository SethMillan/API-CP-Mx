package com.millanseth.service.impl;

import com.millanseth.model.dao.EstadoDAO;
import com.millanseth.model.dto.EstadoDto;
import com.millanseth.model.entity.Estado;
import com.millanseth.service.IEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoImpl implements IEstado {
    @Autowired
    private EstadoDAO estadoDAO;

    @Transactional
    @Override
    public EstadoDto save(EstadoDto estado) {
        return estadoDAO.save(estado);
    }
    @Transactional(readOnly = true)
    @Override
    public EstadoDto findById(Integer id) {
        return estadoDAO.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(EstadoDto estado) {
        estadoDAO.delete(estado);
    }
}
