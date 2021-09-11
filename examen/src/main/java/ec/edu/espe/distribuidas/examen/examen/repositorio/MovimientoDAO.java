/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.examen.repositorio;
import ec.edu.espe.distribuidas.examen.examen.modelo.Movimiento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author mikeq
 */
@Repository
public interface MovimientoDAO extends MongoRepository <Movimiento, String> {
    
}
