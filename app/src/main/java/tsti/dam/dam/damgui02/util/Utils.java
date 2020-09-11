package tsti.dam.dam.damgui02.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static final String[] GENEROS={"Accion","Suspenso","Terror","Animación","Policial","Comedia","Drama"};

    private static  List<Serie> _SERIES=  null;

    public static List<Serie>  getSeries(){
        if(_SERIES==null) {
            _SERIES = new ArrayList<>();
            Random r = new Random();
            for (int i = 0; i < 25; i++) {
                _SERIES.add(new Serie("Serie "+i, r.nextInt(100), r.nextInt(10000), r.nextBoolean(), GENEROS[r.nextInt(GENEROS.length)]));
            }
        }
        return _SERIES;
    }
}
