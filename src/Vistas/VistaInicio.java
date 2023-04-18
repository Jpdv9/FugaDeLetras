package Vistas;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;



/**
 *
 * @author jeanp
 */

public class VistaInicio extends JFrame{
    
    private Fondo jpFondo;
    private JLabel lblTitulo;
    private JButton btnJugar;
    private JButton btnInstrucciones;
    private JPanel jpContenido;
    
  
    public VistaInicio(){
        iniciarComponentes();
        
    }
    
      
    
    private void iniciarComponentes(){
        //configuracion de la pantalla
        setTitle("Fuga de Letras");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        jpFondo = new Fondo("/IMAGENES/PantallaInicio.jpg"); 
        jpContenido = new JPanel();
        
        jpFondo.setSize(500,500);
        
        add(jpContenido);
        
        lblTitulo = new JLabel("FUGA DE LETRAS");
        lblTitulo.setBounds(175,80,250,60);
        lblTitulo.setFont(new Font ("Agency FB", Font.BOLD, 30));
        lblTitulo.setHorizontalAlignment(JLabel.LEFT);
        
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(175,180, 150,50);
        btnJugar.setFont(new Font("Agency FB",Font.BOLD,21));

        btnInstrucciones = new JButton("Instrucciones");
        btnInstrucciones.setBounds(175,250, 150,50);
        btnInstrucciones.setFont(new Font("Agency FB",Font.BOLD,21));
        
        jpContenido.setSize(500,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblTitulo);
        jpContenido.add(btnJugar);
        jpContenido.add(btnInstrucciones);
        jpContenido.add(jpFondo);
        
        
        ActionListener jugar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VistaJugador vistajugador = new VistaJugador();
                dispose();
            }
        };
        
        btnJugar.addActionListener(jugar);
        
        ActionListener instrucciones = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaInstrucciones vistainstrucciones = new VistaInstrucciones() ; 
                dispose();
            }       
        };
        btnInstrucciones.addActionListener(instrucciones);
        
    }

 
}
