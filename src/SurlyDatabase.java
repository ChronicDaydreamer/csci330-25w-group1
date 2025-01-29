import java.util.LinkedList;
public class SurlyDatabase{
    private LinkedList<Relation> relations;
    
    /*Costructor for the Surly database
     *Creates a linkedlist of relations, and then creates the CATALOG relation*/
    public SurlyDatabase(){
        this.relations=new LinkedList<Relation>();
        this.relations.add(new Relation("CATALOG"));
    }

    /*Gets the Relation specified by name from the relations list
     * Does this by searching through relations until it gets to the first relation with the same name
     * if not found, returns null
     */
    public Relation getRelation(String name){
        for(Relation relation : this.relations){
            if(relation.getName().equals(name)){
                return relation;
            }
        }
        System.out.println("Relation not found in database");
        return null;
    }

    /*Removes the relation from the relations list using linkedlist.remove() */
    public void destroyRelation(String name){
        this.relations.remove(this.getRelation(name));
    }
    
    /*appends a new relation to the relations list by using linkedlist.add() */
    public void createRelation(Relation relation){
        this.relations.add(relation);
    }
}
