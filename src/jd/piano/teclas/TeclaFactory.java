package jd.piano.teclas;

public class TeclaFactory {
    private TeclaFactory(){}
    public static Tecla crearTecla(int nota){
        Tecla returnarero = null;
        if (nota<=128){
            returnarero = switch (nota%12){
                case 1, 3, 6, 8, 10-> new TeclaNegra(nota);
                case 0, 5 -> new TeclaBlanca1(nota);
                case 2, 7, 9 -> new TeclaBlanca2(nota);
                case 4, 11 -> new TeclaBlanca3(nota);
                default ->null;
            };
        }
        return returnarero;
    }
}
