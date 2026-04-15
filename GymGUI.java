import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * This class is a GUI for a Gym Management System. It allows the user to add
 * members, activate/deactivate memberships, mark attendance, and perform other
 * operations related to gym members.
 * 
 * @author Arjun Rai
 * 
 */
public class GymGUI {

    public static void main(String[] args) {

        // Arrylist
        ArrayList<GymMember> members = new ArrayList<>();

        // GUI
        // creating frame
        JFrame frame = new JFrame("Gym Management System");
        // setting the size of the frame
        frame.setSize(1800, 1200);
        // setting the layout of the frame
        frame.setLayout(null);
        // exit on clicking
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // to extend the frame to maximum size
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // to set logo in the frame
        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());
        frame.setIconImage(image.getImage());

        // adding image in frame
        ImageIcon imageIcon = new ImageIcon("logo.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(670, 0, 200, 200);
        frame.add(imageLabel);

        // making panel for input
        JPanel panel1 = new JPanel();
        panel1.setBounds(150, 270, 1200, 280);
        panel1.setLayout(null);
        frame.add(panel1);

        // label for id
        JLabel idLabel = new JLabel("ID");
        // setting the location for label and adding to thr panel
        idLabel.setBounds(0, 0, 100, 30);
        panel1.add(idLabel);
        // text field for id
        JTextField idField = new JTextField(15);
        // setting the location for the id text field and adding to the frame
        idField.setBounds(150, 0, 300, 30);
        panel1.add(idField);

        // label for name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(700, 0, 100, 30);
        panel1.add(nameLabel);
        // textfield
        JTextField namField = new JTextField(15);
        // setting the locationfor the text field and adding to the frame
        namField.setBounds(850, 0, 300, 30);
        panel1.add(namField);

        // label for locatiom
        JLabel locationLabel = new JLabel("Location:");
        // setting the location for the id label and adding to the frame
        locationLabel.setBounds(0, 40, 100, 30);
        panel1.add(locationLabel);
        // text field for location
        JTextField locationField = new JTextField();
        // setting the location for the id text field
        locationField.setBounds(150, 40, 300, 30);
        // adding the text field to the frame
        panel1.add(locationField);

        // label for phone number
        JLabel phoneLabel = new JLabel("Phone Number:");
        // setting uo the location
        phoneLabel.setBounds(700, 40, 200, 30);
        // adding the label to the frame
        panel1.add(phoneLabel);
        // textfield
        JTextField phoneField = new JTextField(15);
        // setting the locationfor the text field
        phoneField.setBounds(850, 40, 300, 30);
        // adding the text field to the frame
        panel1.add(phoneField);

        // label for email
        JLabel emailLabel = new JLabel("Email:");
        // setting the location for email label and adding to the frame
        emailLabel.setBounds(0, 80, 200, 30);
        panel1.add(emailLabel);
        // text field for email
        JTextField emailField = new JTextField(15);
        // setting the email for the id text field and adding to the frame
        emailField.setBounds(150, 80, 300, 30);
        panel1.add(emailField);

        // radio button for the gender
        // label for the gender
        JLabel genderJLabel = new JLabel("Gender:");
        // setting up the location for label and adding to the frame
        genderJLabel.setBounds(700, 80, 200, 30);
        panel1.add(genderJLabel);
        // creating radio buttons
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");

        // grouping the radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        // adding radio buttons to the frame
        maleButton.setBounds(850, 80, 70, 30);
        panel1.add(maleButton);
        femaleButton.setBounds(920, 80, 70, 30);
        panel1.add(femaleButton);

        // label for date of birth
        JLabel dobLabel = new JLabel("DOB:");
        // setting up the location and adding to the frame
        dobLabel.setBounds(0, 120, 100, 30);
        panel1.add(dobLabel);

        // combo box for the day
        JComboBox<Integer> dayBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayBox.addItem(i);
        }
        // setting the location for the day combo box and adding to the frame
        dayBox.setBounds(150, 120, 50, 30);
        panel1.add(dayBox);

        // combo box for the month
        JComboBox<String> monthBox = new JComboBox<>();
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        for (String month : months) {
            monthBox.addItem(month);
        }
        // setting the location and addin gto the frame
        monthBox.setBounds(220, 120, 80, 30);
        panel1.add(monthBox);

        // combo box for the year
        JComboBox<Integer> yearBox = new JComboBox<>();
        for (int i = 1950; i <= 2023; i++) {
            yearBox.addItem(i);
        }
        // setting the location and adding to the frame
        yearBox.setBounds(320, 120, 60, 30);
        panel1.add(yearBox);

        // label for membershipDate
        JLabel memberLabel = new JLabel("MSD:");
        // setting up the location and adding to the frame
        memberLabel.setBounds(700, 120, 100, 30);
        panel1.add(memberLabel);

        // combo box for the day
        JComboBox<Integer> dayBox2 = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayBox2.addItem(i);
        }
        // setting the location for the day combo box and adding to the frame
        dayBox2.setBounds(850, 120, 50, 30);
        panel1.add(dayBox2);

        // combo box for the month
        JComboBox<String> monthBox2 = new JComboBox<>();
        String[] months2 = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        for (String month : months2) {
            monthBox2.addItem(month);
        }
        // setting the location and addin gto the frame
        monthBox2.setBounds(920, 120, 80, 30);
        panel1.add(monthBox2);

        // combo box for the year
        JComboBox<Integer> yearBox2 = new JComboBox<>();
        for (int i = 2019; i <= 2025; i++) {
            yearBox2.addItem(i);
        }
        // setting the location and adding to the frame
        yearBox2.setBounds(1020, 120, 60, 30);
        panel1.add(yearBox2);

        // label for plan
        JLabel planLabel = new JLabel("Plan:");
        planLabel.setBounds(0, 160, 100, 30);
        panel1.add(planLabel);
        // combo box for the plan
        JComboBox<String> planBox = new JComboBox<>();
        String[] plans = { "Basic", "Standard", "Deluxe" };
        for (String plan : plans) {
            planBox.addItem(plan);
        }
        // setting the location and adding to the panel
        planBox.setBounds(150, 160, 100, 30);
        panel1.add(planBox);

        // label for price
        JLabel priceLabel = new JLabel("Price");
        // setting the location for the label and adding the label to the frame
        priceLabel.setBounds(270, 160, 100, 30);
        panel1.add(priceLabel);
        // textfield
        JTextField priceField = new JTextField();
        priceField.setBounds(350, 160, 100, 30);
        priceField.setText("6500.0"); // Default price for Basic plan
        priceField.setEditable(false);
        panel1.add(priceField);

        /**
         * funcation of combo box while plan combo box is selected the price of
         * the selected price are displayed in textfield
         */
        planBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPlan = (String) planBox.getSelectedItem();
                double price = 0;

                switch (selectedPlan.toLowerCase()) {
                    case "basic":
                        price = 6500;
                        break;
                    case "standard":
                        price = 12500;
                        break;
                    case "deluxe":
                        price = 18500;
                        break;
                }

                priceField.setText(String.valueOf(price));
            }
        });

        // label for paid amount
        JLabel paidLabel = new JLabel("Paid Amount");
        // setting up the location and adding to the frame
        paidLabel.setBounds(700, 160, 100, 30);
        panel1.add(paidLabel);
        // textfield for the paid amount
        JTextField paidField = new JTextField(15);
        // setting the locationfor the text field and adding the text field to the frame
        paidField.setBounds(850, 160, 100, 30);
        panel1.add(paidField);

        // for discount
        JLabel discountLabel = new JLabel("Discount");
        discountLabel.setBounds(970, 160, 100, 30);
        panel1.add(discountLabel);
        // textfield for the discount
        JTextField discountField = new JTextField();
        discountField.setBounds(1050, 160, 100, 30);
        // setting text editable to false
        discountField.setEditable(false);
        panel1.add(discountField);

        // premium plan price
        JLabel premiumLabel = new JLabel("Premium Plan Price");
        premiumLabel.setBounds(0, 200, 150, 30);
        panel1.add(premiumLabel);
        // textField
        JTextField premiumField = new JTextField("50000.0");
        // setting text editable to false
        premiumField.setEditable(false);
        // setting the location and adding to the panel
        premiumField.setBounds(150, 200, 300, 30);
        panel1.add(premiumField);

        // Label for referral source
        JLabel referLabel = new JLabel("Referral Souce");
        // setting the location and adding to the frame
        referLabel.setBounds(700, 200, 100, 30);
        panel1.add(referLabel);
        // textfield
        JTextField referrField = new JTextField(15);
        // setting the locationfor the text field and adding the text field to the frame
        referrField.setBounds(850, 200, 300, 30);
        panel1.add(referrField);

        // label for trainer's name
        JLabel trainerLabel = new JLabel("Trainer's name:");
        // setting up the location and adding the label to the frame
        trainerLabel.setBounds(0, 240, 100, 30);
        panel1.add(trainerLabel);
        // textfield the tainer's name
        JTextField trainerField = new JTextField();
        // setting the locationfor the text field and adding the text field to the frame
        trainerField.setBounds(150, 240, 300, 30);
        panel1.add(trainerField);

        // label for removal reason
        JLabel removalLabel = new JLabel("Removal Reason");
        // setting the location for the lebal and adding to the panel
        removalLabel.setBounds(700, 240, 100, 30);
        panel1.add(removalLabel);
        // text field for the removal reason
        JTextField removaField = new JTextField();
        removaField.setBounds(850, 240, 300, 30);
        panel1.add(removaField);

        // Panel for buttons
        JPanel panel3 = new JPanel();
        panel3.setBounds(150, 550, 1500, 300);
        panel3.setLayout(null); // Set to null for absolute positioning
        frame.add(panel3);

        // adding button
        // regular member button
        JButton regularButton = new JButton("Add Regular Member");
        regularButton.setBounds(0, 10, 200, 30);
        panel3.add(regularButton);

        // premium member button
        JButton premiumButton = new JButton("Add Premium Member");
        premiumButton.setBounds(260, 10, 200, 30);
        panel3.add(premiumButton);

        // activate membership button
        JButton activeButton = new JButton("Activate Membership");
        activeButton.setBounds(520, 10, 200, 30);
        panel3.add(activeButton);

        // deactivate membership button
        JButton deactiveButton = new JButton("Deactive Membership");
        deactiveButton.setBounds(780, 10, 200, 30);
        panel3.add(deactiveButton);

        // mark attendance
        JButton attendanceButton = new JButton("Mark Attendance");
        attendanceButton.setBounds(1040, 10, 200, 30);
        panel3.add(attendanceButton);

        // upgrade plan button
        JButton upgradeButton = new JButton("Upgrade Plan:");
        upgradeButton.setBounds(0, 60, 200, 30);
        panel3.add(upgradeButton);

        // revert Regular member button
        JButton revertrButton = new JButton("Revert R Member");
        revertrButton.setBounds(260, 60, 200, 30);
        panel3.add(revertrButton);

        // display button
        JButton displayButton = new JButton("Display Members");
        displayButton.setBounds(520, 60, 200, 30);
        panel3.add(displayButton);

        // clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(780, 60, 200, 30);
        panel3.add(clearButton);

        // discount button
        JButton discountButton = new JButton("Calculate discount");
        discountButton.setBounds(1040, 60, 200, 30);
        panel3.add(discountButton);

        // pay deu amount button
        JButton dueButton = new JButton("Pay Due Amount");
        dueButton.setBounds(0, 110, 200, 30);
        panel3.add(dueButton);

        // save to file button
        JButton saveButton = new JButton("Save to file");
        saveButton.setBounds(260, 110, 200, 30);
        panel3.add(saveButton);

        // button read from files
        JButton readButton = new JButton("Read from file");
        readButton.setBounds(520, 110, 200, 30);
        panel3.add(readButton);

        // revert primum member
        JButton revertpButton = new JButton("Revert P Member");
        revertpButton.setBounds(780, 110, 200, 30);
        panel3.add(revertpButton);

        /**
         * functionality of regular member the necessary input for regular
         * member are taken and inserted in arraylist for regular member
         */
        regularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter  valid Id!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                }
                String name = namField.getText();
                String location = locationField.getText();
                String phone = phoneField.getText();
                /**
                 * cheaking the valid phone number the number should consist of
                 * 10 digits
                 */
                if (!phone.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid phone number", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String email = emailField.getText();
                /**
                 * cheaking the valid email
                 */
                if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,6}$")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email address", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;

                }
                String gender = "";
                if (maleButton.isSelected()) {
                    gender = "Male";
                } else if (femaleButton.isSelected()) {
                    gender = "Female";
                }

                int day = (int) dayBox.getSelectedItem();
                String month = (String) monthBox.getSelectedItem();
                int year = (int) yearBox.getSelectedItem();
                String DOB = day + "-" + month + "-" + year;

                /**
                 * taking input from membership start date
                 */
                int msdDay = (int) dayBox2.getSelectedItem();
                String msdMonth = (String) monthBox2.getSelectedItem();
                int msdYear = (int) yearBox2.getSelectedItem();
                String MembershipStartDAte = msdDay + "-" + msdMonth + "-" + msdYear;

                String referral = referrField.getText();

                // paid amount
                double paidAmount;
                try {
                    paidAmount = Double.parseDouble(paidField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid paid amount", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                /**
                 * Checking if the field is empty and send message if so
                 */
                if (String.valueOf(id).isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty()
                        || email.isEmpty() || gender.isEmpty() || DOB.isEmpty() || MembershipStartDAte.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Kindly fill up the requred Fields", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                /**
                 * Cheaking if id is repeated and show message if so
                 */
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        JOptionPane.showMessageDialog(frame, "ID already exists.Please enter a different ID", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                /**
                 * adding the member in arraylist
                 */
                RegularMember newMember = new RegularMember(id, name, location, phone, email, gender, DOB,
                        MembershipStartDAte, referral);
                members.add(newMember);

                JOptionPane.showMessageDialog(frame, "Regular Member added successfully", "Sucess",
                        JOptionPane.INFORMATION_MESSAGE);

            }
        });

        /**
         * Adding funcationality premium member button
         */
        premiumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(idField.getText());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid Id");
                    return;
                }
                String name = namField.getText();
                String location = locationField.getText();
                String phone = phoneField.getText();
                if (!phone.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid phone number", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String email = emailField.getText();
                if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9]+\\.[A-Za-z0-9]{2,6}$")) {
                    JOptionPane.showMessageDialog(frame, "Enter valid email", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String gender = "";
                if (maleButton.isSelected()) {
                    gender = "Male";
                } else if (femaleButton.isSelected()) {
                    gender = "Female";
                }
                /**
                 * Getting DOB from the numput
                 */
                int day = (int) dayBox.getSelectedItem();
                String month = (String) monthBox.getSelectedItem();
                int year = (int) yearBox.getSelectedItem();
                String DOB = day + "-" + month + "-" + year;

                /**
                 * taking input from membership start date
                 */
                int msdDay = (int) dayBox2.getSelectedItem();
                String msdMonth = (String) monthBox2.getSelectedItem();
                int msdYear = (int) yearBox2.getSelectedItem();
                String MembershipStartDAte = msdDay + "-" + msdMonth + "-" + msdYear;

                /**
                 * trainner's name
                 */
                String trainer = trainerField.getText();

                /**
                 * paid amount
                 */
                double paidAmount;
                try {
                    paidAmount = Double.parseDouble(paidField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid paid amount", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                /**
                 * cheacking if field is empty and if so send message
                 */
                if (String.valueOf(id).isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty()
                        || email.isEmpty() || gender.isEmpty() || DOB.isEmpty() || MembershipStartDAte.isEmpty()
                        || trainer.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Kindly fill up the required field", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;

                }

                /**
                 * cheaking if the id already exist
                 */
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        JOptionPane.showMessageDialog(frame, "The ID already exist.Try another ID", "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                /**
                 * Adding to the arraylist
                 */
                PremiumMember newMember = new PremiumMember(id, name, location, phone, email, gender, DOB,
                        MembershipStartDAte, trainer);
                members.add(newMember);

                JOptionPane.showMessageDialog(frame, "PremiumMember added successfully", "Sucess",
                        JOptionPane.INFORMATION_MESSAGE);

                // clearing after adding member
                idField.setText("");
                namField.setText("");
                locationField.setText("");
                phoneField.setText("");
                emailField.setText("");
                trainerField.setText("");

            }
        });

        /**
         * Functionality for activate button
         */
        activeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(idField.getText());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter the valid ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                /**
                 * checking if id field is empty
                 */
                if (String.valueOf(id).isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Enter id in Id field", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                /**
                 * checking if id exist
                 */
                boolean idFound = false;
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        idFound = true;

                        // checking if maember is active
                        if (member.isActiveStatus()) {
                            JOptionPane.showMessageDialog(frame, "Member with ID" + id + "is already active",
                                    "Information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            member.activateMembership();
                            JOptionPane.showMessageDialog(frame, "Membership Activated", "Sucess",
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        break;

                    }
                }
                if (!idFound) {
                    JOptionPane.showMessageDialog(frame, "ID is nowhere to be found.Enter the correct ID", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /**
         * functionality of deactivate membership
         */
        deactiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(idField.getText());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter the valid ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;

                }
                /**
                 * cheacking if the filed if filled up
                 */
                if (String.valueOf(id).isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "KIndly fillup the id field", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                /**
                 * cheacking if id exsist
                 */
                boolean idFound = false;
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        if (!member.isActiveStatus()) {
                            JOptionPane.showMessageDialog(frame, "Member with id" + id + "is already deactivated",
                                    "Information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            member.deactivateMembership();
                            JOptionPane.showMessageDialog(frame, "Deactivate sucessfully", "INFORMATION",
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        break;
                    }
                }
                if (!idFound) {
                    JOptionPane.showMessageDialog(frame, "ID is nowhere to be found.Enter the correct ID", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        attendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID number", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Checking if the field is empty
                if (idField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in the ID field", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean idFound = false;
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        idFound = true;

                        // Checking if member is active
                        if (!member.isActiveStatus()) {
                            JOptionPane.showMessageDialog(frame, "Member with ID " + id + " is not active", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Mark attendance based on member type
                        if (member instanceof RegularMember) {
                            RegularMember regularMember = (RegularMember) member;
                            regularMember.markAttendance();
                            JOptionPane.showMessageDialog(frame,
                                    "Attendance marked for Regular Member of member with Id" + id,
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else if (member instanceof PremiumMember) {
                            PremiumMember premiumMember = (PremiumMember) member;
                            premiumMember.markAttendance();
                            JOptionPane.showMessageDialog(frame,
                                    "Attendance marked for Premium Member of member with Id" + id,
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                        }

                        return;
                    }
                }

                if (!idFound) {
                    JOptionPane.showMessageDialog(frame, "Member ID not found", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // function of upgrade plan
        upgradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (String.valueOf(id).isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter ID in the ID field", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean memberFound = false;

                for (GymMember member : members) {
                    if (member.getId() == id) {
                        memberFound = true;

                        if (member instanceof RegularMember) {
                            RegularMember regularMember = (RegularMember) member;

                            if (!regularMember.isActiveStatus()) {
                                JOptionPane.showMessageDialog(frame,
                                        "Member with ID " + id + " is not active",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            String newPlan = (String) planBox.getSelectedItem();
                            String currentPlan = regularMember.getPlan();

                            // Check if selected plan is same as current plan
                            if (newPlan.equalsIgnoreCase(currentPlan)) {
                                JOptionPane.showMessageDialog(frame,
                                        "Member is already on the " + currentPlan + " plan\n"
                                                + "Please select a different plan to upgrade",
                                        "Information", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }

                            String result = regularMember.upgradePlan(newPlan);
                            JOptionPane.showMessageDialog(frame, result, "Upgrade Status",
                                    JOptionPane.INFORMATION_MESSAGE);

                            // Update UI to reflect changes
                            priceField.setText(String.valueOf(regularMember.getPrice()));
                            planBox.setSelectedItem(regularMember.getPlan());

                        } else {
                            JOptionPane.showMessageDialog(frame,
                                    "Only Regular Members can upgrade plans.\n", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }

                if (!memberFound) {
                    JOptionPane.showMessageDialog(frame,
                            "Member with ID " + id + "is no where to be found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // functionality for revert regular member button
        revertrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (String.valueOf(id).isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter ID in the ID field", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String removalReason = removaField.getText();
                if (removalReason.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a removal reason", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean memberFound = false;

                for (GymMember member : members) {
                    if (member.getId() == id) {
                        memberFound = true;

                        if (member instanceof RegularMember) {
                            RegularMember regularMember = (RegularMember) member;

                            // Revert the regular member
                            regularMember.revertRegularMember(removalReason);

                            JOptionPane.showMessageDialog(frame,
                                    "Regular member with ID " + id + " has been reverted successfully", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);

                            // Clear fields after successful revert
                            idField.setText("");
                            namField.setText("");
                            locationField.setText("");
                            phoneField.setText("");
                            emailField.setText("");
                            removaField.setText("");

                        } else {
                            JOptionPane.showMessageDialog(frame,
                                    "The member does not belong to regular member", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }

                if (!memberFound) {
                    JOptionPane.showMessageDialog(frame, "Member with ID " + id + "is no where to be found", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create new JFrame for display
                JFrame displayFrame = new JFrame("Gym Member Details");
                displayFrame.setSize(700, 600);
                displayFrame.setLocationRelativeTo(null); // Center on screen

                // Create a JTextArea inside a JScrollPane
                JTextArea displayArea = new JTextArea();
                displayArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(displayArea);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                displayFrame.add(scrollPane);
                displayFrame.setVisible(true);

                // Check if there are any members to display
                if (members.isEmpty()) {
                    displayArea.append("No members to display.\n");
                    return;
                }

                // Display header
                displayArea.append(
                        "=================================================================================================================\n");
                displayArea.append(
                        "                                                            GYM MEMBER DETAILS                                   \n");
                displayArea.append(
                        "=================================================================================================================\n");
                displayArea.append("\n");

                // Display each member's information
                for (GymMember member : members) {
                    displayArea.append("ID: " + member.getId() + "\n");
                    displayArea.append("Name: " + member.getName() + "\n");
                    displayArea.append("Location: " + member.getLocation() + "\n");
                    displayArea.append("Phone: " + member.getPhone() + "\n");
                    displayArea.append("Email: " + member.getEmail() + "\n");
                    displayArea.append("Gender: " + member.getGender() + "\n");
                    displayArea.append("DOB: " + member.getDOB() + "\n");
                    displayArea.append("Membership Start Date: " + member.getMembershipStartDate() + "\n");
                    displayArea.append("Status: " + (member.isActiveStatus() ? "Active" : "Inactive") + "\n");
                    displayArea.append("Attendance: " + member.getAttendance() + "\n");
                    displayArea.append("Loyalty Points: " + member.getLoyaltyPoints() + "\n");

                    // Member Type Specific Info
                    if (member instanceof RegularMember) {
                        RegularMember regMember = (RegularMember) member;
                        displayArea.append("Member Type: Regular\n");
                        displayArea.append("Plan: " + regMember.getPlan() + "\n");
                        displayArea.append("Price: " + regMember.getPrice() + "\n");
                        displayArea.append("Referral Source: " + regMember.getReferralSource() + "\n");
                        if (!regMember.getRemovalReason().isEmpty()) {
                            displayArea.append("Removal Reason: " + regMember.getRemovalReason() + "\n");
                        }
                    } else if (member instanceof PremiumMember) {
                        PremiumMember premMember = (PremiumMember) member;
                        displayArea.append("Member Type: Premium\n");
                        displayArea.append("Personal Trainer: " + premMember.getPersonalTrainer() + "\n");
                        displayArea.append("Premium Charge: " + premMember.getPremiumCharge() + "\n");
                        displayArea.append("Paid Amount: " + premMember.getPaidAmount() + "\n");
                        displayArea.append(
                                "Payment Status: " + (premMember.isFullPayment() ? "Completed" : "Pending") + "\n");
                        displayArea.append("Discount Amount: " + premMember.getDiscountAmount() + "\n");
                    }

                    displayArea.append(
                            "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                }
            }
        });


        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
                idField.setText("");
                namField.setText("");
                locationField.setText("");
                phoneField.setText("");
                emailField.setText("");
                referrField.setText("");
                trainerField.setText("");
                removaField.setText("");
                paidField.setText("");
                discountField.setText("");
                dayBox.setSelectedIndex(0);
                monthBox.setSelectedIndex(0);
                yearBox.setSelectedIndex(0);
                dayBox2.setSelectedIndex(0);
                monthBox2.setSelectedIndex(0);
                yearBox2.setSelectedIndex(0);
                planBox.setSelectedIndex(0);
                priceField.setText("6500.0");

                // Show confirmation message
                JOptionPane.showMessageDialog(frame, "All input fields have been cleared successfully.",
                        "Clear Completed", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // functionality for button
        discountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (String.valueOf(id).isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter ID in the ID field", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean memberFound = false;

                for (GymMember member : members) {
                    if (member.getId() == id) {
                        memberFound = true;

                        if (member instanceof PremiumMember) {
                            PremiumMember premiumMember = (PremiumMember) member;

                            if (!premiumMember.isActiveStatus()) {
                                JOptionPane.showMessageDialog(frame,
                                        "Member with ID " + id + " is not active", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            // Calculate discount
                            String discount = premiumMember.calculateDiscount();

                            // Update the discount field in UI
                            discountField.setText(String.valueOf(premiumMember.getDiscountAmount()));

                            // Show discount information
                            JOptionPane.showMessageDialog(frame, "Discount calculate sucessfully", "SUCESS",
                                    JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(frame,
                                    "Discounts are only available for Premium Members", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }

                if (!memberFound) {
                    JOptionPane.showMessageDialog(frame, "Member with ID " + id + "is no where to be found", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate ID input
                int id;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate payment amount input
                double paymentAmount;
                try {
                    paymentAmount = Double.parseDouble(paidField.getText());
                    if (paymentAmount <= 0) {
                        JOptionPane.showMessageDialog(frame, "Payment amount must be positive",
                                "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid payment amount",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Find the member
                boolean memberFound = false;
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        memberFound = true;

                        if (member instanceof PremiumMember) {
                            PremiumMember premiumMember = (PremiumMember) member;

                            // Check if member is active
                            if (!premiumMember.isActiveStatus()) {
                                JOptionPane.showMessageDialog(frame, "Member is not active.Activate membership first.",
                                        "Payment Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            // Check if payment is already complete
                            if (premiumMember.isFullPayment()) {
                                JOptionPane.showMessageDialog(frame,
                                        "Payment already completed. No further payments needed.", "Payment Info",
                                        JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }

                            // Process payment and get result message
                            String paymentResult = premiumMember.payDueAmount(paymentAmount);
                            paidField.setText(String.format("%.2f", premiumMember.getPaidAmount()));

                            if (premiumMember.getPaidAmount() > premiumMember.getPremiumCharge()) {
                                double excess = premiumMember.getPaidAmount() - premiumMember.getPremiumCharge();
                                JOptionPane.showMessageDialog(frame,
                                        "You have paid Rs." + String.format("%.2f", excess) + " excess.\n" + "Only Rs."
                                                + String.format("%.2f", premiumMember.getPremiumCharge())
                                                + " was charged.\n" + "Membership fully paid!",
                                        "Payment Processed", JOptionPane.INFORMATION_MESSAGE);

                            } else {
                                // Partial payment case
                                double remaining = premiumMember.getPremiumCharge() - premiumMember.getPaidAmount();
                                JOptionPane.showMessageDialog(frame,
                                        paymentResult + "\n" + "Remaining Amount: Rs."
                                                + String.format("%.2f", remaining),
                                        "Payment Status", JOptionPane.INFORMATION_MESSAGE);
                            }

                            // Always update premium field
                            premiumField.setText(String.format("%.2f", premiumMember.getPremiumCharge()));

                        } else {
                            JOptionPane.showMessageDialog(frame,
                                    "Only Premium Members can make payments",
                                    "Payment Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }

                if (!memberFound) {
                    JOptionPane.showMessageDialog(frame,
                            "Member with ID " + id + " not found",
                            "Not Found", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (members.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No members to save", "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                try {
                    FileWriter writer = new FileWriter("MemberDetails.txt");

                    for (GymMember member : members) {
                        if (member instanceof RegularMember) {
                            RegularMember regMember = (RegularMember) member;
                            writer.write("RegularMember,");
                            writer.write(regMember.getId() + ",");
                            writer.write(regMember.getName() + ",");
                            writer.write(regMember.getLocation() + ",");
                            writer.write(regMember.getPhone() + ",");
                            writer.write(regMember.getEmail() + ",");
                            writer.write(regMember.getGender() + ",");
                            writer.write(regMember.getDOB() + ",");
                            writer.write(regMember.getMembershipStartDate() + ",");
                            writer.write(regMember.attendance + ",");
                            writer.write(regMember.loyaltyPoints + ",");
                            writer.write(regMember.activeStatus + ",");
                            writer.write(regMember.getPlan() + ",");
                            writer.write(regMember.getPrice() + ",");
                            writer.write(regMember.getReferralSource() + ",");
                            writer.write(regMember.getRemovalReason() + "\n");
                        } else if (member instanceof PremiumMember) {
                            PremiumMember premMember = (PremiumMember) member;
                            writer.write("PremiumMember,");
                            writer.write(premMember.getId() + ",");
                            writer.write(premMember.getName() + ",");
                            writer.write(premMember.getLocation() + ",");
                            writer.write(premMember.getPhone() + ",");
                            writer.write(premMember.getEmail() + ",");
                            writer.write(premMember.getGender() + ",");
                            writer.write(premMember.getDOB() + ",");
                            writer.write(premMember.getMembershipStartDate() + ",");
                            writer.write(premMember.attendance + ",");
                            writer.write(premMember.loyaltyPoints + ",");
                            writer.write(premMember.activeStatus + ",");
                            writer.write(premMember.getPersonalTrainer() + ",");
                            writer.write(premMember.getPremiumCharge() + ",");
                            writer.write(premMember.isFullPayment() + ",");
                            writer.write(premMember.getPaidAmount() + ",");
                            writer.write(premMember.getDiscountAmount() + "\n");
                        }
                    }

                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Members saved to file successfully", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving to file: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Scanner scanner = new Scanner(new FileReader("MemberDetails.txt"))) {
                    members.clear();
                    java.util.List<String[]> tableRows = new java.util.ArrayList<>();
                    String[] regularHeaders = {"Type", "ID", "Name", "Location", "Phone", "Email", "Gender", "DOB", "Start Date", "Attendance", "Loyalty Points", "Active", "Plan", "Price", "Referral", "Removal", "Trainer", "Premium Charge", "Full Payment", "Paid Amount", "Discount"};
                    String[] premiumHeaders = {"Type", "ID", "Name", "Location", "Phone", "Email", "Gender", "DOB", "Start Date", "Attendance", "Loyalty Points", "Active", "Plan", "Price", "Referral", "Removal", "Trainer", "Premium Charge", "Full Payment", "Paid Amount", "Discount"};
                    String[] headers = regularHeaders;
                    boolean hasData = false;
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.trim().isEmpty()) continue;
                        hasData = true;
                        String[] parts = line.split(",");
                        if (parts.length < 14) continue;
                        String type = parts[0].trim();
                        int id = Integer.parseInt(parts[1].trim());
                        String name = parts[2].trim();
                        String location = parts[3].trim();
                        String phone = parts[4].trim();
                        String email = parts[5].trim();
                        String gender = parts[6].trim();
                        String dob = parts[7].trim();
                        String membershipStart = parts[8].trim();
                        if (type.equals("RegularMember")) {
                            String plan = parts[12].trim();
                            double price = Double.parseDouble(parts[13].trim());
                            String referral = parts.length > 14 ? parts[14].trim() : "";
                            String removal = parts.length > 15 ? parts[15].trim() : "";
                            RegularMember regMember = new RegularMember(id, name, location, phone, email, gender, dob, membershipStart, referral);
                            regMember.setPlan(plan);
                            regMember.setPrice(price);
                            regMember.setAttendance(Integer.parseInt(parts[9].trim()));
                            regMember.setLoyaltyPoints(Double.parseDouble(parts[10].trim()));
                            regMember.setActiveStatus(Boolean.parseBoolean(parts[11].trim()));
                            regMember.setRemovalReason(removal);
                            members.add(regMember);
                            String[] row = new String[20];
                            for (int i = 0; i < 16 && i < parts.length; i++) row[i] = parts[i];
                            row[16] = "na"; // Trainer
                            row[17] = "na"; // Premium Charge
                            row[18] = "na"; // Full Payment
                            row[19] = "na"; // Paid Amount
                            row[20-1] = "na"; // Discount
                            tableRows.add(row);
                        } else if (type.equals("PremiumMember")) {
                            String trainer = parts[12].trim();
                            double premiumCharge = Double.parseDouble(parts[13].trim());
                            boolean fullPayment = Boolean.parseBoolean(parts[14].trim());
                            double paidAmount = Double.parseDouble(parts[15].trim());
                            double discount = Double.parseDouble(parts[16].trim());
                            PremiumMember premMember = new PremiumMember(id, name, location, phone, email, gender, dob, membershipStart, trainer);
                            premMember.setAttendance(Integer.parseInt(parts[9].trim()));
                            premMember.setLoyaltyPoints(Double.parseDouble(parts[10].trim()));
                            premMember.setActiveStatus(Boolean.parseBoolean(parts[11].trim()));
                            premMember.setFullPayment(fullPayment);
                            premMember.setPaidAmount(paidAmount);
                            premMember.setDiscountAmount(discount);
                            members.add(premMember);
                            String[] row = new String[20];
                            for (int i = 0; i < 12 && i < parts.length; i++) row[i] = parts[i];
                            row[12] = "na"; // Plan
                            row[13] = "na"; // Price
                            row[14] = "na"; // Referral
                            row[15] = "na"; // Removal
                            for (int i = 12; i < parts.length && i+4 < 20; i++) row[i+4] = parts[i];
                            tableRows.add(row);
                        }
                    }
                    if (!hasData) {
                        JOptionPane.showMessageDialog(frame, "No member to read.", "Information", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    if (!tableRows.isEmpty()) {
                        Object[][] data = new Object[tableRows.size()][headers.length];
                        for (int i = 0; i < tableRows.size(); i++) {
                            String[] row = tableRows.get(i);
                            for (int j = 0; j < headers.length; j++) {
                                data[i][j] = (j < row.length && row[j] != null) ? row[j] : "na";
                            }
                        }
                        JTable table = new JTable(data, headers);
                        JScrollPane scrollPane = new JScrollPane(table);
                        JFrame tableFrame = new JFrame("Loaded Members (Tabular View)");
                        tableFrame.setSize(1400, 400);
                        tableFrame.setLocationRelativeTo(null);
                        tableFrame.add(scrollPane);
                        tableFrame.setVisible(true);
                    }
                    JOptionPane.showMessageDialog(frame, "Members loaded from file successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error parsing file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        revertpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if ID field is empty
                if (String.valueOf(id).isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter ID in the ID field", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean memberFound = false;

                for (GymMember member : members) {
                    if (member.getId() == id) {
                        memberFound = true;
                        if (member instanceof PremiumMember) {
                            PremiumMember premiumMember = (PremiumMember) member;

                            // Revert the premium member
                            premiumMember.revertPremiumMember();

                            JOptionPane.showMessageDialog(frame,
                                    "Premium member with ID " + id + " has been reverted successfully", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);

                            // Clear fields after successful revert
                            idField.setText("");
                            namField.setText("");
                            locationField.setText("");
                            phoneField.setText("");
                            emailField.setText("");
                            trainerField.setText("");

                        } else {
                            JOptionPane.showMessageDialog(frame, "The member is not of Premium Member", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }

                if (!memberFound) {
                    JOptionPane.showMessageDialog(frame,
                            "Member with ID " + id + " not found",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // to set the visibility of the frame
        frame.setVisible(true);

    }

}
