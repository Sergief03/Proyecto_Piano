package jd.piano.programa.test;

import jd.piano.programa.PianoSencillo;
import jd.piano.teclas.ElementoVisualTester;
import org.junit.Test;

import static org.junit.Assert.*;

public class PianoSencilloTest {
    @Test
    public void test1(){
        PianoSencillo pianoSencillo=new PianoSencillo(36,72);
        ElementoVisualTester ele=new ElementoVisualTester();
        ele.setElementoVisual(pianoSencillo);
        boolean prueba=ele.hacerPrueba();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!prueba){
            fail("La prueba no ha salido bien");
        }
    }

    @Test
    public void test2(){
        PianoSencillo pianoSencillo=new PianoSencillo(36,48);
        assertEquals(pianoSencillo.getAnchura(),325);
        assertEquals(pianoSencillo.getAltura(),100);
    }

}