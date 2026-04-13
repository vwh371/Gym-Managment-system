
/**
 * This i s a child class of GymMember representing regular member
 * Contains added attributes and method from GymMember for regular members
 *
 * @author Arjun Rai
 */
class RegularMember extends GymMember {

    //private attributes
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    final private String referralSource;
    private String plan;
    private double price;

    /**
     * Constructor for RegularMember class
     * 
     * @param id
     * @param name
     * @param location
     * @param phone
     * @param email
     * @param gender
     * @param DOB
     * @param membershipStartDate
     * @param referralSource
     */
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource) {


        super(id, name, location, phone, email, gender, DOB, membershipStartDate);


        this.attendanceLimit = 30;
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.referralSource = referralSource;
        this.removalReason = "";
    }

    /**
     * A mthod to mark attendance for the member .It increases the attendance
     * count and checks if the member for a upgrade
     *
     */
    @Override
    public void markAttendance() {
        if (activeStatus = true) {
            //increasing attendance by one
            attendance++;
            //increasing loyality point by 5
            loyaltyPoints += 5;
        }

        //cheaking if member is eligible for update
        if (attendance >= attendanceLimit) {
            isEligibleForUpgrade = true;
        }
    }

    /**
     * A method to get the plan price
     *
     * @param plan take rhe plan to get the price
     *
     *
     */
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            //for invalid plan
            default:
                return -1;
        }
    }

    /**
     * A method to upgrade thr plan of the member
     *
     * @param newPlan takes the new plan to be upgraded
     *
     * @return String message indicatin the result of the upgrade
     */
    //upgrade plan method
    public String upgradePlan(String newPlan) {

        //cheaking if the member is eligibel for update
        if (!isEligibleForUpgrade) {
            return "You are not eligible for an upgrade.";
        }

        //cheaking if same plan is choosen
        if (this.plan.equalsIgnoreCase(newPlan)) {
            return "Member s already subscribe to " + this.plan + "plan.";
        }

        //getting the price plan
        double newPrice = getPlanPrice(newPlan);

        //update plan and price
        this.plan = newPlan.toLowerCase();
        this.price = newPrice;
        this.isEligibleForUpgrade = false;

        return "Plan upgraded successfully to " + newPlan;
    }

    /**
     * A method to reset the member to a regular member
     *
     * @param removalReason takes the reason for the removal
     *
     */
    public void revertRegularMember(String removalReason) {
        //calling resetMember from super class
        super.resetMember();

        //reset regularmember attributes
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    /**
     * A method to display the member details
     *
     */
    @Override
    public void display() {
        //calling display method from super class
        super.display();

        //displaying the
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);

        //display the removal reson
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }

    // Accessor methods (getters)
    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public boolean isEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }
    // Setter methods
    public void setRemovalReason(String removalReason) {
        this.removalReason = removalReason;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    public void setLoyaltyPoints(double  loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

}
