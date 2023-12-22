package com.millanseth.controller;

import com.millanseth.model.dto.EstadoDto;
import com.millanseth.model.entity.Estado;
import com.millanseth.service.IEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EstadoController {
    @Autowired
    private IEstado estadoService;

    @PostMapping("estado")
    @ResponseStatus(HttpStatus.CREATED)
    public Estado create (@RequestBody EstadoDto estado){
        return estadoService.save(estado);
    }
    @PutMapping("estado")
    @ResponseStatus(HttpStatus.CREATED)
    public Estado update (@RequestBody EstadoDto estado){
        return estadoService.save(estado);
    }

    @DeleteMapping("estado/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete (@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            EstadoDto estadoDelete=estadoService.findById(id);
            estadoService.delete(estadoDelete);
            return new ResponseEntity<>(estadoDelete,HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt){
            response.put("mensaje",exDt.getMessage());
            response.put("cliente",null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("estado/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EstadoDto showById(@PathVariable Integer id){
        return estadoService.findById(id);
    }

}
