package com.millanseth.service.impl;

import com.millanseth.model.dao.CodigoPostalDAO;
import com.millanseth.model.entity.CodigoPostal;
import com.millanseth.service.ICodigoPostal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CodigoPostalImpl implements ICodigoPostal {
    @Autowired
    private CodigoPostalDAO codigoPostalDAO;

    @Transactional(readOnly = true)
    @Override
    public List<CodigoPostal> listAll() {
        return (List<CodigoPostal>) codigoPostalDAO.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public CodigoPostal findById(Integer id) {
        return codigoPostalDAO.findById(id).orElse(null);
    }
    @Transactional(readOnly = true)
    @Override
    public List<CodigoPostal> listAllById(Integer id_Mcpio, Integer id_Edo) {
        return codigoPostalDAO.findCodigoPostalByMunicipioAndEstado(id_Mcpio,id_Edo);
    }
}
