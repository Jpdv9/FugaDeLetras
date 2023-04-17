package Logica;

import java.util.Random;
/**
 *
 * @author jeanp
 */
public class LogicaJuego {
    
    public static int opcion = -1;
    
    public static final String[][] opciones = 
    {
        {"PERRO", "GATO", "ELEFANTE", "LEON", "PAJARO", "ARAÑA", "TORTUGA", "CABALLO", "VACA", "ARDILLA"},
        {"AZUL", "AMARILLO", "ROJO", "BLANCO", "NEGRO", "GRIS", "PURPURA", "VERDE", "ROSA", "VIOLETA"},
        {"MANZANA", "PERA", "NARANJA", "MANGO", "MANDARINA", "GUANABANA", "SANDIA", "BANANO", "MORA", "PIÑA"}
    };
    
    
    /*
    public static String ocultarLetra(){
        Random aleatorio = new Random();
        int letraOculta = aleatorio.nextInt(opciones[LogicaJuego.opcion].length);
        
        String palabraOculta = opciones.substring(0, letraOculta)
                + "_" + opciones.substring(letraOculta + 1);
    }*/
}
