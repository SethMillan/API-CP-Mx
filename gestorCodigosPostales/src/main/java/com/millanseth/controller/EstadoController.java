package com.millanseth.controller;

import com.millanseth.model.entity.Estado;
import com.millanseth.service.IEstado;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.inject.Inject;

@Controller("/api/v1")
public class EstadoController {
    @Inject//injeccion de dependecias
    private IEstado estadoService;

    @Post("estado")//el requestbody hace que pase de json a objeto estado
    public Estado create(@RequestBody Estado estado){
        return estadoService.save(estado);
    }
    @Put("estado")
    public Estado update(@RequestBody Estado estado){
        return estadoService.save(estado);
    }
    @Delete("estado/{id}")
    public void delete(@PathVariable Integer id){
        Estado estadoDelete=estadoService.findById(id);
        estadoService.delete(estadoDelete);
    }
    @Get("estado/{id}")
    public Estado showById(@PathVariable Integer id){
        return estadoService.findById(id);
    }

}
