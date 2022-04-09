package model;

public class Event {

    //atributos
    private String name;
    private double price;
    private TypeE description;

    //relaciones    
    private Fecha fecha;
    //metodos

    public Event(String name, int day, int month, int year, double price, int description) {
        this.name = name;
        this.price = price;
        switch(description)
        {
            case 1: this.description=TypeE.MANTENIMIENTO;
            break;

            case 2: this.description=TypeE.VISITA;
            break;

            case 3: this.description=TypeE.ACTIVIDADES;
            break;

            case 4: this.description=TypeE.CELEBRACIONES;
            break;
        }
        fecha = new Fecha(day,month,year);
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
     * @return double
     */
    public double getPrice() {
        return this.price;
    }

    
    /** 
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    
    /** 
     * @return TypeE
     */
    public TypeE getDescription() {
        return this.description;
    }

    
    /** 
     * @param description
     */
    public void setDescription(TypeE description) {
        this.description = description;
    }
    
    
    /** 
     * @param y
     * @return boolean
     */
    public boolean getYear(int y) {
        boolean res=false;
        if(y==fecha.getYear()){
            res=true;
        }
        return res;
    }
}
