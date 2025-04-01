package jd.piano.teclas;

import java.awt.*;

public abstract class Tecla implements Pulsable{
    protected Point posicion;
    private int nota;
    private boolean pulsada;
    private Color colorPulsada;
    private Graphics graphics;

    Tecla(int n){
        throw new UnsupportedOperationException("Sin programar");
    }

    public int getNumeroNota(){
        throw new UnsupportedOperationException("Sin programar");
    }

    protected abstract int[] getVerticesX(){
        throw new UnsupportedOperationException("Sin programar");
    }

    protected abstract int[] getVerticesY(){
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public void pulsar() {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public void soltar() {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public boolean estaPulsado() {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public void setColorPulsado(Color c) {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public Color getColorPulsado() {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public Color getColorNoPulsado() {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public void setPosicion(int x, int y) {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public void setGraphics(Graphics g) {
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    public void dibujar() {
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
}
