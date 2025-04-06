package jd.piano.teclas;

import java.awt.*;

public abstract class TeclaBlanca extends Tecla{
    public static final int ANCHURA = 25;
    public static final int ALTURA = 100;
    TeclaBlanca(int n){
        super(n);
    }

    @Override
    public Color getColorNoPulsado() {
        return Color.WHITE;
    }

    @Override
    public int getAnchura() {
        return this.ANCHURA;
    }

    @Override
    public int getAltura() {
        return this.ALTURA;
    }

    @Override
    protected abstract int[] getVerticesX();

    @Override
    protected abstract int[] getVerticesY();
}
