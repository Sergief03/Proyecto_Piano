package jd.piano.teclas;

import java.awt.*;

public interface Pulsable extends ElementoVisual{
    public abstract void pulsar();
    public abstract void soltar();
    public abstract boolean  estaPulsado();
    public abstract void setColorPulsado(Color c);
    public abstract Color getColorPulsado();
    public Color getColorNoPulsado();
    public default Color getColor(){
        Color color=null;
        if (estaPulsado()){
            color=getColorPulsado();
        }else {
            color=getColorNoPulsado();
        }
        return color;
    }
}
