package jd.piano.teclas;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TeclaBlanca2Test {
    @Test
    public void test1(){
        ElementoVisualTester ele=new ElementoVisualTester();
        TeclaBlanca2 teclaBlanca2=new TeclaBlanca2(62);
        teclaBlanca2.setColorPulsado(Color.BLUE);
        ele.setElementoVisual(teclaBlanca2);
        ele.hacerPrueba();
    }

}