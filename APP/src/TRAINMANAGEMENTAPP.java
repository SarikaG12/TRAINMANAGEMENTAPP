import java.util.LinkedHashSet;
import java.util.Set;

public class TRAINMANAGEMENTAPP {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("===========================================\n");

        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // ---- Add bogies (including duplicates) ----
        formation.add("BG101");
        formation.add("BG102");
        formation.add("BG103");
        formation.add("BG104");

        // Duplicate entries (ignored automatically)
        formation.add("BG102");
        formation.add("BG101");

        // Display final train formation
        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote:");
        System.out.println("Insertion order is preserved and duplicates are ignored.");

        System.out.println("\nUC5 ordered uniqueness validation completed...");
    }
}