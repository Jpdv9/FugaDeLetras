package Logica;

import java.util.Random;
/**
 *
 * @author jeanp
 */
public class LogicaJuego {
    
    public static int opcion = -1;
    public static int correctas = 0;
    public static int incorrectas = 0;
    public static int numeroPalabras = 1;
    public static int palabraRandom = 0;
    public static int letraRandom = 0;
    public static String letra = "";
    public static String letraOculta = "";
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
        palabraRandom = i;
        return LogicaJuego.palabra = opciones[LogicaJuego.opcion][i];
    }
    
    public static String letraAleatoria(){
        Random aleatorio = new Random();
        int i = aleatorio.nextInt(palabra.length());
        letraRandom = i;
        letra = String.valueOf(palabra.toCharArray()[letraRandom]);
        char[] ocultar = palabra.toCharArray();
        ocultar[i] = '_';
        return String.valueOf(ocultar);
    }
    
    public static void reseteo(){
        palabra = "";
        letra = "";
        letraOculta = "";
        palabraRandom = 0;
        letraRandom = 0;
        
        palabraAleatoria();
        letraOculta = letraAleatoria();
    }
    public static void ReseteoTotal(){
        palabra = "";
        letra = "";
        letraOculta = "";
        palabraRandom = 0;
        letraRandom = 0;
        correctas = 0;
        incorrectas = 0;
        numeroPalabras = 1;
        
        palabraAleatoria();
        letraOculta = letraAleatoria();
    }
    public static float PorcentajeFallos(){
        float Intentosincorrectas=incorrectas;
        int IntentosTotales =incorrectas+correctas;
        float PorcentajeFallosTotales= ((Intentosincorrectas/IntentosTotales)*100) ;
        return PorcentajeFallosTotales;
    }
    public static float PorcentajeAciertos(){
        float Intentoscorrectas=correctas;
        int IntentosTotales =incorrectas+correctas;
        float PorcentajeAciertosTotales= ((Intentoscorrectas/IntentosTotales)*100) ;
        return PorcentajeAciertosTotales;
    }
    
    
}