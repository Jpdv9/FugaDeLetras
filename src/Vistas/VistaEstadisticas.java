package Vistas;

import Logica.LogicaJuego;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Logica.LogicaJugador;
import java.awt.Color;

/**
 *
 * @author Franklin Aguirre
 */
public class VistaEstadisticas extends JFrame {
    private JLabel lblNombre;
    private JLabel lblNombreJugador;
    private JLabel lblCantLexema;
    private JLabel lblCantPalabras;
    private JLabel lblCantFallos;
    private JLabel lblFallos;
    private JLabel lblCantAciertos;
    private JLabel lblAciertos;
    private JLabel lblTitulo;
    private JLabel lblPorcentajeFallos;
    private JLabel lblPorcentajeAciertos;
    private LogicaJugador jugador;
    
    private JButton btnJugar;
    private JButton btnSalir;
    private JPanel jpContenido;
    private Fondo jpFondo;
    
    public VistaEstadisticas(LogicaJugador jugador){
        this.jugador = jugador;
        iniciarComponentes();

    }
    private void iniciarComponentes(){
        
        //creacion panel
                setTitle("Fuga de Letras");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        jpFondo = new Fondo("/IMAGENES/PantallaEstadisticas.jpg"); 
        jpContenido = new JPanel();
        jpFondo.setSize(500,500);
        add(jpContenido);

        
        String nombre = jugador.getNombre();
        nombre = nombre.substring(0,1).toUpperCase() +
                 nombre.substring(1).toLowerCase();
        lblNombreJugador = new JLabel(nombre);
        lblNombreJugador.setBounds(125,145,250,60);
        lblNombreJugador.setForeground(Color.GRAY);
        lblNombreJugador.setFont(new Font("arial", Font.BOLD, 18));
        
        lblTitulo = new JLabel("ESTADISTICAS");
        lblTitulo.setBounds(185,61,250,60);
        lblTitulo.setFont(new Font ("Agency FB", Font.BOLD, 30));
        lblTitulo.setHorizontalAlignment(JLabel.LEFT);
        
        lblNombre = new JLabel("NOMBRE : ");
        lblNombre.setBounds(35,145,250,60);
        lblNombre.setFont(new Font ("Agency FB", Font.BOLD, 20));
        lblNombre.setHorizontalAlignment(JLabel.LEFT);
        
        lblCantLexema = new JLabel("CANTIDAD DE PALABRAS : ");
        lblCantLexema.setBounds(35,180,250,60);
        lblCantLexema.setFont(new Font ("Agency FB", Font.BOLD, 20));
        lblCantLexema.setHorizontalAlignment(JLabel.LEFT);
        
        lblCantPalabras = new JLabel(String.valueOf(LogicaJuego.numeroPalabras));
        lblCantPalabras.setBounds(250,180,250,60);
        lblCantPalabras.setFont(new Font ("Agency FB", Font.BOLD, 20));
        lblCantPalabras.setHorizontalAlignment(JLabel.LEFT);
        
        lblFallos = new JLabel("FALLOS : ");
        lblFallos.setBounds(35,220,250,60);
        lblFallos.setFont(new Font ("Agency FB", Font.BOLD, 20));
        lblFallos.setHorizontalAlignment(JLabel.LEFT);
        
        
        lblCantFallos = new JLabel(String.valueOf(LogicaJuego.incorrectas));
        lblCantFallos.setBounds(150,220,250,60);
        lblCantFallos.setFont(new Font ("Agency FB", Font.BOLD, 20));
        lblCantFallos.setHorizontalAlignment(JLabel.LEFT);
        
        lblPorcentajeFallos = new JLabel(String.valueOf(LogicaJuego.PorcentajeFallos())+" %");
        lblPorcentajeFallos.setBounds(170,220,250,60);
        lblPorcentajeFallos.setFont(new Font ("Agency FB", Font.BOLD, 20));
        lblPorcentajeFallos.setHorizontalAlignment(JLabel.LEFT);
        
        lblCantAciertos = new JLabel("CORRECTAS : ");
        lblCantAciertos.setBounds(35,260,250,60);
        lblCantAciertos.setFont(new Font ("Agency FB", Font.BOLD, 20));
        lblCantAciertos.setHorizontalAlignment(JLabel.LEFT);
        
        
        lblAciertos = new JLabel(String.valueOf(LogicaJuego.correctas));
        lblAciertos.setBounds(150,260,250,60);
        lblAciertos.setFont(new Font ("Agency FB", Font.BOLD, 20));
        lblAciertos.setHorizontalAlignment(JLabel.LEFT);
        
        lblPorcentajeAciertos = new JLabel(String.valueOf(LogicaJuego.PorcentajeAciertos())+" %");
        lblPorcentajeAciertos.setBounds(170,260,250,60);
        lblPorcentajeAciertos.setFont(new Font ("Agency FB", Font.BOLD, 20));
        lblPorcentajeAciertos.setHorizontalAlignment(JLabel.LEFT);
        
        btnJugar = new JButton("Volver a Jugar");
        btnJugar.setBounds(90,400, 150,50);
        btnJugar.setFont(new Font("Agency FB",Font.BOLD,21));

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(265,400, 150,50);
        btnSalir.setFont(new Font("Agency FB",Font.BOLD,21));
        
        
        jpContenido.setSize(500,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblTitulo);
        jpContenido.add(lblNombre);
        jpContenido.add(lblNombreJugador);
        jpContenido.add(lblCantLexema);
        jpContenido.add(lblCantPalabras);
        jpContenido.add(lblCantFallos);
        jpContenido.add(lblPorcentajeFallos);
        jpContenido.add(lblFallos);
        jpContenido.add(lblCantAciertos);
        jpContenido.add(lblAciertos);
        jpContenido.add(lblPorcentajeAciertos);
        jpContenido.add(btnJugar);
        jpContenido.add(btnSalir);
        jpContenido.add(jpFondo);
        ActionListener VolverJugar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LogicaJuego.ReseteoTotal();
                VistaInicio Vistainicio = new VistaInicio();
                dispose();
            }
        };
        
        btnJugar.addActionListener(VolverJugar);
        
        ActionListener Salir = new ActionListener(){
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
        };
        btnSalir.addActionListener(Salir);
    }
}
