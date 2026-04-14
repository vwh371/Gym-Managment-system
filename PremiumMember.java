
/**
 * the child class for GymMember
 * contains  added method and attribues from GymMember for premium
 *
 * @ author Arjun Rai
 */
public class PremiumMember extends GymMember {

    // Private attributes
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    // Constructor
    public PremiumMember(int id, String name, String location, String phone,
            String email, String gender, String DOB,
            String membershipStartDate, String personalTrainer) {
        // Call to superclass constructor with 8 parameters
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);

        // Initialize PremiumMember specific attributes
        this.premiumCharge = 50000;
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }
    /**
     * A method to mark attendance for the member.
     * 
     * This method increases the attendance count and loyalty points for the
     * member.
     * 
     * @Override
     */
    @Override
    public void markAttendance() {
        //increasing attendance by one
        attendance++;
        //increasing loyality point by 10
        loyaltyPoints += 10;

    }

    /**
     * A method to pay the due amount for the premium membership.
     * <p>
     * This method allows the member to pay a specified amount towards their
     * premium membership. It checks if the payment is already complete, and if
     * so, it returns a message indicating that no further payments are
     * required. If the payment exceeds the premium charge, it caps the
     * paid amount at the premium charge and marks the payment as complete.
     * If the payment is successful, it returns a message indicating the
     * remaining amount.
     * </p>
     * @param amount
     * @return
     */
    public String payDueAmount(double amount) {
        // Check if payment is already complete
        if (this.isFullPayment) {
            return "Payment already completed. No further payments required.";
        }

        // Add the payment to paidAmount
        this.paidAmount += amount;

        // Check if overpayment
        if (this.paidAmount > premiumCharge) {
            this.paidAmount = premiumCharge; // Cap at premiumCharge
            this.isFullPayment = true;
            return "Payment exceeds premium charge. Only Rs." + premiumCharge + " was accepted. Payment is now complete.";
        }

        // Check if payment is now complete
        if (this.paidAmount == premiumCharge) {
            this.isFullPayment = true;
            return "Payment completed successfully. Thank you!";
        }

        // Calculate and return remaining amount
        double remainingAmount = premiumCharge - this.paidAmount;
        return "Payment of Rs." + amount + " received. Remaining amount: Rs." + remainingAmount;
    }

    /**
     * A method to calculate the discount for full payment.
     * <p>
     * This method checks if the member has made a full payment and applies a
     * discount of 10% on the premium charge.
     * </p>
     * 
     * @return A string indicating the discount amount or that no discount is
     *         available.
     */
    public String calculateDiscount() {
        if (this.isFullPayment) {
            this.discountAmount = premiumCharge * 0.10; // 10% discount
            return "Discount of 10% applied. Discount amount: Rs." + this.discountAmount;
        } else {
            this.discountAmount = 0;
            return "No discount available. Complete full payment to get 10% discount.";
        }
    }

    /**
     * A method to reset the member's attributes to default values.
     * <p>
     * This method resets the member's attributes to their default values,
     * including personal trainer, payment status, and amounts.
     * </p>
     */
    public void revertPremiumMember() {
        // Call superclass reset method
        super.resetMember();
        // Reset PremiumMember specific attributes
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    /**
     * 
     * A method to display the member's information.
     *  * <p>
     *  This method displays the member's details, including personal trainer,
     *  * payment status, and remaining amount.
     * </p>
     * 
     */
    @Override
    public void display() {
        // Call superclass display method
        super.display();
        // Display PremiumMember specific attributes
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: Rs." + paidAmount);
        System.out.println("Full Payment Status: " + (isFullPayment ? "Completed" : "Pending"));

        // Calculate and display remaining amount
        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining Amount: Rs." + remainingAmount);

        // Display discount amount if full payment is made
        if (isFullPayment) {
            System.out.println("Discount Amount: Rs." + discountAmount);
        }
    }

    // Accessor methods (getters)
    public double getPremiumCharge() {
        return premiumCharge;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean isFullPayment() {
        return isFullPayment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    // Setter methods
    public void setFullPayment(boolean isFullPayment) {
        this.isFullPayment = isFullPayment;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public void setLoyaltyPoints(double  loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    public void setPersonalTrainer(String personalTrainer) {
        this.personalTrainer = personalTrainer;
    }
    
}
