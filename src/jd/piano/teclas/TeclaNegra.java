package jd.piano.teclas;

import java.awt.*;

public class TeclaNegra extends Tecla{
    public static final int ANCHURA = 15;
    public static final int ALTURA = 50;
    TeclaNegra(int n){
        super(n);
    }
    @Override
    public Color getColorNoPulsado() {
        return Color.BLACK;
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
    protected int[] getVerticesX() {
        int x = this.posicion.x;
        int anchura = this.getAnchura();
        return new int[]{x, x, x + anchura, x + anchura};
    }

    @Override
    protected int[] getVerticesY() {
        int y = this.posicion.y;
        int altura = this.getAltura();
        return new int[]{y, y + altura, y + altura, y};
    }
}
