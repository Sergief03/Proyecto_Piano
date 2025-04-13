package jd.piano.teclas;

import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.Consola;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TeclaNegraTest {
    @Test
    public void test1(){
        ElementoVisualTester ele=new ElementoVisualTester();
        TeclaNegra teclaNegra=new TeclaNegra(61);
        teclaNegra.setColorPulsado(Color.BLUE);
        ele.setElementoVisual(teclaNegra);
        ele.hacerPrueba();
    }

}