
package Vistas;

import Logica.LogicaJugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class VistaJugador extends JFrame{
    
    private Fondo jpFondo;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JButton btnSiguiente;
    private JButton btnAtras;
    private JPanel jpContenido;
    
    public VistaJugador(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        //crear panel
        setTitle("Fuga de Letras");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        jpFondo = new Fondo("/IMAGENES/PantallaJugador.jpg");
        jpContenido = new JPanel();
        jpFondo.setSize(500,500);
        add(jpContenido);
        
        lblNombre = new JLabel("Escriba Tu Nombre");
        lblNombre.setBounds(140,80,500,65);
        lblNombre.setFont(new Font ("arial", Font.BOLD, 25));
        
        txtNombre = new JTextField(15);
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setBounds(125,180,250, 30);
        txtNombre.setFont(new Font("arial", Font.BOLD, 20));
        
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setBounds(175, 250, 150, 50);
        btnSiguiente.setFont(new Font("Agency FB",Font.BOLD,21));
        
        btnAtras = new JButton("Atras");
        btnAtras.setBounds(200, 320, 100, 50);
        btnAtras.setFont(new Font("Agency FB",Font.BOLD,21));
        
        jpContenido.setLayout(null);
        
        jpContenido.add(lblNombre);
        jpContenido.add(txtNombre);
        jpContenido.add(btnSiguiente);
        jpContenido.add(btnAtras);
        jpContenido.add(jpFondo);
        
        ManejarEvento manejarEvento = new ManejarEvento();
        
        btnSiguiente.addActionListener(manejarEvento);
        txtNombre.addKeyListener(manejarEvento);
        
        ActionListener atras = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaInicio vistainicio = new VistaInicio();
                dispose();
            }
        };
        
        btnAtras.addActionListener(atras);
       
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                cerrarVentana();
            }
        });
        
    }
    
    private void siguienteVista(){
        String nombre = txtNombre.getText();
        if(!nombre.trim().isEmpty() || nombre.trim().length() > 0){
            LogicaJugador jugador = new LogicaJugador(nombre);
            dispose();
            VistaCategorias vistacategoria = new VistaCategorias(jugador); 
        }
        else{
            JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocusInWindow();
        }
    }
    
    class ManejarEvento implements ActionListener, KeyListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnSiguiente){                
                siguienteVista();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            if(e.getKeyCode() == e.VK_ENTER){
                btnSiguiente.doClick();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    };
    
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
