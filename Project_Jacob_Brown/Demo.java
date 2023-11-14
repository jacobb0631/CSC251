import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Demo {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("PolicyInformation.txt"));
            ArrayList<Policy> policies = new ArrayList<>();
            int smokerCount = 0;
            int nonSmokerCount = 0;

            while (fileScanner.hasNextLine()) {
                String policyNumberStr = getNextNonEmptyLine(fileScanner);
                if (policyNumberStr == null) break;

                int policyNumber = Integer.parseInt(policyNumberStr);
                String providerName = getNextNonEmptyLine(fileScanner);
                String firstName = getNextNonEmptyLine(fileScanner);
                String lastName = getNextNonEmptyLine(fileScanner);
                int age = Integer.parseInt(getNextNonEmptyLine(fileScanner));
                String smokingStatus = getNextNonEmptyLine(fileScanner);
                double height = Double.parseDouble(getNextNonEmptyLine(fileScanner));
                double weight = Double.parseDouble(getNextNonEmptyLine(fileScanner));

                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);

                if ("smoker".equalsIgnoreCase(smokingStatus)) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }

                System.out.println("\nPolicy Number: " + policy.getPolicyNumber());
                System.out.println("Provider Name: " + policy.getProviderName());
                System.out.println("Policyholder's First Name: " + policy.getFirstName());
                System.out.println("Policyholder's Last Name: " + policy.getLastName());
                System.out.println("Policyholder's Age: " + policy.getAge());
                System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
                System.out.printf("Policyholder's Height: %.2f inches\n", policy.getHeight());
                System.out.printf("Policyholder's Weight: %.2f pounds\n", policy.getWeight());
                System.out.printf("Policyholder's BMI: %.2f\n", policy.calculateBMI());
                System.out.printf("Policy Price: $%.2f\n", policy.calculatePrice());
            }

            System.out.println("\nThe number of policies with a smoker is: " + smokerCount);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static String getNextNonEmptyLine(Scanner scanner) {
        String line;
        do {
            if (!scanner.hasNextLine()) return null;
            line = scanner.nextLine().trim();
        } while (line.isEmpty());
        return line;
    }
}