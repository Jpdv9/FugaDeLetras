package Vistas;

import java.awt.Font;
import java.awt.Toolkit;
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
    private Fondo jpFondo;
    
    public VistaInstrucciones(){
        iniciarComponentes();

    }
    private void iniciarComponentes(){
        //creacion panel
                setTitle("Fuga de Letras");
        setSize(670,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        jpFondo = new Fondo("/IMAGENES/PantallaInstrucciones.jpg"); 
        jpContenido = new JPanel();
        jpFondo.setSize(670,650);
        add(jpContenido);
        
        lblTexto = new JLabel("<html><body>Instrucciones: <br> las instrucciones del juego son muy sencillas , comienzas dando un click en el boton jugar, despues escribes tu nombre para poder jugar, de ahi pulsas el boton suguiente y escoges la categoria que mas te llame la atencion para empezar a jugar, de ahi se te va a mostrar una palabra correspondiente a la categoria que escogiste junto a una lustracion de lo que es esta palabra, a esta le faltara una vocal, la cual tienes que encontrar y completar, escoge la opcion correcta y disfruta, en caso tal de que te llegues a equivocarte puedes intentar con otras palabras y las demas categorias, animo y explota tus conocimientos. <br>Gracias por leer, Exitos en el juego y explota tu conocimiento :) </body></html>");
        lblTexto.setBounds(50,50,550,420);
        lblTexto.setFont(new Font ("Agency FB", Font.BOLD, 25));
        lblTexto.setHorizontalAlignment(JLabel.LEFT);
        
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(250,525, 150,50);
        btnJugar.setFont(new Font("Agency FB",Font.BOLD,21));

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(425,525, 150,50);
        btnVolver.setFont(new Font("Agency FB",Font.BOLD,21));
        
        
        jpContenido.setSize(500,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblTexto);
        jpContenido.add(btnJugar);
        jpContenido.add(btnVolver);
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
                VistaInicio vistainicio = new VistaInicio() ; 
                dispose();
            }       
        };
        btnVolver.addActionListener(instrucciones);
    }
}
