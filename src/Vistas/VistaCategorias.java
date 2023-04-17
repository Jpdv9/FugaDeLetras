package Vistas;

/**
 *
 * @author Franklin Aguirre
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaCategorias extends JFrame{
    
    private JLabel lblCategoria;
    private JButton btnAnimales;
    private JButton btnColores;
    private JButton btnFrutas;
    private JPanel jpContenido;
    
    public VistaCategorias(){
        iniciarComponentes();
        setTitle("Fuga de Letras");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void iniciarComponentes(){
    jpContenido = new JPanel();
        add(jpContenido);
        
        lblCategoria = new JLabel("Seleccione Una Categoria");
        lblCategoria.setBounds(125,80,250,60);
        lblCategoria.setFont(new Font ("Agency FB", Font.BOLD, 30));
        lblCategoria.setHorizontalAlignment(JLabel.LEFT);
        
        btnAnimales = new JButton("Animales");
        btnAnimales.setBounds(175,180, 150,50);
        btnAnimales.setFont(new Font("Agency FB",Font.BOLD,21));

        btnColores = new JButton("Colores");
        btnColores.setBounds(175,250, 150,50);
        btnColores.setFont(new Font("Agency FB",Font.BOLD,21));
        
        btnFrutas = new JButton("Futas");
        btnFrutas.setBounds(175,320, 150,50);
        btnFrutas.setFont(new Font("Agency FB",Font.BOLD,21));
        
        jpContenido.setSize(500,500);
        jpContenido.setLayout(null);
        
        jpContenido.add(lblCategoria);
        jpContenido.add(btnAnimales);
        jpContenido.add(btnColores);
        jpContenido.add(btnFrutas);
    }
}
