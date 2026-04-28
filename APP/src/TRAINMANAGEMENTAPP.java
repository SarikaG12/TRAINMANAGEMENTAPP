import java.util.*;
import java.util.stream.*;

public class TRAINMANAGEMENTAPP {

    // Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // 🔹 Filter method (used in both main + test)
    static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("=======================================\n");

        // Create list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // Display all
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // Filter
        List<Bogie> filtered = filterBogies(bogies, 60);

        // Display filtered
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        System.out.println("\nUC8 filtering completed...\n");

        // 🔥 RUN TEST CASES
        runTests();
    }

    // 🔥 TEST CASES (without JUnit)
    static void runTests() {
        System.out.println("===== RUNNING TEST CASES =====");

        // 1. Greater than
        List<Bogie> t1 = Arrays.asList(new Bogie("A", 70), new Bogie("B", 50));
        System.out.println("Test 1: " + (filterBogies(t1, 60).size() == 1));

        // 2. Equal
        List<Bogie> t2 = Arrays.asList(new Bogie("A", 60));
        System.out.println("Test 2: " + (filterBogies(t2, 60).size() == 0));

        // 3. Less than
        List<Bogie> t3 = Arrays.asList(new Bogie("A", 40));
        System.out.println("Test 3: " + (filterBogies(t3, 60).isEmpty()));

        // 4. Multiple match
        List<Bogie> t4 = Arrays.asList(
                new Bogie("A", 70),
                new Bogie("B", 80),
                new Bogie("C", 50)
        );
        System.out.println("Test 4: " + (filterBogies(t4, 60).size() == 2));

        // 5. No match
        List<Bogie> t5 = Arrays.asList(new Bogie("A", 30), new Bogie("B", 40));
        System.out.println("Test 5: " + (filterBogies(t5, 60).isEmpty()));

        // 6. All match
        List<Bogie> t6 = Arrays.asList(new Bogie("A", 70), new Bogie("B", 80));
        System.out.println("Test 6: " + (filterBogies(t6, 60).size() == 2));

        // 7. Empty list
        List<Bogie> t7 = new ArrayList<>();
        System.out.println("Test 7: " + (filterBogies(t7, 60).isEmpty()));

        // 8. Original unchanged
        List<Bogie> t8 = new ArrayList<>();
        t8.add(new Bogie("A", 70));
        filterBogies(t8, 60);
        System.out.println("Test 8: " + (t8.size() == 1));

        System.out.println("===== ALL TESTS DONE =====");
    }
}