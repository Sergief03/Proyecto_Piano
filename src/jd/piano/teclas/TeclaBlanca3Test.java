package jd.piano.teclas;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TeclaBlanca3Test {
    @Test
    public void test1(){
        ElementoVisualTester ele=new ElementoVisualTester();
        TeclaBlanca3 teclaBlanca3=new TeclaBlanca3(64);
        teclaBlanca3.setColorPulsado(Color.BLUE);
        ele.setElementoVisual(teclaBlanca3);
        ele.hacerPrueba();
    }

}