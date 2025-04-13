package jd.piano.programa.test;

import jd.piano.programa.MultiPiano;
import jd.piano.teclas.ElementoVisualTester;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiPianoTest {
    @Test
    public void test1(){
        MultiPiano piano=new MultiPiano(38,76);
        ElementoVisualTester ele=new ElementoVisualTester();
        ele.setElementoVisual(piano);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ele.hacerPrueba();
    }

}