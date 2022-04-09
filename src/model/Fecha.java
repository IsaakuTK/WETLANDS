package model;

public class Fecha {
    //atributos
    private int day;
    private int month;
    private int year;

    //relaciones

    //metodos

    public Fecha(int day, int month, int year) {
        this.day=day;
        this.month=month;
        this.year=year;
    }

    
    /** 
     * @return int
     */
    public int getYear() {
        return year;
    }

    
    /** 
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    
    /** 
     * @return int
     */
    public int getMonth() {
        return month;
    }

    
    /** 
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    
    /** 
     * @return int
     */
    public int getDay() {
        return day;
    }

    
    /** 
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

}
