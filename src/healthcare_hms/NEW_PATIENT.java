package healthcare_hms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.*;

public class NEW_PATIENT extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1 ,b2, closeButton;

    NEW_PATIENT(){

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
