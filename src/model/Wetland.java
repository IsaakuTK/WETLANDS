package model;

public class Wetland {
    public static final int MAXEV=1000;
    public static final int MAXSP=1000;

    //atributos
    private String name;
    private TypeU ubication;
    private TypeW type;
    private double km2;
    private String url;
    private boolean protectedArea;
    private int likes;

    //relaciones
    private Event[] event;
    private Specie[] specie;

    //metodos

    public Wetland(String name, int ubi, int type, double km2, String url, boolean protectedArea) {
        this.name = name;
        this.km2 = km2;
        this.url = url;
        this.protectedArea = protectedArea;
        event = new Event[MAXEV];
        specie = new Specie[MAXSP];
        switch(ubi)
        {
            case 1: this.ubication=TypeU.URBAN;
            break;

            case 2: this.ubication=TypeU.RURAL;
            break;
        }
        switch(type)
        {
            case 1: this.type=TypeW.PUBLIC;
            break;

            case 2: this.type=TypeW.PRIVATE;
            break;
        }
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return TypeU
     */
    public TypeU getUbication() {
        return this.ubication;
    }

    
    /** 
     * @param ubication
     */
    public void setUbication(TypeU ubication) {
        this.ubication = ubication;
    }

    
    /** 
     * @return TypeW
     */
    public TypeW getType() {
        return this.type;
    }

    
    /** 
     * @param type
     */
    public void setType(TypeW type) {
        this.type = type;
    }

    
    /** 
     * @return double
     */
    public double getKm2() {
        return this.km2;
    }

    
    /** 
     * @param km2
     */
    public void setKm2(double km2) {
        this.km2 = km2;
    }

    
    /** 
     * @return String
     */
    public String getUrl() {
        return this.url;
    }

    
    /** 
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    
    /** 
     * @return boolean
     */
    public boolean isProtectedArea() {
        return this.protectedArea;
    }

    
    /** 
     * @return boolean
     */
    public boolean getProtectedArea() {
        return this.protectedArea;
    }

    
    /** 
     * @param protectedArea
     */
    public void setProtectedArea(boolean protectedArea) {
        this.protectedArea = protectedArea;
    }

    
    /** 
     * @return int
     */
    public int getLikes() {
        return this.likes;
    }

    
    /** 
     * @param likes
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    
    /** 
     * @return Event[]
     */
    public Event[] getEvent() {
        return this.event;
    }

    
    /** 
     * @param event
     */
    public void setEvent(Event[] event) {
        this.event = event;
    }

    
    /** 
     * @return Specie[]
     */
    public Specie[] getSpecie() {
        return this.specie;
    }

    
    /** 
     * @param specie
     */
    public void setSpecie(Specie[] specie) {
        this.specie = specie;
    }

    
    /** 
     * @param p
     * @param k
     * @param m
     * @param t
     * @return String
     */
    public String addSpecie(String p, String k, boolean m, int t){
        String message="Specie register successfully";
        boolean seguir=true;
        {
        for (int i=0;(i<MAXSP && seguir==true);i++){
                if (specie[i]==null){
                    specie[i]=new Specie(p,k,m,t);
                    seguir=false;
                }
            }
        return message;
        }
    }
    
    /** 
     * @param n
     * @param d
     * @param m
     * @param y
     * @param p
     * @param desc
     * @return String
     */
    public String addEvent(String n, int d, int m, int y, double p, int desc){
        String message="Event register successfully";
        boolean seguir=true;
        {
        for (int i=0;(i<MAXSP && seguir==true);i++){
                if (event[i]==null){
                    event[i]=new Event(n,d,m,y,p,desc);
                    seguir=false;
                }
            }
        return message;
        }
    }
    
    /** 
     * @return int
     */
    public int consultQuantityEspecieFl(){
        int cont=0;
        {
        for (int i=0;(i<MAXSP);i++){
                if (specie[i]!=null && (specie[i].getType().equals(TypeS.FLORATERRESTRE) || specie[i].getType().equals(TypeS.FLORAACUATICA))){
                    cont++; 
                }
            }
        }
        return cont;
    }
    
    /** 
     * @return int
     */
    public int consultQuantityEspecieFa(){
        int cont=0;
        {
        for (int i=0;(i<MAXSP);i++){
                if (specie[i]!=null && (specie[i].getType()==TypeS.AVE || specie[i].getType()==TypeS.MAMIFERO || specie[i].getType()==TypeS.ACUATICO)){
                    cont++;
                }
            }
        }
        return cont;
    }

    
    /** 
     * @param name
     * @return boolean
     */
    public boolean searchName(String name){
        boolean ans=false;
        {
        for (int i=0;(i<MAXSP);i++){
                if (specie[i]!=null && specie[i].getName().equals(name)){
                    ans=true;
                }
            }
        return ans;
        }
    }
    
    
    /** 
     * @param y
     * @return int
     */
    public int getNumberMaint(int y){
        int cont=0;
        {
        for (int i=0;(i<MAXEV);i++){
                if (event[i]!=null && event[i].getYear(y)==true && event[i].getDescription()==TypeE.MANTENIMIENTO){
                    cont++;
                }
            }
        return cont;
        }
    }
}
