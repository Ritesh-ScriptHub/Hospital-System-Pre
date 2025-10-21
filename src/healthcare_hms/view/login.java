package hospital.management.system;

import javax.swing.*;
import java.awt.*;

public class login extends JFrame {
    JButton staffLogin, adminLogin,loginBtn;

    public login() {

        // Frame Settings
        setTitle("Health Care Hospital - Home");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("system/management/icons/logo.png"));
        // Image i2 = i1.getImage();
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel lable = new JLabel(i3);
        // add(lable);

        // ========== TOP PANEL ==========
        JPanel topPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 102, 204),
                        getWidth(), getHeight(), new Color(0, 51, 102));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        topPanel.setPreferredSize(new Dimension(950, 80));

        // Hospital Name
        JLabel hospitalName = new JLabel("🏥 Health Care Hospital");
        hospitalName.setFont(new Font("SansSerif", Font.BOLD, 32));
        hospitalName.setForeground(new Color(230, 230, 0));
        hospitalName.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10));
        topPanel.add(hospitalName, BorderLayout.WEST);

        // Login Button
        loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Arial", Font.BOLD, 18));
        loginBtn.setBackground(Color.WHITE);
        loginBtn.setForeground(new Color(0, 51, 102));
        loginBtn.setFocusPainted(false);
        loginBtn.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

        // Panel to hold login button + options
        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        loginPanel.setOpaque(false);
        loginPanel.add(loginBtn);

        // Hidden panel with Staff + Admin login
        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        optionsPanel.setOpaque(false);
        staffLogin = new JButton("Login as Staff");
        adminLogin = new JButton("Login as Admin");
        staffLogin.setVisible(false);
        adminLogin.setVisible(false);
        optionsPanel.add(staffLogin);
        optionsPanel.add(adminLogin);

        // Add both panels stacked vertically
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setOpaque(false);
        rightPanel.add(loginPanel, BorderLayout.NORTH);
        rightPanel.add(optionsPanel, BorderLayout.SOUTH);

        topPanel.add(rightPanel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // Toggle visibility of staff/admin login when login button clicked
        loginBtn.addActionListener(e -> {
            boolean visible = !staffLogin.isVisible();
            staffLogin.setVisible(visible);
            adminLogin.setVisible(visible);
            optionsPanel.revalidate();
            optionsPanel.repaint();
        });

        // ====== ACTIONS ======
        staffLogin.addActionListener(e -> {
            new loginasStaff();
            dispose();
        });

        adminLogin.addActionListener(e -> {
            new loginasAdmin();
            dispose();
        });



        // ========== CENTER PANEL WITH CARD BUTTONS ==========
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2, 25, 25));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 180, 40, 180));
        centerPanel.setBackground(Color.WHITE);

        String[] labels = {"About Us", "Departments", "Our Services", "Doctors"};
        String[] icons = {"🏥", "🏬", "💉", "👨‍⚕️"};
        JButton[] buttons = new JButton[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JButton btn = new JButton("<html><div style='text-align:center; font-size:18px;'>"
                    + icons[i] + "<br>" + labels[i] + "</div></html>");

            btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
            btn.setBackground(new Color(0, 102, 204));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btn.setBorder(BorderFactory.createMatteBorder(3, 3, 6, 6, new Color(200, 200, 200)));
            btn.setOpaque(true);

            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(0, 51, 102));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(0, 102, 204));
                }
            });

            buttons[i] = btn;
            centerPanel.add(btn);
        }

        add(centerPanel, BorderLayout.CENTER);

        // ========== FOOTER ==========
        JPanel footerPanel = new JPanel(new GridLayout(2, 1));
        footerPanel.setBackground(new Color(0, 51, 102));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JLabel contact = new JLabel("📍 Durgapur, Paschim Burdhaman, West Bengal | ☎ Helpline: 0345-XXXXX0 | 🚑 Emergency: 98XXXX00", JLabel.CENTER);
        contact.setForeground(Color.WHITE);
        contact.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel copyright = new JLabel("© 2025 Health Care Hospital. All Rights Reserved.", JLabel.CENTER);
        copyright.setForeground(Color.LIGHT_GRAY);
        copyright.setFont(new Font("Segoe UI", Font.ITALIC, 12));

        footerPanel.add(contact);
        footerPanel.add(copyright);

        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(login::new);
    }
}
