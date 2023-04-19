package Logica;

import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author jeanp
 */
public class LogicaJuego {
    
    public static int opcion = -1;
    public static String letra = "";
    public static String palabra = "";
    
    public static final String[][] opciones = 
    {
        {"PERRO", "GATO", "ELEFANTE", "LEON", "PAJARO", "ARAÑA", "TORTUGA", "CABALLO", "VACA", "ARDILLA"},
        {"AZUL", "AMARILLO", "ROJO", "BLANCO", "NEGRO", "GRIS", "PURPURA", "VERDE", "ROSA", "VIOLETA"},
        {"MANZANA", "PERA", "NARANJA", "MANGO", "MANDARINA", "GUANABANA", "SANDIA", "BANANO", "MORA", "PIÑA"}
    };
    

 

    public static String palabraAleatoria() {
        Random rand = new Random();
        int i = rand.nextInt(opciones[LogicaJuego.opcion].length);
        return LogicaJuego.palabra = opciones[LogicaJuego.opcion][i];
    }
    
    public static String letraAleatoria(){
        Random aleatorio = new Random();
        int i = aleatorio.nextInt(palabra.length());
        char[] ocultar = palabra.toCharArray();
        ocultar[i] = '_';
        return String.valueOf(ocultar);
    }
    
    public static boolean verificarLetra(String letra) {
        return palabra.contains(letra);
    }
}
