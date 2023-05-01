import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TheDatabaze {
    TheDatabaze()
    {
        prvkyDatabaze=new HashMap<String, FilmHrany>();
    }

    public boolean setFilmHrany(String jmeno, boolean hrany, String reziser, int rokVydani, int vekDivaka, int pocetHercu, String [] herci, String [] hodnoceni, String [] recenze)
    {
        if (prvkyDatabaze.put(jmeno,new FilmHrany(jmeno, hrany, reziser, rokVydani, vekDivaka, pocetHercu, herci, hodnoceni, recenze))==null)
            return true;
        else
            return false;
    }

    public FilmHrany getFilmHrany(String jmeno)
    {
        return prvkyDatabaze.get(jmeno);
    }
    public FilmHrany getFilmHranyy(String jmeno)
    {
        System.out.println(prvkyDatabaze.get(jmeno));
        return prvkyDatabaze.get(jmeno);
    }

    public boolean vymazFilm(String jmeno)
    {
        if (prvkyDatabaze.remove(jmeno)!=null)
            return true;
        return false;
    }
    public void vypisDatabaze()
    {
        Set<String> seznamJmen= prvkyDatabaze.keySet();

        for (String key : prvkyDatabaze.keySet()) {
            System.out.println(key + ": " + prvkyDatabaze.get(key));
        }

    }
    private Map<String,FilmHrany>  prvkyDatabaze;

}