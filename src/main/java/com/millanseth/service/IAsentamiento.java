package com.millanseth.service;


import com.millanseth.model.entity.Asentamiento;

import java.util.List;

public interface IAsentamiento {
    List<Asentamiento> listAll();
    Asentamiento findById(Integer id);
    List<Asentamiento> listAllById(Integer id);
    List<Asentamiento> findCPByMcpioAndEdo(Integer idMcpio, Integer idEdo);
}
