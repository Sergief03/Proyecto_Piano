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
        super();
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
        for (Tecla tecla : this.teclas.values()) {
            if (tecla instanceof TeclaBlanca){
                tecla.setPosicion(x1, y1);
                x1+=tecla.getAnchura();
            }else {
                tecla.setPosicion(x1-tecla.getAnchura()/2, y1);
            }
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
            if (tecla instanceof TeclaBlanca){
                ancho+= tecla.getAnchura();
            }
        }
        return ancho;
    }

    @Override
    public int getAltura() {
        int altura=0;
        for (Tecla tecla : this.teclas.values()){
            altura=tecla.getAltura();
        }
        return altura;
    }
}
