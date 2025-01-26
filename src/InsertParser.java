public class InsertParser {

    private String input;

    public InsertParser(String input) {
        this.input = input;
    }

    public String parseRelationName() {
        String[] words = input.split(" ");
        return words[1];
    }

    public int parseAttributeCount() {
        String[] words = input.split(" ");
        int attrCount = 0;
        boolean inString = false;

        for (int i = 2; i < words.length; i++) {
            if (!inString && words[i].startsWith("'")) {
                attrCount ++;
                inString = true;
            }

            if (inString && words[i].endsWith("'")) {
                inString = false;

            } else if (!inString) {
                attrCount++;
            }
        }

        return attrCount;
    }
}
