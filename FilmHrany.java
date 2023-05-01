public class FilmHrany {
    private String jmeno;
    private boolean hrany;
    private String reziser;
    private int rokVydani;
    private int vekDivaka;
    private int pocetHercu;
    private String [] herci;
    private String [] hodnoceni = new String[10];
        private String [] recenze = new String[10];

    public FilmHrany(String jmeno, boolean hrany, String reziser, int rokVydani, int vekDivaka, int pocetHercu, String [] herci, String [] hodnoceni, String [] recenze)
    {
        this.jmeno=jmeno;
        this.hrany=hrany;
        this.reziser=reziser;
        this.rokVydani=rokVydani;
        this.vekDivaka=vekDivaka;
        this.pocetHercu=pocetHercu;
        this.herci=herci;
        this.hodnoceni=hodnoceni;
        this.recenze=recenze;
    }

    public boolean setHodnoceni(String[] hodnoceni){
        this.hodnoceni=hodnoceni;
        return true;
    }

    public boolean setJmeno(String jmeno){
        this.jmeno=jmeno;
        return true;
    }
    public boolean setReziser(String reziser){
        this.reziser=reziser;
        return true;
    }
    public boolean setRokVydani(int rokVydani){
        this.rokVydani=rokVydani;
        return true;
    }
    public boolean setVekDivaka(int vekDivaka){
        this.vekDivaka=vekDivaka;
        return true;
    }



    public String getJmeno()
    {
        return jmeno;
    }
    public boolean getHrany() { return hrany; }
    public String getReziser() { return reziser; }
    public int getRokVydani() { return rokVydani; }
    public int getVekDivaka() { return vekDivaka; }
    public int getPocetHercu() { return pocetHercu; }
    public String getHerci(int poradiHerce) {
        return herci[poradiHerce];
        }
    }





