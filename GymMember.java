/**
 * Root class for the Gym Management System
 * this class contains the common attributes and method for all gym member
 * 
 * @author Arjun Rai
 */

// abstact class
abstract class GymMember {
    // protected attributes
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;

    /**
     * Constructor for GymMember class
     * 
     * @param id       includes the id of the gym member
     * @param name     includes the name of the gym member
     * @param location includes the location of the gym meber
     * @param phone    includes the phone of the gym member
     * @param email    includes the email of the gym member
     * @param gender   includes the gender of the gym member
     * @param DOB      includes the dob of the gym member
     * 
     */
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB,
            String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0;
        this.activeStatus = false;
    }

    /**
     * Marks the attendance of an individual.
     * <p>
     * This method must be implemented by any subclass to define
     * the specific logic for recording attendance.
     * </p>
     */
    public abstract void markAttendance();

    /**
     * Activates the membership by setting the active status to true.
     * <p>
     * This method updates the membership status, indicating that
     * the member is now active.
     * </p>
     */
    public void activateMembership() {
        this.activeStatus = true;
    }

    // method to deactivate membership
    public void deactivateMembership() {
        if (this.activeStatus) {
            this.activeStatus = false;
        }
    }

    /**
     * 
     * A method to reset the member's attendance and loyalty points.
     */
    public void resetMember() {
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0;
    }

    /**
     * 
     * A method to display the member's information.
     * 
     */
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }

    // accessor method
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDOB() {
        return DOB;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public int getAttendance() {
        return attendance;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }
}
