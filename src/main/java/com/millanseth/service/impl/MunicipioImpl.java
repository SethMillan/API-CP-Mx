package com.millanseth.service.impl;

import com.millanseth.model.dao.MunicipioDAO;
import com.millanseth.model.entity.Municipio;
import com.millanseth.service.IMunicipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
@Service
public class MunicipioImpl implements IMunicipio {
    @Autowired
    private MunicipioDAO municipioDAO;
    @Transactional(readOnly = true)
    @Override
    public List<Municipio> listAll() {
        return (List)municipioDAO.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Municipio findById(Integer id) {
        return municipioDAO.findById(id).orElse(null);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Municipio> listAllById(Integer id) {
        return municipioDAO.findEstadoById(id);
    }
}
