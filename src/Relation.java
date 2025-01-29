import java.util.Arrays;
import java.util.LinkedList;
public class Relation {
    private String name;
    private LinkedList<Attribute> schema;
    private LinkedList<Tuple> tuples;

    /*Constructor for a Relation which sets the name to the specified name, and initializes
     * schema and tuples to empty linked lists
    */
    public Relation(String name){
        this.name=name;
        this.schema=new LinkedList<Attribute>();
        this.tuples=new LinkedList<Tuple>();
    }

    /*A Constructor which also takes in a list of attribute names, and uses that to create
     * the schema linked list
     */
    public Relation(String name, LinkedList<Attribute> attributes){
        this.name=name;
        this.schema=attributes;
        this.tuples=new LinkedList<>();
    }

    /*A getter for the name of the relation*/
    public String getName() {
        return name;
    }

    /*Currently this just prints out the Schema of the current relation, but im not sure if i should
     * implement it so that it prints out all the tuples as well
    */
    public void print(){
        String string =this.name+": ";
        for(Attribute attribute:this.schema){
            string+=(' '+attribute.getName());
        }
       System.out.println(string);
    }

    /*This adds a tuple to the Relation by using linkedList.add() */
    public void insert(Tuple tuple){
        this.tuples.add(tuple);
    }

    /*This deletes the relation
     * Does this by just setting an empty list to the list of tuples*/
    public void delete(){
        this.tuples=new LinkedList<Tuple>();
    }
}
