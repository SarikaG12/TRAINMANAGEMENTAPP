import java.util.*;
import java.util.stream.*;

public class TRAINMANAGEMENTAPP {

    // ================= MODEL =================
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("==============================================\n");

        // Create large dataset
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", 70 + (i % 5)));
        }

        // ================= LOOP METHOD =================
        long startLoop = System.nanoTime();

        int sumLoop = 0;
        for (Bogie b : bogies) {
            if (b.capacity > 70) {   // filtering condition
                sumLoop += b.capacity;
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ================= STREAM METHOD =================
        long startStream = System.nanoTime();

        int sumStream = bogies.stream()
                .filter(b -> b.capacity > 70)
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ================= OUTPUT =================
        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 performance benchmarking completed...");

        // ================= TEST CASES =================
        System.out.println("\n==============================================");
        System.out.println("TEST CASE RESULTS");
        System.out.println("==============================================");

        testLoopFilteringLogic();
        testStreamFilteringLogic();
        testLoopAndStreamResultsMatch();
        testExecutionTimeMeasurement();
        testLargeDatasetProcessing();

        System.out.println("\nAll test cases executed successfully.");
    }

    // ================= ASSERT =================
    static void check(boolean condition, String name) {
        if (condition)
            System.out.println(name + " : PASSED");
        else
            System.out.println(name + " : FAILED");
    }

    // ================= TEST CASES =================

    static void testLoopFilteringLogic() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 60),
                new Bogie("B", 80)
        );

        int sum = 0;
        for (Bogie b : list) {
            if (b.capacity > 70) sum += b.capacity;
        }

        check(sum == 80, "testLoopFilteringLogic()");
    }

    static void testStreamFilteringLogic() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 60),
                new Bogie("B", 80)
        );

        int sum = list.stream()
                .filter(b -> b.capacity > 70)
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        check(sum == 80, "testStreamFilteringLogic()");
    }

    static void testLoopAndStreamResultsMatch() {
        List<Bogie> list = Arrays.asList(
                new Bogie("A", 60),
                new Bogie("B", 80)
        );

        int loopSum = 0;
        for (Bogie b : list) {
            if (b.capacity > 70) loopSum += b.capacity;
        }

        int streamSum = list.stream()
                .filter(b -> b.capacity > 70)
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        check(loopSum == streamSum, "testLoopAndStreamResultsMatch()");
    }

    static void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        long end = System.nanoTime();

        check(end >= start, "testExecutionTimeMeasurement()");
    }

    static void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("A", 75));
        }

        int sum = list.stream()
                .filter(b -> b.capacity > 70)
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        check(sum > 0, "testLargeDatasetProcessing()");
    }
}