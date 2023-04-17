/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jeanp
 */
public class VistaJuego extends JFrame{
    
    private JLabel lblNombre;
    private JLabel lblCorrectas;
    private JLabel lblIncorrectas;
    private JButton btnTerminar;
    private JPanel jpContenido;
    
    public VistaJuego(){
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
        
        jpContenido.setSize(800,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblNombre);
    }
}
