import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Hodnocenifilmosu {
    private Map<String, String[]> hodnoceniFilmu;
    private Map<String, int[]> hodnoceniAnimaku;

    Hodnocenifilmosu(){
        hodnoceniFilmu=new HashMap<String, String[]>();
        hodnoceniAnimaku=new HashMap<String, int[]>();
    }

    public boolean setHodnoceniFilmu(String jmeno, String[] hodnoceni){
        hodnoceniFilmu.put(jmeno, hodnoceni);
        return true;
    };
    public boolean setHodnoceniAnimaku(String jmeno, int[] body){
        hodnoceniAnimaku.put(jmeno, body);
        return true;
    };
    public void vypisHodnoceni() {
        Set<String> seznamJmen = hodnoceniFilmu.keySet();


        for (String key : hodnoceniFilmu.keySet()) {
            System.out.println("Hodnoceni filmu " + key + ": " + hodnoceniFilmu.get(key));
        }
    }

    public void vypisBodiku(){
            Set<String> seznamJmen= hodnoceniAnimaku.keySet();


            for (String key : hodnoceniFilmu.keySet()) {
                System.out.println("Hodnoceni filmu " + key + ": " + hodnoceniAnimaku.get(key));
            }
    }
}
