package healthcare_hms;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    public Reception(){

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0,0,1400,170);
        panel1.setBackground(new Color(109, 164, 170));
        add(panel1);

        JPanel panel2=new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(5,160,1525,670);
        panel2.setBackground(new Color(255, 255, 255));
        add(panel2);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(246,215,118));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(30,58,200,30);
        btn2.setBackground(new Color(246,215,118));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new ViewPatient();
            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setBounds(30,100,200,30);
        btn3.setBackground(new Color(246,215,118));
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new ViewDoctors();
            }
        });

        JButton btn10= new JButton("Logout");
        btn10.setBounds(750,15,200,30);
        btn10.setBackground(new Color(246,215,118));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new login();
            }
        });

        setSize(1300,700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setLocation(35, 7);
    }
    public static void main(String[] args) {
        new Reception();
    }
    
}
