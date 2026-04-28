import java.util.LinkedList;
import java.util.List;

public class TRAINMANAGEMENTAPP {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("====================================\n");

        // Create a LinkedList
        List<String> trainConsist = new LinkedList<>();

        // Add initial bogies
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        // Display initial train consist
        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist + "\n");

        // Insert "Pantry Car" at position 2 (index 2)
        trainConsist.add(2, "Pantry Car");

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist + "\n");

        // Remove first and last bogie
        trainConsist.remove(0); // remove Engine
        trainConsist.remove(trainConsist.size() - 1); // remove Guard

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist + "\n");

        System.out.println("UC4 ordered consist operations completed...");
    }
}