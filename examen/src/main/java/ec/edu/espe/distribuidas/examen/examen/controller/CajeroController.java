/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.examen.controller;

import ec.edu.espe.distribuidas.examen.examen.modelo.Cajero;
import ec.edu.espe.distribuidas.examen.examen.modelo.Movimiento;

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
import ec.edu.espe.distribuidas.examen.examen.repositorio.CajeroDAO;
import org.springframework.data.mongodb.core.query.BasicQuery;

/**
 *
 * @author mikeq
 */
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/api/cajero")

public class CajeroController {
    
    @Autowired
    private CajeroDAO repository;
    
    @PostMapping("/cajero")
    public Cajero create(@Validated @RequestBody Cajero p){
    return repository.insert(p);
    }
    
    @GetMapping("/")
    public List<Cajero> readAll(){
    return repository.findAll();
    }
    @GetMapping("/informacion")
    public List<Cajero> informacion(@PathVariable String id, @Validated @RequestBody Cajero p ,@PathVariable Double monto){
        BasicQuery query = new BasicQuery("{ monto : { $lt : "+monto+"}}");
        List<Cajero> result = repository.find(query, Cajero.class);
    return result;
    }
    
    
    @PutMapping("/relleno/{id}")
    public Cajero update(@PathVariable String id,@Validated @RequestBody Cajero p, Movimiento m){
        
        
    p.setMovimientoDetalle(m);
    return repository.save(p);
    }
    
    @DeleteMapping("/cajero/{id}")
    public void delete (@PathVariable String id){
        repository.deleteById(id);
    } 
}

