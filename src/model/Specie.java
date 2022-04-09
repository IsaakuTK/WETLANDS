package model;

public class Specie {

    //atributos
        private String name;
        private String scientificName;
        private boolean migratory;
        private TypeS type;

    //relaciones

    //metodos

    public Specie(String name, String scientificName, boolean migratory, int type) {
        this.name = name;
        this.scientificName = scientificName;
        this.migratory = migratory;
        switch(type)
        {
            case 1: this.type=TypeS.FLORATERRESTRE;
            break;

            case 2: this.type=TypeS.FLORAACUATICA;
            break;

            case 3: this.type=TypeS.AVE;
            break;

            case 4: this.type=TypeS.MAMIFERO;
            break;

            case 5: this.type=TypeS.ACUATICO;
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
     * @return String
     */
    public String getScientificName() {
        return this.scientificName;
    }

    
    /** 
     * @param scientificName
     */
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    
    /** 
     * @return boolean
     */
    public boolean isMigratory() {
        return this.migratory;
    }

    
    /** 
     * @return boolean
     */
    public boolean getMigratory() {
        return this.migratory;
    }

    
    /** 
     * @param migratory
     */
    public void setMigratory(boolean migratory) {
        this.migratory = migratory;
    }

    
    /** 
     * @return TypeS
     */
    public TypeS getType() {
        return this.type;
    }

    
    /** 
     * @param type
     */
    public void setType(TypeS type) {
        this.type = type;
    }

}
