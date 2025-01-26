import java.util.Scanner;
import java.io.File;
import java.lang.StringBuilder;

public class LexicalAnalyzer {
    public void run(String fileName) {
        File file = null;
        Scanner sc = null;
        try {
            file = new File(fileName);
            sc = new Scanner(file);
        } catch (Exception FileNotFoundException) {
            System.out.println("File Not Found");
            //throw new FileNotFoundException();
        }

        if (sc != null) parse(sc);
    }

    private void parse(Scanner sc) {
        String instruction;

        while (sc.hasNext()) {
            instruction = getNextInstruction(sc);
            execute(instruction);
        }
    }

    private void execute(String instruction) {
        String command = instruction.split(" ")[0].toUpperCase();

        switch (command) {
            case ("RELATION"): {
                printRelation(instruction);
                break;
            }

            case ("INSERT"): {
                printInsert(instruction);
                break;
            }

            case ("PRINT"): {
                printPrint(instruction);
                break;
            }
        }
    }

    private void printRelation(String instruction) {
        RelationParser relationParser = new RelationParser(instruction);
        String relationName = relationParser.parseRelationName();
        int attrCount = relationParser.parseAttributeCount();
        System.out.println("Creating " + relationName + " with " + attrCount + " attributes.");
    }

    private void printInsert(String instruction) {
        InsertParser insertParser = new InsertParser(instruction);
        String relationName = insertParser.parseRelationName();
        int attrCount = insertParser.parseAttributeCount();
        System.out.println("Inserting " + attrCount + " attributes to " + relationName + ".");
    }

    private void printPrint(String instruction) {
        PrintParser printParser = new PrintParser(instruction);
        String[] relationNames = printParser.parseRelationNames();
        System.out.print("Printing " + relationNames.length + " relations: ");
        int i;
        for (i = 0; i < relationNames.length - 1; i++) {
            System.out.print(relationNames[i] + ", ");
        }
        System.out.println(relationNames[i] + ".");
    }

    public String getNextInstruction(Scanner sc) {
        StringBuilder instruction = new StringBuilder();
        String newLine;

        while (!instruction.toString().endsWith(";")) {
            if (!sc.hasNext()) return null; // no more instruction or file ended without semicolon

            newLine = sc.nextLine();
            while (newLine.isEmpty()) {
                newLine = sc.nextLine();
            }

            if (!newLine.startsWith("#"))
                instruction.append(newLine);
        }

        // remove extra spaces
        int i;
        while ((i = instruction.indexOf("  ")) != -1) {
            instruction.replace(i, i + 2, " ");
        }

        return instruction.toString();
    }
}
