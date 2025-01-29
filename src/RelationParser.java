import java.util.LinkedList;

public class RelationParser {

    private String input;
    public RelationParser(String input) {
        this.input = input;
    }

    public String parseRelationName() {
        String[] words = input.split(" ");
        return words[1];
    }

    public Relation parseRelation() {
        LinkedList<Attribute> attributes = new LinkedList<>();
        String[] words = this.input.split(" ");

        String name, type, length;

        for (int i = 2; i < words.length; i += 3) {
            // cut out "(" beginning if present
            name = words[i];
            if (name .startsWith("(")) name = name.substring(1);

            type = words[i+1];

            // cut off , and ); if present
            length = words[i+2];
            length = length.substring(0, length.length() - 1);
            if (length.endsWith(")")) length = length.substring(0, length.length() - 2);

            attributes.add(new Attribute(name, type, length));
        }

        return new Relation(parseRelationName(), attributes);
    }

    public int parseAttributeCount() {
        String[] words = input.split(" ");

        // parentheses check
        if (!words[2].startsWith("(")) return -1;
        if (!words[words.length - 1].endsWith(");")) return -1;

        // comma check
        for (int i = 4; i < words.length - 1; i += 3) {
            if (!words[i].endsWith(",")) return -1;
        }

        return (words.length - 2) / 3;
    }
}
