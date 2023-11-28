public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    public PolicyHolder() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0;
        this.weight = 0;
    }

    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    @Override
    public String toString() {
        return "Policyholder's First Name: " + firstName +
               "\nPolicyholder's Last Name: " + lastName +
               "\nPolicyholder's Age: " + age +
               "\nPolicyholder's Smoking Status: " + smokingStatus +
               String.format("\nPolicyholder's Height: %.2f inches", height) +
               String.format("\nPolicyholder's Weight: %.2f pounds", weight) +
               String.format("\nPolicyholder's BMI: %.2f", calculateBMI());
    }
}