package Vistas;

/**
 *
 * @author Franklin Aguirre
 */
import Logica.LogicaJuego;
import Logica.LogicaJugador;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VistaCategorias extends JFrame{
    
    private Fondo jpFondo;
    private LogicaJugador jugador;
    private JLabel lblCategoria;
    private JButton btnAnimales;
    private JButton btnColores;
    private JButton btnFrutas;
    private JPanel jpContenido;
    
    public VistaCategorias(LogicaJugador jugador){
        this.jugador = jugador;
        iniciarComponentes();
        

    }
    private void iniciarComponentes(){
        //creacion panel 
        setTitle("Fuga de Letras");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        jpFondo = new Fondo("/IMAGENES/PantallaCategorias.jpg"); 
        jpContenido = new JPanel();
        
        jpFondo.setSize(600,475);
        add(jpContenido);
        
        lblCategoria = new JLabel("Seleccione Una Categoria");
        lblCategoria.setBounds(175,80,250,60);
        lblCategoria.setFont(new Font ("Agency FB", Font.BOLD, 30));
        lblCategoria.setHorizontalAlignment(JLabel.LEFT);
        
        btnAnimales = new JButton("Animales");
        btnAnimales.setBounds(225,180, 150,50);
        btnAnimales.setFont(new Font("Agency FB",Font.BOLD,21));

        btnColores = new JButton("Colores");
        btnColores.setBounds(225,250, 150,50);
        btnColores.setFont(new Font("Agency FB",Font.BOLD,21));
        
        btnFrutas = new JButton("Futas");
        btnFrutas.setBounds(225,320, 150,50);
        btnFrutas.setFont(new Font("Agency FB",Font.BOLD,21));
        
        jpContenido.setSize(500,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblCategoria);
        jpContenido.add(btnAnimales);
        jpContenido.add(btnColores);
        jpContenido.add(btnFrutas);
        jpContenido.add(jpFondo);
        
        btnAnimales.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LogicaJuego.opcion = 0;
                System.out.println();
                

                VistaJuego vistajuego = new VistaJuego(jugador);
                dispose();
            }
        });
        
        btnColores.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LogicaJuego.opcion = 1;
                

                VistaJuego vistajuego = new VistaJuego(jugador);
                dispose();
            }
        });
        
        btnFrutas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LogicaJuego.opcion = 2;
                

               
                VistaJuego vistajuego = new VistaJuego(jugador);
                dispose();
            }
        });
        
        addWindowListener(new WindowAdapter() {
             @Override
            public void windowClosing(WindowEvent evt) {
                cerrarVentana();
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
