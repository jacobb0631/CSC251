public class Policy {
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

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

    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }
    public int getPolicyNumber() { return policyNumber; }

    public void setProviderName(String providerName) { this.providerName = providerName; }
    public String getProviderName() { return providerName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }

    public void setAge(int age) { this.age = age; }
    public int getAge() { return age; }

    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }
    public String getSmokingStatus() { return smokingStatus; }

    public void setHeight(double height) { this.height = height; }
    public double getHeight() { return height; }

    public void setWeight(double weight) { this.weight = weight; }
    public double getWeight() { return weight; }

    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

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