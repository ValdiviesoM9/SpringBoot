/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.examen.repositorio;

import ec.edu.espe.distribuidas.examen.examen.modelo.Cajero;
import java.util.List;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mikeq
 */

@Repository

public interface CajeroDAO extends MongoRepository <Cajero, String> {

    public List<Cajero> find(BasicQuery query, Class<Cajero> aClass);

  
    
}
