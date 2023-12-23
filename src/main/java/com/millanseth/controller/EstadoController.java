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
    public EstadoDto create (@RequestBody EstadoDto estadoDto){
        Estado estadoSave=estadoService.save(estadoDto);
        return EstadoDto.builder().idEdo(estadoSave.getIdEdo()).Estado(estadoSave.getEstado()).build();
    }


    @PutMapping("estado")
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoDto update (@RequestBody EstadoDto estadoDto){
        Estado estadoUpdate = estadoService.save(estadoDto);
        return EstadoDto.builder().idEdo(estadoUpdate.getIdEdo()).Estado(estadoUpdate.getEstado()).build();
    }


    @DeleteMapping("estado/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete (@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            Estado estadoDelete=estadoService.findById(id);
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
    public EstadoDto showById(@PathVariable Integer id) {
        Estado estado= estadoService.findById(id);
        return EstadoDto.builder().idEdo(estado.getIdEdo()).Estado(estado.getEstado()).build();
    }

}
