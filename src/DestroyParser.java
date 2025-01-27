public class DestroyParser {

    String input;

    public DestroyParser(String input) {
        this.input = input;
    }

    public String parseRelationName() {
        String[] words = input.split(" ");
        String relation = words[1].substring(0, words[1].length() - 1);

        return relation;
    }
}
