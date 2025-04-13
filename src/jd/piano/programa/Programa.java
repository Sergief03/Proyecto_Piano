package jd.piano.programa;

import bpc.daw.consola.*;
import jd.piano.teclas.Piano;

import java.awt.*;
import java.io.File;

public class Programa {
    public static void main(String[] args) {
        Consola consola = new Consola();
        CapaFondo fondo = consola.getCapaFondo();
        CapaTexto texto = consola.getCapaTexto();
        Teclado teclado = consola.getTeclado();
        CapaCanvas capaCanvas=consola.getCapaCanvas();
        Graphics c=capaCanvas.getGraphics();

        fondo.setFondo(new FondoColorSolido(new Color(0, 0, 70)));
        texto.println("Introduce la ruta del archivo: ");
        String ruta = teclado.leerCadenaCaracteres();

        File archivo = new File(ruta);
        if(archivo.exists()){
           texto.println("¿Donde quieres reproducir la cancion?");
           texto.println("1. Piano sencillo");
           texto.println("2. Multi piano");
           int respuesta = teclado.leerNumeroEntero();
           Piano piano = null;
           switch (respuesta){
               case 1-> piano=new PianoSencillo(24,108);
               case 2->piano=new MultiPiano(24,108);
               default-> texto.println("Elige una opcion valida");
           }
           piano.setPosicion(200,200);
           piano.setGraphics(c);
           piano.dibujar();
           ReproductorMidi reproductorMidi=new ReproductorMidi();
           reproductorMidi.conectar(piano);
           reproductorMidi.reproducir(ruta);
        }else{
            texto.println("El archivo no existe");
        }


    }
}
