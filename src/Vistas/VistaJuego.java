/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import Logica.LogicaJuego;
import Logica.LogicaJugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jeanp
 */
public class VistaJuego extends JFrame{
    
    private JLabel lblNombre;
    private JLabel lblNombreJugador;
    private JLabel lblCorrectas;
    private JLabel lblIncorrectas;
    private JButton btnTerminar;
    private JPanel jpContenido;
    private LogicaJugador jugador;
    
    public VistaJuego(LogicaJugador jugador){
        this.jugador = jugador;
        iniciarComponentes();
        setTitle("Fuga de Letras");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void iniciarComponentes(){
        
        jpContenido = new JPanel();
        add(jpContenido);
        
        
        
        lblNombre = new JLabel("NOMBRE: ");
        lblNombre.setBounds(50,20, 100, 100);
        
        String nombre = jugador.getNombre();
        
        
        nombre = nombre.substring(0,1).toUpperCase() +
                 nombre.substring(1).toLowerCase();
        lblNombreJugador = new JLabel(nombre);
        lblNombreJugador.setBounds(100,20, 100,50);
        lblNombreJugador.setForeground(Color.GRAY);
        lblNombreJugador.setFont(new Font("arial", Font.BOLD, 18));
        
        lblCorrectas = new JLabel("Correctas: ");
        lblCorrectas.setBounds(250,20,100,100);
        
        lblIncorrectas = new JLabel("Incorrectas: ");
        lblIncorrectas.setBounds(350, 20, 100, 100);
        
        btnTerminar = new JButton("TERMINAR");
        btnTerminar.setBounds(300, 250, 100, 50);
        
        
        jpContenido.setSize(800,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblNombre);
        jpContenido.add(lblCorrectas);
        jpContenido.add(lblIncorrectas);
        jpContenido.add(btnTerminar);
        jpContenido.add(lblNombreJugador);
        
        addWindowListener(new WindowAdapter() {
             @Override
            public void windowClosing(WindowEvent evt) {
                cerrarVentana();
            }
        });
        
        System.out.println(LogicaJuego.palabraAleatoria());
        System.out.println(LogicaJuego.letraAleatoria());
    }
    
    
    private void cerrarVentana(){
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(
                    null,"¿Realmente dese abandonar el juego?", "Advertencia",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}
