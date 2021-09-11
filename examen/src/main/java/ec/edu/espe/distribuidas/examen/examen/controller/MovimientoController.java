/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.examen.controller;

import ec.edu.espe.distribuidas.examen.examen.modelo.Movimiento;
import ec.edu.espe.distribuidas.examen.examen.repositorio.MovimientoDAO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author mikeq
 */

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/api/movimiento")

public class MovimientoController {
    
    
     @Autowired
    private MovimientoDAO repository;
    
    @PostMapping("/relleno")
    public Movimiento create(@Validated @RequestBody Movimiento p ){
    return repository.insert(p);
    }
    
    @GetMapping("/")
    public List<Movimiento> readAll(){
    return repository.findAll();
    }
    
      @PutMapping("/cajero/{id}")
    public Movimiento update(@PathVariable String id,@Validated @RequestBody Movimiento p){
    return repository.save(p);
    }
    
}
