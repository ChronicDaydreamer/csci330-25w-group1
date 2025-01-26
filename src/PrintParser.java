public class PrintParser {

    private String input;

    public PrintParser(String input) {
        this.input = input;
    }

    public String[] parseRelationNames() {
        String[] words = input.split(" ");
        String[] relationNames = new String[words.length - 1];

        String newRelation;
        for (int i = 1; i < words.length; i++) {
            newRelation = words[i].substring(0, words[i].length() - 1);
            relationNames[i - 1] = newRelation;
        }

        return relationNames;
    }
}
