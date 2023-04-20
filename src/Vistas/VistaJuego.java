/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import Logica.LogicaJuego;
import Logica.LogicaJugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jeanp
 */
public class VistaJuego extends JFrame{
    
    private JLabel lblNombre;
    private JLabel lblNombreJugador;
    private JLabel lblNumeroCorrectas;
    private JLabel lblNumeroIncorrectas;
    private JLabel lblPalabra;
    private JLabel lblLexema;
    private JLabel lblNumeroPalabras;
    private JLabel lblCorrectas;
    private JLabel lblIncorrectas;
    private JTextField txtVerificar;
    private JButton btnVerificar;
    private JButton btnTerminar;
    private JPanel jpContenido;
    private LogicaJugador jugador;
    
    public VistaJuego(LogicaJugador jugador){
        this.jugador = jugador;
        LogicaJuego.palabraAleatoria();
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
        
        lblNumeroCorrectas = new JLabel(String.valueOf(LogicaJuego.correctas));
        lblNumeroCorrectas.setBounds(325,20,100,100);
        
        lblIncorrectas = new JLabel("Incorrectas: ");
        lblIncorrectas.setBounds(350, 20, 100, 100);
        
        lblNumeroIncorrectas = new JLabel(String.valueOf(LogicaJuego.correctas));
        lblNumeroIncorrectas.setBounds(425,20,100,100);
        
        lblPalabra = new JLabel(LogicaJuego.letraAleatoria());
        lblPalabra.setBounds(350,190,300, 50); 
        lblPalabra.setFont(new Font("Agency FB",Font.BOLD,40));
        
        lblLexema = new JLabel("Numero de palabras: ");
        lblLexema.setBounds(225,100,150,100);
        
        lblNumeroPalabras = new JLabel(String.valueOf(LogicaJuego.numeroPalabras));
        lblNumeroPalabras.setBounds(350,125,50,50);
        
        txtVerificar = new JTextField(1);
        txtVerificar.setBounds(325,250,150,25);
        
        
        btnVerificar =new JButton("Verificar");
        btnVerificar.setBounds(350, 300, 100, 50);
        
        btnTerminar = new JButton("TERMINAR");
        btnTerminar.setBounds(300, 400, 200, 50);
        
        
        jpContenido.setSize(800,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblNombre);
        jpContenido.add(lblPalabra);
        jpContenido.add(lblLexema);
        jpContenido.add(lblNumeroPalabras);
        jpContenido.add(lblCorrectas);
        jpContenido.add(lblNumeroCorrectas);
        jpContenido.add(lblIncorrectas);
        jpContenido.add(lblNumeroIncorrectas);
        jpContenido.add(txtVerificar);
        jpContenido.add(btnVerificar);
        jpContenido.add(btnTerminar);
        jpContenido.add(lblNombreJugador);
        
        
        addWindowListener(new WindowAdapter() {
             @Override
            public void windowClosing(WindowEvent evt) {
                cerrarVentana();
            }
        });
        
        
        btnVerificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String letra = txtVerificar.getText().toUpperCase();
                
                System.out.println(letra);
                System.out.println(LogicaJuego.letra);
                
                if(letra.equals(LogicaJuego.letra)){
                    LogicaJuego.correctas++;
                    LogicaJuego.numeroPalabras++;
                    
                    lblNumeroCorrectas.setText(String.valueOf(LogicaJuego.correctas));
                    lblNumeroPalabras.setText(String.valueOf(LogicaJuego.numeroPalabras));
                    
                    JOptionPane.showMessageDialog(null, "Haz acertado la letra");
                    
                    LogicaJuego.reseteo();
                    lblPalabra.setText(LogicaJuego.letraOculta);
                    
                    txtVerificar.setText("");
                }
                else{
                    LogicaJuego.incorrectas++;
                    lblNumeroIncorrectas.setText(String.valueOf(LogicaJuego.incorrectas));
                    
                    JOptionPane.showMessageDialog(null, "Haz errado la letra");
                    
                    txtVerificar.setText("");
                }
            }
            
        });
        
        btnTerminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta;

                respuesta = JOptionPane.showConfirmDialog(
                            null,"¿Quieres terminar el juego?", "Advertencia",
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.WARNING_MESSAGE);
                if(respuesta == JOptionPane.YES_OPTION){
                    dispose();
                }
            }

        });
       
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
