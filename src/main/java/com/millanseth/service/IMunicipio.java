package com.millanseth.service;

import com.millanseth.model.entity.Municipio;

import java.util.List;

public interface IMunicipio {
    List<Municipio> listAll();
    Municipio findById(Integer id);
    List<Municipio> listAllById(Integer id);
}
