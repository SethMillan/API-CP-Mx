package com.millanseth.controller;

import com.millanseth.model.entity.Estado;
import com.millanseth.service.IEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EstadoController {
    @Autowired
    private IEstado estadoService;

    @PostMapping("estado")
    public Estado create (@RequestBody Estado estado){
        return estadoService.save(estado);
    }
    @PutMapping("estado")
    public Estado update (@RequestBody Estado estado){
        return estadoService.save(estado);
    }
    @DeleteMapping("estado/{id}")
    public void delete (@PathVariable Integer id){
        estadoService.delete(estadoService.findById(id));
    }
    @GetMapping("estado/{id}")
    public Estado showById(@PathVariable Integer id){
        return estadoService.findById(id);
    }

}
