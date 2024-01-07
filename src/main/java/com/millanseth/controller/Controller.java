package com.millanseth.controller;

import com.millanseth.model.dao.CodigoPostalDAO;
import com.millanseth.model.dto.CodigoPostalDto;
import com.millanseth.model.dto.EstadoDto;
import com.millanseth.model.dto.MunicipioDto;
import com.millanseth.model.entity.CodigoPostal;
import com.millanseth.model.entity.Estado;
import com.millanseth.model.entity.Municipio;
import com.millanseth.payload.MensajeResponse;
import com.millanseth.service.IAsentamiento;
import com.millanseth.service.ICodigoPostal;
import com.millanseth.service.IEstado;
import com.millanseth.service.IMunicipio;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")//Esta es la direccion a donde nos vamos a conectar, indicamos que es una api y que es la version 1
public class Controller {
    @Autowired//inyeccion de dependencias
    private IEstado estadoService;
    @Autowired
    private IMunicipio municipioService;
    @Autowired
    private ICodigoPostal codigoService;
    @Autowired
    private IAsentamiento asentamientoService;
    @GetMapping("estados")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAll() {
        List<Estado> listaEstados= estadoService.listAll();
        if (listaEstados==null){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .error(true)
                            .mensaje("No hay estados registrados")
                            .object(null).build(),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .error(false)
                            .mensaje("Estados encontrados :"+listaEstados.size())
                            .object(listaEstados)
                            .build()
                    ,HttpStatus.OK);
        }
    }
    @GetMapping("municipios")
@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAllMunicipios(){
        List<MunicipioDto> listaMunicipios= municipioService.listAll().stream().map(municipio -> MunicipioDto.builder().idEdo(municipio.getEstado().getIdEdo()).idMcpio(municipio.getId()).Municipio(municipio.getMunicipio()).build()).toList();
        if (listaMunicipios==null){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .error(true)
                            .mensaje("No hay estados registrados")
                            .object(null).build(),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .error(false)
                            .mensaje("Estados encontrados : "+listaMunicipios.size())
                            .object(listaMunicipios)
                            .build()
                    ,HttpStatus.OK);
        }
    }
    @GetMapping("municipios/estado/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> mostrarMcpios(@PathVariable Integer id){
           try{
                    List<Municipio> listMunicipios = municipioService.listAllById(id);
                    List<MunicipioDto>municipiosDTO = listMunicipios.stream()
                            .map(municipio -> MunicipioDto.builder()
                                    .idEdo(municipio.getEstado().getIdEdo())
                                    .idMcpio(municipio.getId())
                                    .Municipio(municipio.getMunicipio())
                                    .build())
                            .collect(Collectors.toList());

                if (listMunicipios==null){
                    return new ResponseEntity<>(
                            MensajeResponse.builder()
                                    .error(true)
                                    .mensaje("No hay municipios registrados")
                                    .object(null).build(),
                            HttpStatus.OK);
                }else{
                    int tamaño= municipiosDTO.size();
                    return new ResponseEntity<>(
                            MensajeResponse.builder()
                                    .error(false)
                                    .mensaje("Municipios encontrados : "+tamaño)
                                    .object(listMunicipios)
                                    .build()
                            ,HttpStatus.OK);
                }
            }catch (Exception exDt)

        {
        return new ResponseEntity<>(
                MensajeResponse.builder().error(true).mensaje(exDt.getMessage()).object(null).build(),
                HttpStatus.METHOD_NOT_ALLOWED);//el http response que mandamos sera uno de error
        }
    }

    @GetMapping("codigospostales")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAllCp(){
        try {
            List<CodigoPostal> listaCP = codigoService.listAll();
            List<CodigoPostalDto> listaDto = listaCP.stream()
                    .map(codigoPostal -> CodigoPostalDto.builder()
                            .idEdo(codigoPostal.getMunicipio().getEstado().getIdEdo())
                            .estado(codigoPostal.getMunicipio().getEstado().getEstado())
                            .idMcpio(codigoPostal.getMunicipio().getId())
                            .municipio(codigoPostal.getMunicipio().getMunicipio())
                            .codigoPostal(codigoPostal.getCp())
                            .build()
                    ).toList();
            return new ResponseEntity<>(MensajeResponse.builder().error(false).mensaje("Codigos totales ").object(listaCP).build(),HttpStatus.OK);
        }catch (Exception ext ){
            return new ResponseEntity<>(MensajeResponse.builder().error(true).mensaje("Error encontrado "+ext).object(null).build(),HttpStatus.OK);
        }
    }
    @GetMapping("asentamientos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAllAsenta(){
        return null;
    }

    @GetMapping("codigospostales/estado/{idEstado}/municipio/{idMcpio}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>showFilterCP(@PathVariable Integer idEstado, @PathVariable Integer idMcpio){
        List<CodigoPostal> listaCodigos = codigoService.listAllById(idMcpio,idEstado);
        List<CodigoPostalDto> codigoDto;
        codigoDto = listaCodigos.stream()
                .map(codigopostal -> CodigoPostalDto.builder()
                        .idEdo(codigopostal.getMunicipio().getEstado().getIdEdo())
                        .idMcpio(codigopostal.getMunicipio().getId())
                        .estado(codigopostal.getMunicipio().getEstado().getEstado())
                        .municipio(codigopostal.getMunicipio().getMunicipio())
                        .codigoPostal(codigopostal.getCp())
                        .build())
                .collect(Collectors.toList());

    return new ResponseEntity<>(MensajeResponse.builder().error(false).mensaje("Numero de CP encontrados : "+codigoDto.size()).object(codigoDto).build(), HttpStatus.NOT_FOUND);

    }

    //Esto deberia ser de asentamientos entonces el codigoService deberia ser un asentamientoService
    /*
    @GetMapping("asentamiento/asentamientos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showCP(@PathVariable Integer id){
        List<CodigoPostal> codigo=codigoService.listAllById(id);//aqui obviamente hay un error por lo  ya mencionado
        List<CodigoPostalDto> codigoDto = codigo.stream().map(codigoPostal -> CodigoPostalDto
                .builder()
                .idEdo(codigoPostal.getMunicipio().getEstado().getIdEdo())
                .idMcpio(codigoPostal.getMunicipio().getId())
                .municipio(codigoPostal.getMunicipio().getMunicipio())
                .codigoPostal(codigoPostal.getCp())
                .build()).toList();
        return new ResponseEntity<>(MensajeResponse.builder().error(false).mensaje("").object(codigoDto).build(),HttpStatus.OK);
    }*/

    @PostMapping("estado")//para el metodo post solo "estado"
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create (@RequestBody EstadoDto estadoDto){//retorna un response entity para el manejo de httpstatus y los mensajes en caso de errores
        Estado estadoSave=null;     //el requestbody es para que retorne un json o algo asi
        try{
            estadoSave=estadoService.save(estadoDto);
            estadoDto=EstadoDto.builder()
                    .idEdo(estadoSave.getIdEdo())
                    .Estado(estadoSave.getEstado()).build();
            //mediante el builder del DTO guardamos toda la informacion, recoordando cerrarlo con el build()
            return new ResponseEntity<>(MensajeResponse.builder().error(false)
                    .mensaje("Guardado correctamente").object(estadoDto).build(),HttpStatus.CREATED);
            //aqui retornamos el response entity con el mensajeresponse y el objeto que acabamos de buildear
        }catch (DataAccessException exDt){//aqui atrapamos el error en caso de haber
            return new ResponseEntity<>(
                    MensajeResponse.builder().error(true).mensaje(exDt.getMessage()).object(null).build(),
                    HttpStatus.METHOD_NOT_ALLOWED);//el http response que mandamos sera uno de error
        }
    }


    @PutMapping("estado")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update (@RequestBody EstadoDto estadoDto){//lo mismo, en este caso es update para el put
        Estado estadoUpdate=null;
        try{
            estadoUpdate = estadoService.save(estadoDto);//el metodo save sirve para lo mismo en este caso
            estadoDto=EstadoDto.builder().idEdo(estadoUpdate.getIdEdo()).Estado(estadoUpdate.getEstado()).build();
            //buildeamos el dto
            return new ResponseEntity<>(MensajeResponse.builder()
                    .error(false)
                    .mensaje("Actualizado correctamente")
                    .object(estadoDto).build()
                    ,HttpStatus.CREATED);
            //retornamos el response entity con un mensajeresponse y un mensaje de todo correcto y el objeto que buildeamos
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(
                    MensajeResponse.builder().error(true).mensaje(exDt.getMessage()).object(null).build(),
                    HttpStatus.METHOD_NOT_ALLOWED);//aqui mandamos la respuesta negativa y el error que se atrapo
        }
    }


    @DeleteMapping("estado/{id}")//en caso de querer borrar algo tenemos que especificarlo con su id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete (@PathVariable Integer id){//aqui mandamos un path variable indicando que hay una variable en laURL
        try {
            Estado estadoDelete=estadoService.findById(id);//solamente ocupamos el findbyid
            estadoService.delete(estadoDelete);
            return new ResponseEntity<>(estadoDelete,HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(
                    MensajeResponse.builder().error(true).mensaje(exDt.getMessage()).object(null).build(),
                    HttpStatus.METHOD_NOT_ALLOWED);//en caso de no encontrarlo manda un objeto nulo y un mensaje de error
        }
    }


    @GetMapping("estado/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Estado estado= estadoService.findById(id);
        if (estado==null){
            return new ResponseEntity<>(
                    MensajeResponse.builder().error(true).mensaje("El registro que intenta buscar no existe").object(null).build(),
                    HttpStatus.NOT_FOUND);//en caso de no encontrarlo manda un objeto nulo y un mensaje de error
        }else{
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .error(false)
                            .mensaje("Encontrado")
                            .object(
                                    EstadoDto.builder()
                                            .idEdo(estado.getIdEdo())
                                            .Estado(estado.getEstado())
                                            .build()
                            ).build()
                    ,HttpStatus.OK);
        }
    }

}
