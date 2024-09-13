package quize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class Login extends JFrame implements ActionListener{

    JButton rules, back;
    JTextField tfname;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 400, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(0, 0, 500, 400); // Adjusted bounds
        add(image);
        JLabel heading = new JLabel("QUIZ APP");
        heading.setBounds(600, 40, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        JLabel by = new JLabel("by");
        by.setBounds(680, 70, 300, 45);
        by.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
        by.setForeground(new Color(30, 144, 254));
        add(by);
        JLabel aswathi= new JLabel("ASWATHI ❤️");
        aswathi.setBounds(628, 93, 300, 45);
        aswathi.setFont(new Font("Viner Hand ITC", Font.BOLD, 27));
        aswathi.setForeground(new Color(30, 144, 254));
        add(aswathi);
        JLabel name = new JLabel("Enter your name");
        name.setBounds(600, 167, 300, 25);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        name.setForeground(new Color(30, 144, 254));
        add(name);
        tfname = new JTextField();
        tfname.setBounds(550, 210, 320, 35);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        rules = new JButton("Start");
        rules.setBounds(550, 275, 120, 35);
        rules.setBackground(new Color(30, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rules.addActionListener(this);
        add(rules);
        back = new JButton("Exit");
        back.setBounds(750, 275, 120, 35);
        back.setBackground(new Color(30, 144, 254));
        back.setFont(new Font("Times New Roman", Font.BOLD, 20));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        setSize(920, 400);
        setLocation(220, 190);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
