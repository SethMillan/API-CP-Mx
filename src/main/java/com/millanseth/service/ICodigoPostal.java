package com.millanseth.service;



import com.millanseth.model.entity.CodigoPostal;

import java.util.List;

public interface ICodigoPostal {
    List<CodigoPostal> listAll();
    CodigoPostal findById(Integer id);
    List<CodigoPostal> listAllById(Integer id_Mcpio, Integer id_Edo);
}
