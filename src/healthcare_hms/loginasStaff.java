package healthcare_hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class loginasStaff extends JFrame implements ActionListener {
    JButton loginBtn,cancelBtn;
    JTextField usertextfield;
    JPasswordField pintextfield;
    public loginasStaff(){
        setTitle("Login as staff");

        java.net.URL logoUrl = ClassLoader.getSystemResource("../assets/icons/logo.png");
        JLabel label;
        if (logoUrl != null) {
            ImageIcon i1 = new ImageIcon(logoUrl);
            Image i2 = i1.getImage().getScaledInstance(308,180,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            label = new JLabel(i3);
        } else {
            label = new JLabel("Logo Not Found GG");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            label.setForeground(Color.RED);
        }
        label.setBounds(-50,-20,400,300);
        add(label);
        
        // ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));  
        // Image i2=i1.getImage().getScaledInstance(308,180,Image.SCALE_DEFAULT);  
        // ImageIcon i3=new ImageIcon(i2); 
        // JLabel label=new JLabel(i3);  
        // label.setBounds(-50,-20,400,300);  
        // add(label);

        JLabel text=new JLabel("Login as staff");  
        text.setFont(new Font("Copperplate Gothic Light",Font.BOLD,22)); 
        text.setBounds(350,10,400,40);
        add(text); 

        JLabel username=new JLabel("Username:");
        username.setFont(new Font("Raleway",Font.BOLD,16));
        username.setBounds(350,70,100,30);
        add(username);

        usertextfield=new JTextField();  // used to add text box
        usertextfield.setBounds(450,70,170,30);
        add(usertextfield);

        JLabel pin=new JLabel("password:");
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(350,120,100,30);
        add(pin);

        pintextfield=new JPasswordField(); 
        pintextfield.setBounds(450,120,170,30);
        add(pintextfield); 

        // Now creating Login and back buttons
        loginBtn=new JButton("LOG IN");  
        loginBtn.setBounds(350,170,110,30);
        loginBtn.setBackground(Color.RED); 
        loginBtn.setForeground(Color.white);
        loginBtn.addActionListener(this);
        add(loginBtn);

        cancelBtn=new JButton("Cancel"); 
        cancelBtn.setBounds(510,170,110,30);
        cancelBtn.setBackground(Color.yellow); 
        cancelBtn.setForeground(Color.black); 
        cancelBtn.addActionListener(this);
        add(cancelBtn);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(750,300);  
        setVisible(true);  
        setLocation(330,220); 

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn){
            try{
                conn c = new conn();
                String user = usertextfield.getText();
                String Pass = new String(pintextfield.getPassword());

                String q = "select * from StafflogIN where StaffUserID = '"+user+"' and  StaffPass = '"+Pass+"'";
                ResultSet resultSet = c.getStatement().executeQuery(q);

                if (resultSet.next()){
                    new Reception();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            // System.exit(69);
            setVisible(false);
            new login();
        }

    }
    public static void main(String args[]){
        new loginasStaff();
    }
}