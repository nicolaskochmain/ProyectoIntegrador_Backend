package com.portfolio.argentinaprograma.Controller;

import com.portfolio.argentinaprograma.Dto.DtoPersona;
import com.portfolio.argentinaprograma.Entity.Persona;
import com.portfolio.argentinaprograma.Security.Controller.Mensaje;
import com.portfolio.argentinaprograma.Service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontendap-7f297.web.app")
public class CPersona {
    @Autowired
    SPersona sPersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") int id) {
//        if(!sPersona.existsById(id))
//            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
//        sPersona.delete(id);
//        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
//    }
//    
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPersona) {
//        if(StringUtils.isBlank(dtoPersona.getNombre())) {
//            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//        if(sPersona.existsByNombre(dtoPersona.getNombre())) 
//            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
//        
//        Persona persona = new Persona(dtoPersona.getNombre(), dtoPersona.getDescripcion());
//        sPersona.save(persona);
//        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
//    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona) {
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        if(sPersona.existsByNombre(dtoPersona.getNombre()) && sPersona.getByNombre(dtoPersona.getNombre()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoPersona.getNombre()))
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = sPersona.getOne(id).get();
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setDescripcion(dtoPersona.getDescripcion());
        persona.setImg(dtoPersona.getImg());
        
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
