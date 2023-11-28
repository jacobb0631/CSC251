public class Policy {
    private int policyNumber;
    private String providerName;

    public Policy() {
        this.policyNumber = 0;
        this.providerName = "";
    }

    public Policy(int policyNumber, String providerName) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
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
}
