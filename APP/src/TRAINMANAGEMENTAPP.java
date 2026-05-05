import java.util.*;
import java.util.regex.Pattern;

public class TRAINMANAGEMENTAPP {

    static final String TRAIN_ID_REGEX = "TRN-[0-9]{4}";
    static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    public static boolean isValidTrainId(String trainId) {
        return Pattern.matches(TRAIN_ID_REGEX, trainId);
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches(CARGO_CODE_REGEX, cargoCode);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("==========================================\n");

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        boolean trainValid = isValidTrainId(trainId);
        boolean cargoValid = isValidCargoCode(cargoCode);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + trainValid);
        System.out.println("Cargo Code Valid: " + cargoValid);

        System.out.println("\nUC11 validation completed...");

        System.out.println("\n==========================================");
        System.out.println("TEST CASE RESULTS");
        System.out.println("==========================================");

        testRegex_ValidTrainID();
        testRegex_InvalidTrainIDFormat();
        testRegex_ValidCargoCode();
        testRegex_InvalidCargoCodeFormat();
        testRegex_TrainIDDigitLengthValidation();
        testRegex_CargoCodeUppercaseValidation();
        testRegex_EmptyInputHandling();
        testRegex_ExactPatternMatch();

        System.out.println("\nAll test cases executed successfully.");

        scanner.close();
    }

    static void check(boolean condition, String testName) {
        if (condition) {
            System.out.println(testName + " : PASSED");
        } else {
            System.out.println(testName + " : FAILED");
        }
    }

    static void testRegex_ValidTrainID() {
        check(isValidTrainId("TRN-1234"),
                "testRegex_ValidTrainID()");
    }

    static void testRegex_InvalidTrainIDFormat() {
        check(!isValidTrainId("TRAIN12") &&
                        !isValidTrainId("TRN12A") &&
                        !isValidTrainId("1234-TRN"),
                "testRegex_InvalidTrainIDFormat()");
    }

    static void testRegex_ValidCargoCode() {
        check(isValidCargoCode("PET-AB"),
                "testRegex_ValidCargoCode()");
    }

    static void testRegex_InvalidCargoCodeFormat() {
        check(!isValidCargoCode("PET-ab") &&
                        !isValidCargoCode("PET123") &&
                        !isValidCargoCode("AB-PET"),
                "testRegex_InvalidCargoCodeFormat()");
    }

    static void testRegex_TrainIDDigitLengthValidation() {
        check(!isValidTrainId("TRN-123") &&
                        !isValidTrainId("TRN-12345"),
                "testRegex_TrainIDDigitLengthValidation()");
    }

    static void testRegex_CargoCodeUppercaseValidation() {
        check(!isValidCargoCode("PET-ab") &&
                        !isValidCargoCode("PET-aB"),
                "testRegex_CargoCodeUppercaseValidation()");
    }

    static void testRegex_EmptyInputHandling() {
        check(!isValidTrainId("") &&
                        !isValidCargoCode(""),
                "testRegex_EmptyInputHandling()");
    }

    static void testRegex_ExactPatternMatch() {
        check(!isValidTrainId("XXTRN-1234YY") &&
                        !isValidCargoCode("XXPET-ABYY"),
                "testRegex_ExactPatternMatch()");
    }
}