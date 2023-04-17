package Vistas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Franklin Aguirre
 */
public class VistaInstrucciones extends JFrame{
    private JLabel lblTexto;
    private JButton btnJugar;
    private JButton btnVolver;
    private JPanel jpContenido;
    
    public VistaInstrucciones(){
        iniciarComponentes();
        setTitle("Fuga de Letras");
        setSize(670,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void iniciarComponentes(){
    jpContenido = new JPanel();
        add(jpContenido);
        
        lblTexto = new JLabel("<html><body>Intrucciones: <br> las intrucciones del juego son muy sencillas , comienzas escribiendo tu nombre para poder jugar, de ahi pulsas el boton suguiente y escoges la categoria que mas te llame la atencion para empezar a jugar, de ahi se te va a mostrar una palabra alusiva a la categoria que escogiste, a esta le faltara una vocal, la cual tines que encontrar, escoge la opcion correcta y disfruta, en caso tal de que te llegues a equivocar puedes intentar con otras palabras, animo y explota tus conocimienots <br>Gracias por leer, Exitos en el juego </body></html>");
        lblTexto.setBounds(50,50,550,220);
        lblTexto.setFont(new Font ("Agency FB", Font.BOLD, 20));
        lblTexto.setHorizontalAlignment(JLabel.LEFT);
        
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(250,550, 150,50);
        btnJugar.setFont(new Font("Agency FB",Font.BOLD,21));

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(425,550, 150,50);
        btnVolver.setFont(new Font("Agency FB",Font.BOLD,21));
        
        
        jpContenido.setSize(500,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblTexto);
        jpContenido.add(btnJugar);
        jpContenido.add(btnVolver);
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
                VistaInicio vistainicio = new VistaInicio() ; 
                dispose();
            }       
        };
        btnVolver.addActionListener(instrucciones);
    }
}
