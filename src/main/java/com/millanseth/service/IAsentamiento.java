package com.millanseth.service;


import com.millanseth.model.entity.Asentamiento;

import java.util.List;

public interface IAsentamiento {
    List<Asentamiento> listAll();
    Asentamiento findById(String id);
    List<Asentamiento> listAllById(Integer id);
}
