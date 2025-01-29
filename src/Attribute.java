public class Attribute {

    private String name, type, length;

    public Attribute() {}
    
    public Attribute(String name, String type, String length) {
        this.name = name;
        this.type = type;
        this.length = length;
    }

    public String getName() {return this.name;}
    public void setName(String newName) {this.name = newName;}

    public String getType() {return this.type;}
    public void setType(String newType) {this.type = newType;}

    public String getLength() {return this.length;}
    public void setLength(String newLength) {this.length = newLength;}
}
