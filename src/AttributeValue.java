public class AttributeValue {

    String name, value;

    public AttributeValue() {};

    public AttributeValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {return this.name;}
    public void setName(String newName) {this.name = newName;}

    public String getValue() {return this.value;}
    public void setValue(String newValue) {this.value = newValue;}
}
