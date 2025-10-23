package healthcare_hms;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NEW_PATIENT extends JDialog implements ActionListener {
    JComboBox<String> comboBox;
    JTextField textFieldContact,textFieldIDNumber , textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2, r3;
    Choice c1;
    JLabel date;
    JButton b1 ,b2, closeButton;

    NEW_PATIENT(JFrame owner){

        super(owner, "New Patient Form", false);

        JPanel panel = new JPanel();
        panel.setBounds(20,10,1320,500);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JButton closeButton= new JButton("cancel");
        closeButton.setBounds(750,15,100,30);
        closeButton.setBackground(new Color(246,215,118));
        panel.add(closeButton);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // setVisible(false);
                dispose();
            }
        });

        // verification ID
        JLabel labelID = new JLabel("Verification ID :");
        labelID.setBounds(50,78,200,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,14));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        comboBox = new JComboBox<String>(new String[]{"Select ID","Passport","Voter ID Card","Aadhar Card","Driving License"});
        comboBox.setBounds(222,73,250,25);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);

        // Full Name
        JLabel labelName1 = new JLabel("Full Name :");
        labelName1.setBounds(50,113,200,14);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,14));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        String namePlaceholder = "Enter Full Name"; 
        textName = new JTextField();
        textName.setBounds(222,111,250,25);
        textName.setText(namePlaceholder);
        textName.setForeground(Color.GRAY);
        panel.add(textName);

        textName.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textName.getText().equals(namePlaceholder)) {
                    textName.setText("");
                    textName.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textName.getText().isEmpty()) {
                    textName.setForeground(Color.GRAY);
                    textName.setText(namePlaceholder);
                }
            }
        });

        // Date of Birth
        JLabel labelDOB = new JLabel("Date of Birth:");
        labelDOB.setBounds(50, 151, 200, 14); // Adjusted Y position
        labelDOB.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDOB.setForeground(Color.white);
        panel.add(labelDOB);

        // Create a date model for the spinner
        SpinnerDateModel dateModel = new SpinnerDateModel(
            new Date(),
            null,
            new Date(), 
            java.util.Calendar.DAY_OF_MONTH 
        );
        
        JSpinner spinnerDOB = new JSpinner(dateModel);
        
        // Set a format for the date display
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerDOB, "yyyy-MM-dd");
        spinnerDOB.setEditor(editor);
        
        spinnerDOB.setBounds(222, 151, 150, 25);
        panel.add(spinnerDOB);

        // Gender
        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(50,191,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(90, 156, 163));
        r1.setBounds(222,191,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(90, 156, 163));
        r2.setBounds(300,191,80,15);
        panel.add(r2);

        r3 = new JRadioButton("Others");
        r3.setFont(new Font("Tahoma",Font.BOLD,14));
        r3.setForeground(Color.white);
        r3.setBackground(new Color(90, 156, 163));
        r3.setBounds(390,191,80,15);
        panel.add(r3);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);
        genderGroup.add(r3);

        // id number
        JLabel labelIDNumber = new JLabel("Number :");
        labelIDNumber.setBounds(50,229,200,14);
        labelIDNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelIDNumber.setForeground(Color.white);
        panel.add(labelIDNumber);

        textFieldIDNumber = new JTextField();
        textFieldIDNumber.setBounds(222,229,150,25);
        panel.add(textFieldIDNumber);

        // Contact Number
        JLabel labelContact = new JLabel("Contact Number :");
        labelContact.setBounds(50,274,200,14);
        labelContact.setFont(new Font("Tahoma",Font.BOLD,14));
        labelContact.setForeground(Color.white);
        panel.add(labelContact);

        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false); 
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Long.class); // Use Long to hold the number
        formatter.setAllowsInvalid(false); // Don't allow invalid characters
        formatter.setCommitsOnValidEdit(true);

        JFormattedTextField formattedFieldContact = new JFormattedTextField(formatter);
        formattedFieldContact.setBounds(222, 270, 150, 25);
        formattedFieldContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(formattedFieldContact);

        // time and date
        JLabel labelDate = new JLabel("Date & Time :");
        labelDate.setBounds(50,322,200,14);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        JLabel timeLabel = new JLabel();
        timeLabel.setBounds(222, 315, 250, 30); 
        timeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        timeLabel.setForeground(Color.white); // Match your other labels
        panel.add(timeLabel);

        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy  HH:mm:ss");

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now();
                String dateTimeString = now.format(dateformatter);
                timeLabel.setText(dateTimeString);
            }
        });

        timer.start();

        setUndecorated(true);
        setSize(1375,560);
        setLayout(null);
        setLocation(0,193);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // TODO: handle button and other action events here
    }
}
