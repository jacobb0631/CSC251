public class Policy {
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    /**
     * Default constructor. Sets everything to zero or empty.
     */
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0;
        this.weight = 0;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    /**
     * Constructor with all the details.
     *
     * @param policyNumber The unique number of the policy.
     * @param providerName Who's providing the insurance.
     * @param firstName Policyholder's first name.
     * @param lastName Policyholder's last name.
     * @param age How old they are.
     * @param smokingStatus Smoker or not.
     * @param height Height in inches.
     * @param weight Weight in pounds.
     */
    public Policy(int policyNumber, String providerName, String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Calculates BMI of policyholder.
     *
     * @return The calculated BMI.
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Works out the policy price. It's more if you're over 50, a smoker, or have a high BMI.
     *
     * @return The total price.
     */
    public double calculatePrice() {
        double price = 600;
        if(age > 50) {
            price += 75;
        }
        if(smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100;
        }
        double bmi = calculateBMI();
        if(bmi > 35) {
            price += (bmi - 35) * 20;
        }
        return price;
    }
}