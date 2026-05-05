import java.util.*;
import java.util.stream.Collectors;

public class TRAINMANAGEMENTAPP {

    // ================= MODEL CLASS =================
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // ================= GROUPING METHOD =================
    public static Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("==========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        Map<String, List<Bogie>> groupedBogies = groupBogies(bogies);

        System.out.println("\nGrouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println("Capacity -> " + b.capacity);
            }
        }

        System.out.println("\nUC9 grouping completed...");

        System.out.println("\n==========================================");
        System.out.println("TEST CASE RESULTS");
        System.out.println("==========================================");

        testGrouping_BogiesGroupedByType();
        testGrouping_MultipleBogiesInSameGroup();
        testGrouping_DifferentBogieTypes();
        testGrouping_EmptyBogieList();
        testGrouping_SingleBogieCategory();
        testGrouping_MapContainsCorrectKeys();
        testGrouping_GroupSizeValidation();
        testGrouping_OriginalListUnchanged();

        System.out.println("\nAll test cases executed successfully.");
    }

    // ================= SIMPLE ASSERT METHOD =================
    static void check(boolean condition, String testName) {
        if (condition) {
            System.out.println(testName + " : PASSED");
        } else {
            System.out.println(testName + " : FAILED");
        }
    }

    // ================= TEST CASES =================

    static void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        check(result.containsKey("Sleeper") &&
                        result.get("Sleeper").size() == 2,
                "testGrouping_BogiesGroupedByType()");
    }

    static void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("AC Chair", 56),
                new Bogie("AC Chair", 60)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        check(result.get("AC Chair").size() == 2,
                "testGrouping_MultipleBogiesInSameGroup()");
    }

    static void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        check(result.size() == 3,
                "testGrouping_DifferentBogieTypes()");
    }

    static void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result = groupBogies(bogies);

        check(result.isEmpty(),
                "testGrouping_EmptyBogieList()");
    }

    static void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("First Class", 24)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        check(result.size() == 1 &&
                        result.containsKey("First Class"),
                "testGrouping_SingleBogieCategory()");
    }

    static void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        check(result.containsKey("Sleeper") &&
                        result.containsKey("AC Chair") &&
                        result.containsKey("First Class"),
                "testGrouping_MapContainsCorrectKeys()");
    }

    static void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 56)
        );

        Map<String, List<Bogie>> result = groupBogies(bogies);

        check(result.get("Sleeper").size() == 2 &&
                        result.get("AC Chair").size() == 1,
                "testGrouping_GroupSizeValidation()");
    }

    static void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        int originalSize = bogies.size();

        groupBogies(bogies);

        check(bogies.size() == originalSize,
                "testGrouping_OriginalListUnchanged()");
    }
}