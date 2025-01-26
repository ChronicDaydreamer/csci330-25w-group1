public class RelationParser {

    private String input;
    public RelationParser(String input) {
        this.input = input;
    }

    public String parseRelationName() {
        String[] words = input.split(" ");
        return words[1];
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
