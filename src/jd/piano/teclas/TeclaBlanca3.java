package jd.piano.teclas;

public class TeclaBlanca3 extends TeclaBlanca{
    TeclaBlanca3(int n) {
        super(n);
    }

    @Override
    protected int[] getVerticesX() {
        int x = this.posicion.x;
        int anchura = this.getAnchura();
        return new int[]{(x+anchura)-(TeclaNegra.ANCHURA/2), (x+anchura)-(TeclaNegra.ANCHURA/2), x, x, x+anchura, x+anchura};
    }

    @Override
    protected int[] getVerticesY() {
        int y = this.posicion.y;
        int altura = this.getAltura();
        return new int[]{y, y + TeclaNegra.ALTURA, y + TeclaNegra.ALTURA, y+altura, y+altura, y};
    }
}
