import java.util.Arrays;
import java.util.LinkedList;
public class Tuple {
    private LinkedList<AttributeValue> values;

    /*This is a constructor for a tuple which just takes in a list of Attributevalues, and sets them to the
     * values list.
     */
    public Tuple(AttributeValue[] values){
        this.values=new LinkedList<AttributeValue>(Arrays.asList(values));
    }

    /*This just gets the value of a specific attribute by searching for the attribute name, and then
     * return the specific attribute
    */
    public String getValue(String attributeName){
        for(AttributeValue value:values){
            if(value.getName().equals(attributeName)){
                return value.getValue();
            }
        }
        System.out.println("Value not found");
        return null;
    }
}
