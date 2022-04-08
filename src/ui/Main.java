package ui;
import java.util.Scanner;
import model.*;

/**
      *class Main <br>
      *The program most allow the user to creat a Max total of 80 wetlands, in each wetland can create events and species all with their respective atributes <br>
      *@author Isaac Calle Cardozo <br>
      *@date 7/04/2022
       */

    public class Main { 
        public static Scanner lt = new Scanner(System.in);

        /**
      *main.<br>
      *Metodo main de la clase<br>
      *@param args
      * Inputs: <br>
      *boolean: to continue until needed <br>
      *WetlandController: to call de class WetlandController in a object. <br>
      * Outputs: <br>
      *String: String with the message that going to return. <br>
       */

        public static void main (String[] args){
            boolean seguir=true;
            WetlandController objW=registrarWetlandController();
            while(seguir==true)
            {
                System.out.println("1.Create a wetland.");
                System.out.println("2.Register new specie in a wetland.");
                System.out.println("3.Register a new event in a wetland.");
                System.out.println("4.Amount of maintenance.");
                System.out.println("5.Wetland with less species of plants (flora).");
                System.out.println("6.Info of all the wetlands."); 
                System.out.println("7.Name of the specie.");
                System.out.println("8.Wetland with more amount of animals (fauna).");
                System.out.println("0.EXIT");
                int ans=lt.nextInt();
                lt.nextLine();
                String res="";
                if(ans==1){
                    res=addWetland(objW);
                }
                if(ans==2){
                    res=addSpecie(objW);
                }
                if(ans==3){
                    res=addEvent(objW);
                }
                if(ans==4){
                    res=maintenment(objW);
                }
                if(ans==5){
                    res=menosEspecie(objW);
                }
                if(ans==6){
                    res=allInfo(objW);
                }
                if(ans==7){
                    res=searchSpecie(objW);
                }
                if(ans==8){
                    res=masEspecie(objW);
                }
                if(ans==0){
                    seguir=false;
                    System.out.println("Thanks for using my program :D");
                }

                System.out.println(res);
            }
       
        }

        /**
      *Name: registrarWetlandController<br>
      * preCondition: <br>
      * postCondition: <br>
      *@return a object type WetlandController.
      * Salidas: <br>
       */

        public static WetlandController registrarWetlandController(){
            WetlandController a=new WetlandController();
            return a;
        }

        /**
      *Name: addWetland<br>
      * preCondition: The data ingressed by the user was correct (the number 1 in the list). <br>
      * postCondition: Tell user if the wetland have been registed. <br>
      *@return register or not.
      * Salidas: <br>
       */

        public static String addWetland(WetlandController a){
            System.out.println("Name of the wetland: ");
            String n=lt.nextLine();
            System.out.println("Ubication of the wetland: (1.urban / 2.rural) ");
            int u=lt.nextInt();
            lt.nextLine();
            String s=a.qPublic(u);
            while(s.equals("There are already 50 wetlands in urban zone"))
            {
                System.out.println(s);
                System.out.println("Ubication of the wetland: (1.urban / 2.rural) ");
                u=lt.nextInt();
                lt.nextLine();
                s=a.qPublic(u);
            }
             
            System.out.println("Type of the wetland: (1.public / 2.private) ");
            int t=lt.nextInt();
            lt.nextLine();
            System.out.println("Km2 of the wetland: ");
            double km2=lt.nextDouble();
            lt.nextLine();
            System.out.println("Photo of the wetland: ");
            String url=lt.nextLine();
            System.out.println("The wetland is a protected area? 1.Yes 2.No");
            int proc=lt.nextInt();
            boolean prot=false;
            if(proc==1){
                prot=true;
            }
            else if(proc==2){
                prot=false;
            }

            String res=a.addWetland(n,u,t,km2,url,prot);

            return res;
        }

      /**
      *Name: amnt5<br>
      * preCondition: The data ingressed by the user was correct. <br>
      * postCondition: Amount of papayas left were calculated. <br>
      *@param cont int to see the actual number of papayas in the array.
      *@return amount amount!="".
      * Salidas: <br>
       */

        public static String addSpecie(WetlandController a){
            System.out.println("Name of the wetland you wanna add a Specie: ");      
            String w=lt.nextLine();

            System.out.println("Name of the specie: ");
            String p=lt.nextLine();
            System.out.println("Scientific name: ");
            String k=lt.nextLine();
            System.out.println("Migratory specie: 1.Yes 2.No ");
            int ans=lt.nextInt();
            lt.nextLine();
            System.out.println("type: (1.Flora Terrestre / 2.Flora Acuatica / 3.Ave / 4.Mamifero / 5.Acuatico)");
            int t=lt.nextInt();
            lt.nextLine();
            boolean m=false;
            if(ans==1)
            {
                m=true;
            }
            else if(ans==2){
                m=false;
            }
            
            String res=a.addSpecie(p,k,m,t,w);
            return res;
    }

    /**
      *Name: amnt5<br>
      * preCondition: The data ingressed by the user was correct. <br>
      * postCondition: Amount of papayas left were calculated. <br>
      *@param cont int to see the actual number of papayas in the array.
      *@return amount amount!="".
      * Salidas: <br>
       */

        public static String addEvent(WetlandController a){
            System.out.println("Name of the wetland you wanna add a Event: ");      
            String w=lt.nextLine();

            System.out.println("Name of the event: ");
            String n=lt.nextLine();
            System.out.println("Date of the event (DD/MM/YY): ");
            int d=lt.nextInt();
            int m=lt.nextInt();
            int y=lt.nextInt();
            lt.nextLine();
            System.out.println("Price: ");
            double p=lt.nextInt();
            lt.nextLine();
            System.out.println("Description: (1.Mantenimientos 2.Visitas de colegio 3.Actividades de mejoramiento 4.Celebraciones)");
            int desc=lt.nextInt();
        
            String res=a.addEvent(n,d,m,y,p,desc,w);
            return res;
    }

    /**
      *Name: amnt5<br>
      * preCondition: The data ingressed by the user was correct. <br>
      * postCondition: Amount of papayas left were calculated. <br>
      *@param cont int to see the actual number of papayas in the array.
      *@return amount amount!="".
      * Salidas: <br>
       */

    public static String menosEspecie(WetlandController a){
        String res=a.consultMenosEspecieFlora();
        return res;
    }

    /**
      *Name: amnt5<br>
      * preCondition: The data ingressed by the user was correct. <br>
      * postCondition: Amount of papayas left were calculated. <br>
      *@param cont int to see the actual number of papayas in the array.
      *@return amount amount!="".
      * Salidas: <br>
       */

    public static String masEspecie(WetlandController a){
        String res=a.consultMasEspecieFauna();
        return res;
    }

    /**
      *Name: amnt5<br>
      * preCondition: The data ingressed by the user was correct. <br>
      * postCondition: Amount of papayas left were calculated. <br>
      *@param cont int to see the actual number of papayas in the array.
      *@return amount amount!="".
      * Salidas: <br>
       */

    public static String allInfo(WetlandController a){
        String res=a.consultAllInfo();
        return res;
    }

    /**
      *Name: amnt5<br>
      * preCondition: The data ingressed by the user was correct. <br>
      * postCondition: Amount of papayas left were calculated. <br>
      *@param cont int to see the actual number of papayas in the array.
      *@return amount amount!="".
      * Salidas: <br>
       */

    public static String searchSpecie(WetlandController a){
        System.out.println("Name of the animal that you wanna search: ");
        String n=lt.nextLine();
        String res=a.consultSpecie(n);
        return res;
    }

    /**
      *Name: amnt5<br>
      * preCondition: The data ingressed by the user was correct. <br>
      * postCondition: Amount of papayas left were calculated. <br>
      *@param cont int to see the actual number of papayas in the array.
      *@return amount amount!="".
      * Salidas: <br>
       */
      
    public static String maintenment(WetlandController a){
        System.out.println("Year: ");
        int y=lt.nextInt();
        String res=a.countMaintenment(y);
        return res;
    }
}