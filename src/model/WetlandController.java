package model;

public class WetlandController {
    public static final int MAXWL=80;
    public static final int MAXP=50;

    //atributos
    private String name; 

    //relaciones
    private Wetland[] wetlands;

    //metodos

    public WetlandController() {
        wetlands=new Wetland[MAXWL];
        this.name="Santiago de Cali";
    }
    
    /** 
     * @param n
     * @param u
     * @param t
     * @param km2
     * @param url
     * @param prot
     * @return String
     */
    public String addWetland(String n, int u, int t, double km2, String url, boolean prot){
        boolean continuar=true;
    String message="Wetland is now registed";
    boolean existeWet=existWetland(n);
    if (existeWet==true)
       message="The Wetland already exist";
    else
    {
      for (int i=0;(i<MAXWL) && continuar==true;i++){
        if (wetlands[i]==null){
            wetlands[i]=new Wetland(n,u,t,km2,url,prot);
           continuar=false;
        }
      }
      if(continuar==true)
        message="The wetland are already full. You can't add more";
    }
    return message;
    }

    
    /** 
     * @param n
     * @return boolean
     */
    public boolean existWetland(String n){
        boolean resultado=false;        
        for(int i=0;i<MAXWL && resultado==false; i++){
            if(wetlands[i]!=null && wetlands[i].getName().equals(n))
                resultado=true;
        }
        return resultado;
     }

    
    /** 
     * @return Wetland[]
     */
    public Wetland[] getWetland() {
        return this.wetlands;
    }

    
    /** 
     * @param wetlands
     */
    public void setWetland(Wetland[] wetlands) {
        this.wetlands = wetlands;
    }

    
    /** 
     * @param p
     * @param k
     * @param m
     * @param t
     * @param h
     * @return String
     */
    public String addSpecie(String p, String k, boolean m, int t, String h){    
        String message="You cant add a specie in this wetland";
            int w=searchWetland(h);
            if(w!=-1)
            {
                if (wetlands[w]!=null){
                    message=wetlands[w].addSpecie(p,k,m,t);
                }
            }
        return message;
    }

    
    /** 
     * @param h
     * @return int
     */
    public int searchWetland(String h){    
        int w=-1;
        boolean seguir=true;
        for(int i=0;i<MAXWL && seguir==true;i++)
        {
            if(wetlands[i]!=null)
            {
                if(wetlands[i].getName().equals(h))
                {
                    w=i;
                    seguir=false;
                }
            }
        }
        return w;
    }

    
    /** 
     * @param n
     * @param d
     * @param m
     * @param y
     * @param p
     * @param desc
     * @param h
     * @return String
     */
    public String addEvent(String n, int d, int m, int y, double p, int desc, String h){    
        String message="You cant add a Event in this wetland";
            int w=searchWetland(h);
            if(w!=-1){
                if (wetlands[w]!=null){
                    message=wetlands[w].addEvent(n,d,m,y,p,desc);
                }
            }
        return message;
    }
    
    /** 
     * @return String
     */
    public String viewWetlands(){
        String message="";
        for(int i=0; i<MAXWL;i++)
        {
            if(wetlands[i]!=null)
            {
                message+="\n"+(i+1)+wetlands[i].getName();
            }
        }
        return message;
    }
    
    /** 
     * @return String
     */
    public String consultMenosEspecieFlora(){
        String message="";
        String name="";
        int num1=999999;
        for(int i=0; i<MAXWL;i++)
        {
            if(wetlands[i]!=null)
            {
               if(num1>wetlands[i].consultQuantityEspecieFl() && wetlands[i].consultQuantityEspecieFl()!=0){
                   num1=wetlands[i].consultQuantityEspecieFl();
                   name=wetlands[i].getName();
               }
            }
        }
        message="The Wetland with less species of flora: "+name; 
        return message;
    }
    
    /** 
     * @return String
     */
    public String consultMasEspecieFauna(){
        String message="";
        String name="";
        int num1=0;
        for(int i=0; i<MAXWL;i++)
        {
            if(wetlands[i]!=null)
            {
               if(num1<wetlands[i].consultQuantityEspecieFa()){
                   num1=wetlands[i].consultQuantityEspecieFa();
                   name=wetlands[i].getName();
               }
            }
        }
        message="The Wetland with more species of fauna: "+name; 
        return message;
    }

    
    /** 
     * @return String
     */
    public String consultAllInfo(){
        String message="";
        for(int i=0; i<MAXWL;i++)
        {
            if(wetlands[i]!=null)
            {
                message+="\n "+wetlands[i].getName()+" this Wetland is ubicated in a "+wetlands[i].getUbication()+" place and is "+wetlands[i].getType()+" also have "+wetlands[i].getKm2()+"Km2. Image:"+wetlands[i].getUrl()+"\n Specie of flora: "+wetlands[i].consultQuantityEspecieFl()+"\n Species of fauna: "+wetlands[i].consultQuantityEspecieFa()+"\n";
            }
        }
        return message;
    }
    
    /** 
     * @param name
     * @return String
     */
    public String consultSpecie(String name){
        String message="The specie is in the wetland(s): ";
        for(int i=0; i<MAXWL;i++)
        {
            if(wetlands[i]!=null && wetlands[i].searchName(name)==true)
            {
                message+="\n"+wetlands[i].getName();
            }
        }
        if(message.equals("The specie is in the wetland(s): "))
        {
            message="That Specie dont exist";
        }
        return message;
    }
    
    /** 
     * @param y
     * @return String
     */
    public String countMaintenment(int y){
        String message="";
        for(int i=0; i<MAXWL;i++)
        {
            if(wetlands[i]!=null)
            {
                message+="\n "+wetlands[i].getName()+" in the year: "+y+" have "+wetlands[i].getNumberMaint(y)+" Maintenment Events \n";
            }
        }
        return message;
    }

    
    /** 
     * @param u
     * @return String
     */
    public String qPublic(int u){
        String message="";
        int cont=0;
        for(int i=0; i<MAXWL;i++)
        {
            if(wetlands[i]!=null && wetlands[i].getUbication()==TypeU.URBAN)
            {
                cont++;
            }
        }
        if(MAXP<=cont && u==1)
        {
            message="There are already 50 wetlands in urban zone";
        }
        else
        {
            message="";
        }
        return message;
    }
}
