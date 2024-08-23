/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueadero;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johann Lopez
 */
    public class Parqueadero {
        
    private final List<Vehiculo> vehiculos;

    public Parqueadero() {
        this.vehiculos = new ArrayList<>();
    }

    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public double registrarSalida(String placa) {
        Vehiculo vehiculo = null;
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                vehiculo = v;
                break;
            }
        }
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo con placa " + placa + " no está en el parqueadero.");
        }
        LocalDateTime horaSalida = LocalDateTime.now();
        Duration duracion = Duration.between(vehiculo.getHoraEntrada(), horaSalida);
        long horas = duracion.toHours();
        if (duracion.toMinutes() % 60 != 0) {
            horas++;
        }
        double costo = calcularCosto(vehiculo, horas);
        vehiculos.remove(vehiculo);
        return costo;
    }

    private double calcularCosto(Vehiculo vehiculo, long horas) {
        if (vehiculo instanceof Automovil) {
            return horas * 5000; // Ejemplo de tarifa para automóvil
        } else if (vehiculo instanceof Motocicleta) {
            return horas * 3000; // Ejemplo de tarifa para motocicleta
        } else if (vehiculo instanceof Camion) {
            return horas * 10000; // Ejemplo de tarifa para camión
        }
        return 0;
    }

    public List<Vehiculo> consultarEstado() {
        return new ArrayList<>(vehiculos);
    }


  }


  




