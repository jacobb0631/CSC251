public class Policy {
    private static int policyCount = 0;
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        policyCount++;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }

    public double calculatePrice(PolicyHolder holder) {
        double price = 600;
        if(holder.getAge() > 50) {
            price += 75;
        }
        if(holder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            price += 100;
        }
        double bmi = holder.calculateBMI();
        if(bmi > 35) {
            price += (bmi - 35) * 20;
        }
        return price;
    }

    public static int getPolicyCount() {
        return policyCount;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName +
               "\n" + policyHolder.toString() +
               String.format("\nPolicy Price: $%.2f\n", calculatePrice(policyHolder));
    }
}