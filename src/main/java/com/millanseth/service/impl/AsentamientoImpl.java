package com.millanseth.service.impl;

import com.millanseth.model.dao.AsentamientoDAO;
import com.millanseth.model.entity.Asentamiento;
import com.millanseth.service.IAsentamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AsentamientoImpl implements IAsentamiento {
    @Autowired
    private AsentamientoDAO asentamientoDAO;
    @Override
    public List<Asentamiento> listAll() {
        return (List)asentamientoDAO.findAll();
    }

    @Override
    public Asentamiento findById(Integer id) {
        return asentamientoDAO.findById(id).orElse(null);
    }

    @Override
    public List<Asentamiento> listAllById(Integer id) {
        return asentamientoDAO.findCPById(id);
    }

    @Override
    public List<Asentamiento> findCPByMcpioAndEdo(Integer idMcpio, Integer idEdo) {
        return asentamientoDAO.findCPByMcpioAndEdo(idMcpio,idEdo);
    }
}
