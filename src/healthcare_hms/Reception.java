package healthcare_hms;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    private NEW_PATIENT newPatientFrame;

    public Reception(){

        JOptionPane.showMessageDialog(null,"Open in full screen for better view");
        
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

        Font buttonFont = new Font("Verdana", Font.BOLD, 14);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(246,215,118));
        btn1.setFont(buttonFont);
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newPatientFrame != null && newPatientFrame.isVisible()) {
                    newPatientFrame.dispose();
                    newPatientFrame = new NEW_PATIENT();
                } else {
                    newPatientFrame = new NEW_PATIENT();
                }
            }
        });

        JButton btn2 = new JButton("All Patient Info");
        btn2.setBounds(30,58,200,30);
        btn2.setBackground(new Color(246,215,118));
        btn2.setFont(buttonFont);
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new All_Patient_Info();
            }
        });

        JButton btn3 = new JButton("Patient Discharge");
        btn3.setBounds(30,100,200,30);
        btn3.setBackground(new Color(246,215,118));
        btn3.setFont(buttonFont);
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new patient_discharge();
            }
        });

        JButton btn4 = new JButton("Update Patient Details");
        btn4.setBounds(260,15,200,30);
        btn4.setBackground(new Color(246,215,118));
        btn4.setFont(buttonFont);
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new update_patient_details();
            }
        });

        JButton btn5 = new JButton("Department");
        btn5.setBounds(260,58,200,30);
        btn5.setBackground(new Color(246,215,118));
        btn5.setFont(buttonFont);
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new Department();
            }
        });

        JButton btn6 = new JButton("All Employee Info");
        btn6.setBounds(260,100,200,30);
        btn6.setBackground(new Color(246,215,118));
        btn6.setFont(buttonFont);
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new ViewDoctors();
            }
        });

        JButton btn7 = new JButton("Room");
        btn7.setBounds(490,15,200,30);
        btn7.setBackground(new Color(246,215,118));
        btn7.setFont(buttonFont);
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new room();
            }
        });

        JButton btn8 = new JButton("Search Room");
        btn8.setBounds(490,58,200,30);
        btn8.setBackground(new Color(246,215,118));
        btn8.setFont(buttonFont);
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new Search_Room();
            }
        });

        JButton btn9 = new JButton("Ambulance");
        btn9.setBounds(490,100,200,30);
        btn9.setBackground(new Color(246,215,118));
        btn9.setFont(buttonFont);
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new ambulance();
            }
        });

        JButton btn10= new JButton("Logout");
        btn10.setBounds(750,15,200,30);
        btn10.setBackground(new Color(246,215,118));
        btn10.setFont(buttonFont);
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new login();
            }
        });

        java.net.URL logoUrl = ClassLoader.getSystemResource("assets/icons/logo.png");
        JLabel label;
        if (logoUrl != null) {
            ImageIcon i1 = new ImageIcon(logoUrl);
            Image i2 = i1.getImage().getScaledInstance(408,280,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            float opacity = 0.2f;
            label = new JLabel(new TransparentIcon(i3, opacity));
        } else {
            label = new JLabel("Logo Not Found GG");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            label.setForeground(Color.RED);
        }
        label.setBounds(450,60,408,300);
        panel2.add(label);

        setSize(1300,700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setLocation(35, 7);
    }
    class TransparentIcon implements Icon { // Note: 'public' is removed

        private Icon icon;
        private float alpha;

        public TransparentIcon(Icon icon, float alpha) {
            if (icon == null) {
                throw new IllegalArgumentException("Icon cannot be null");
            }
            this.icon = icon;
            this.alpha = alpha;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2d = (Graphics2D) g.create();
            AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(composite);
            icon.paintIcon(c, g2d, x, y);
            g2d.dispose();
        }

        @Override
        public int getIconWidth() {
            return icon.getIconWidth();
        }

        @Override
        public int getIconHeight() {
            return icon.getIconHeight();
        }
    }
    public static void main(String[] args) {
        new Reception();
    }
    
}
