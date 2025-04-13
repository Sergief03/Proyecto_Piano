package jd.piano.programa;

import jd.piano.teclas.Piano;
import jd.piano.teclas.Tecla;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MultiPiano extends Piano {
    private List<PianoSencillo> pianos;

    public MultiPiano(int teclaInicial, int teclaFinal) {
        this.pianos = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            this.pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
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
        int pianoWidth = this.pianos.get(0).getAnchura();
        int pianoHeight = this.pianos.get(0).getAltura();

        for (int i = 0; i < this.pianos.size(); i++) {
            int row = i / 2;
            int col = i % 2;

            int posX = x + (col * pianoWidth);
            int posY = y + (row * pianoHeight);

            this.pianos.get(i).setPosicion(posX, posY);
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
        return this.pianos.get(0).getAnchura() * 2;
    }

    @Override
    public int getAltura() {
        return this.pianos.get(0).getAltura() * 8;
    }
}
