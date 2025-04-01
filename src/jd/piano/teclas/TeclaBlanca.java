package jd.piano.teclas;

import java.awt.*;

public class TeclaBlanca extends Tecla{
    public static final int ANCHURA = 25;
    public static final int ALTURA = 100;
    TeclaBlanca(int n){
        super(n);
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public Color getColorNoPulsado() {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public int getAnchura() {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public int getAltura() {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    protected int[] getVerticesX() {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    protected int[] getVerticesY() {
        throw new UnsupportedOperationException("Sin programar");
    }
}
