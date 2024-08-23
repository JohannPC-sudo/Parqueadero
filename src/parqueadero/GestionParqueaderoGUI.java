/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parqueadero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 *
 * @author Usuario
 */
public class GestionParqueaderoGUI extends JFrame {
    
    private JTextField placaField;
    private JTextField marcaField; 
    private JTextField modeloField;
    private JComboBox<String> tipoComboBox;
    private JTextArea estadoArea; 

        public GestionParqueaderoGUI() {            
        Parqueadero parqueadero = new Parqueadero(); 
        setTitle("Gestión de Parqueadero"); 
        setSize(400, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);  

        JLabel placaLabel = new JLabel("Placa:"); 
        placaLabel.setBounds(10, 10, 80, 25); 
        add(placaLabel);  

        placaField = new JTextField(); 
        placaField.setBounds(100, 10, 160, 25); 
        add(placaField);  

        JLabel marcaLabel = new JLabel("Marca:"); 
        marcaLabel.setBounds(10, 40, 80, 25);
        add(marcaLabel);  

        marcaField = new JTextField(); 
        marcaField.setBounds(100, 40, 160, 25);
        add(marcaField);  

        JLabel modeloLabel = new JLabel("Modelo:"); 
        modeloLabel.setBounds(10, 70, 80, 25); 
        add(modeloLabel);  

        modeloField = new JTextField(); 
        modeloField.setBounds(100, 70, 160, 25); 
        add(modeloField);  

        JLabel tipoLabel = new JLabel("Tipo:"); 
        tipoLabel.setBounds(10, 100, 80, 25); 
        add(tipoLabel);  

        tipoComboBox = new JComboBox<>(new String[]{"Automóvil", "Motocicleta", "Camión"}); 
        tipoComboBox.setBounds(100, 100, 160, 25); 
        add(tipoComboBox);  

        JButton registrarEntradaButton = new JButton("Registrar Entrada"); 
        registrarEntradaButton.setBounds(10, 130, 150, 25); 
        add(registrarEntradaButton);  

        JButton registrarSalidaButton = new JButton("Registrar Salida"); 
        registrarSalidaButton.setBounds(170, 130, 150, 25); 
        add(registrarSalidaButton);  

        JButton consultarEstadoButton = new JButton("Consultar Estado"); 
        consultarEstadoButton.setBounds(10, 160, 310, 25); 
        add(consultarEstadoButton);  

        estadoArea = new JTextArea(); 
        estadoArea.setBounds(10, 190, 360, 60);
        add(estadoArea);  

        registrarEntradaButton.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                String placa = placaField.getText(); 
                String marca = marcaField.getText(); 
                String modelo = modeloField.getText(); 

                LocalDateTime horaEntrada = LocalDateTime.now(); 
                String tipo = (String) tipoComboBox.getSelectedItem(); 
                
                if (tipo.equals("Automóvil")) { 
                    String tipoCombustible = JOptionPane.showInputDialog("Ingrese el tipo de combustible:"); 
                    Automovil automovil = new Automovil(placa, marca, modelo, horaEntrada, tipoCombustible);
                    parqueadero.registrarEntrada(automovil);
                } else if (tipo.equals("Motocicleta")) { 
                    int cilindraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cilindraje:")); 
                    Motocicleta motocicleta = new Motocicleta(placa, marca, modelo, horaEntrada, cilindraje);
                    parqueadero.registrarEntrada(motocicleta); 
                } else if (tipo.equals("Camión")) { 
                    double capacidadCarga = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga:")); 
                    Camion camion = new Camion(placa, marca, modelo, horaEntrada, capacidadCarga);
                    parqueadero.registrarEntrada(camion); 

                } 
                
                JOptionPane.showMessageDialog(null, "Vehículo registrado con éxito."); 
            } 

        }); 
 

        registrarSalidaButton.addActionListener(new ActionListener() { 
            @Override 

            public void actionPerformed(ActionEvent e) { 
                String placa = placaField.getText();
                try { 
                    double costo = parqueadero.registrarSalida(placa); 
                    JOptionPane.showMessageDialog(null, "El costo total es: $" + costo);

                } catch (IllegalArgumentException ex) { 
                    JOptionPane.showMessageDialog(null, ex.getMessage()); 
                } 
            }

        }); 
 

        consultarEstadoButton.addActionListener(new ActionListener() { 

            @Override 

            public void actionPerformed(ActionEvent e) { 

                StringBuilder estado = new StringBuilder(); 

                for (Vehiculo v : parqueadero.consultarEstado()) { 

                    estado.append("Placa: ").append(v.getPlaca()) 

                          .append(", Marca: ").append(v.getMarca()) 

                          .append(", Modelo: ").append(v.getModelo()) 

                          .append(", Hora de Entrada: ").append(v.getHoraEntrada()) 

                          .append("\n"); 

                } 

                estadoArea.setText(estado.toString()); 

            } 

        }); 

    } 
        
 
    public static void main(String[] args) {
    
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() { 

            @Override 

            public void run() { 

                new GestionParqueaderoGUI().setVisible(true); 

            } 

      }); 

  } 

}
  
    

