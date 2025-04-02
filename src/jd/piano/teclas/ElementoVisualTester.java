package jd.piano.teclas;

import bpc.daw.consola.*;

import java.awt.*;

public class ElementoVisualTester {
    private Graphics graphics;
    private ElementoVisual elemento;

    public ElementoVisualTester(Graphics g){
        this.graphics=g;
    }

    public ElementoVisualTester(){
        Consola consola=new Consola();
        CapaFondo capaFondo= consola.getCapaFondo();
        capaFondo.setFondo(new FondoColorSolido(Color.GRAY));
        CapaCanvas capaCanvas=consola.getCapaCanvas();
        this.graphics= capaCanvas.getGraphics();
    }

    public void setElementoVisual(ElementoVisual e){
        this.elemento=e;
    }

    public boolean hacerPrueba(){
        this.elemento.setPosicion(120,90);
        this.elemento.setGraphics(this.graphics);
        this.elemento.dibujar();
        if (this.elemento instanceof Pulsable p){
            p.setColorPulsado(Color.BLUE);
            try {
                Thread.sleep(2000);
                p.pulsar();
                Thread.sleep(2000);
                p.soltar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Consola consola=new Consola();
        CapaTexto capaTexto= consola.getCapaTexto();;
        Teclado teclado= consola.getTeclado();
        capaTexto.print("¿Ha salido bien el test?(S/N): ");
        char eleccion=teclado.leerCaracter();
        return eleccion=='s'||eleccion=='S'? true:false;
    }
}
