/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.examen.modelo;



import java.util.ArrayList;
import java.util.List;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author mikeq
 */

@Document(collection = "cajero")
public class Cajero {
    
    @Id
    private String id;
    private String nombre;
    private Double monto; 
    private List<Movimiento> movimiento;

    public Cajero(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.movimiento= new ArrayList<Movimiento>();
    }

    public Cajero(String id, String nombre, List<Movimiento> movimiento) {
        this.id = id;
        this.nombre = nombre;
        this.movimiento = movimiento;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Movimiento> getMovimiento() {
        return movimiento;
    }
    public void setMovimientoDetalle(Movimiento movimiento) {
        this.movimiento.add(movimiento);
        if(movimiento.getDebito()){
        this.monto=this.monto+ movimiento.getMonto();
        }else{
            this.monto=this.monto- movimiento.getMonto();
        }
    }
    public void setMovimiento(List<Movimiento> movimiento) {
        this.movimiento = movimiento;
    }

   
  
    
    
}
