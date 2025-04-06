package jd.piano.programa;

import jd.piano.teclas.Piano;
import jd.piano.teclas.Tecla;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MultiPiano extends Piano {
    private List<PianoSencillo> pianos;

    public MultiPiano(int t, int tf){
        this.pianos = new ArrayList<>();
        for (int i=0;i<16;i++){
            this.pianos.add(new PianoSencillo(t,tf));
        }
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        Tecla tecla = null;
        if (canal>=0 && canal < this.pianos.size()){
            tecla = this.pianos.get(canal).getTecla(canal,nota);
        }
        return tecla;
    }

    @Override
    public void setPosicion(int x, int y) {

        for (int i=0;i<this.pianos.size();i++){
            this.pianos.get(i).setPosicion(x,y);
        }
    }

    @Override
    public void setGraphics(Graphics g) {
        for (PianoSencillo piano : this.pianos) {
            piano.setGraphics(g);
        }
    }

    @Override
    public void dibujar() {
        for (PianoSencillo piano : this.pianos) {
            piano.dibujar();
        }
    }

    @Override
    public int getAnchura() {
        int anchoPiano = this.pianos.get(0).getAnchura();
        return anchoPiano * 2;
    }

    @Override
    public int getAltura() {
        int altoPiano = this.pianos.get(0).getAltura();
        return altoPiano * 8;
    }
}
