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

                PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
                if ("smoker".equalsIgnoreCase(smokingStatus)) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }

                Policy policy = new Policy(policyNumber, providerName, policyHolder);
                policies.add(policy);

                System.out.println(policy);
            }
            
            System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
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