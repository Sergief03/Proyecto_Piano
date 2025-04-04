package jd.piano.programa;

import jd.piano.teclas.Piano;
import jd.piano.teclas.Tecla;
import jd.piano.teclas.TeclaBlanca;
import jd.piano.teclas.TeclaFactory;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PianoSencillo extends Piano {
    private Map<Integer,Tecla> teclas;

    public PianoSencillo(int teclaInicial, int teclaFinal){
        this.teclas = new HashMap<>();
        for (int i = teclaInicial; i <= teclaFinal; i++) {
            this.teclas.put(i, TeclaFactory.crearTecla(i));
        }
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return this.teclas.get(nota);
    }

    @Override
    public void setPosicion(int x, int y) {
        int x1 = x;
        int y1 = y;
        int posX = x;
        for (Tecla tecla : this.teclas.values()) {
            tecla.setPosicion(posX, y);
            posX += tecla.getAnchura();
        }
    }

    @Override
    public void setGraphics(Graphics g) {
        for (Tecla tecla : this.teclas.values()) {
            tecla.setGraphics(g);
        }
    }

    @Override
    public void dibujar() {
        for (Tecla tecla : this.teclas.values()){
            tecla.dibujar();
        }
    }

    @Override
    public int getAnchura() {
        int ancho = 0;
        for (Tecla tecla : this.teclas.values()){
            ancho+= tecla.getAnchura();
        }
        return ancho;
    }

    @Override
    public int getAltura() {
        int alto = 0;
        for (Tecla tecla : this.teclas.values()){
            int altoT = tecla.getAltura();
            if (altoT>alto){
                alto=altoT;
            }
        }
        return alto;
    }
}
