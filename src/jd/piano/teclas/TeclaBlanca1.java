package jd.piano.teclas;

public class TeclaBlanca1 extends TeclaBlanca{
    TeclaBlanca1(int n) {
        super(n);
    }

    @Override
    protected int[] getVerticesX() {
        int x = this.posicion.x;
        int anchura = this.getAnchura();
        return new int[]{x, x, x + anchura, x + anchura};
    }

    @Override
    protected int[] getVerticesY() {
        int y = this.posicion.y;
        int altura = this.getAltura();
        return new int[]{y, y + altura, y + altura, y};
    }
}
