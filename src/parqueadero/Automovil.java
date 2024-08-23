/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueadero;

import java.time.LocalDateTime;

/**
 *
 * @author Johann Lopez
 */
public class Automovil extends Vehiculo {
    
    private String tipoCombustible;

    public Automovil(String placa, String marca, String modelo, LocalDateTime horaEntrada, String tipoCombustible) {
        super(placa, marca, modelo, horaEntrada);
        this.tipoCombustible = tipoCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }
public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

}
