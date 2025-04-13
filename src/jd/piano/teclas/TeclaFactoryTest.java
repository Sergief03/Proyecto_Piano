package jd.piano.teclas;

import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.CapaFondo;
import bpc.daw.consola.Consola;
import bpc.daw.consola.FondoColorSolido;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TeclaFactoryTest {
    @Test
    public void test1(){
        Consola consola=new Consola();
        CapaFondo capaFondo=consola.getCapaFondo();
        CapaCanvas capaCanvas=consola.getCapaCanvas();
        Graphics graphics=capaCanvas.getGraphics();
        capaFondo.setFondo(new FondoColorSolido(Color.GRAY));
        ElementoVisualTester ele=new ElementoVisualTester(graphics);
        for (int nota = 60; nota <= 64; nota++) {
            Tecla tecla = TeclaFactory.crearTecla(nota);

            ele.setElementoVisual(tecla);
            boolean pruebaExitosa = ele.hacerPrueba();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}