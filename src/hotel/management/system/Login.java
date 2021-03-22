package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{

    Login(){
        // size and location of bounding box
        setBounds(500,130,500,600);

        // Inserted image and changed its dimension and gave location in dialog box
        ImageIcon login_image = new ImageIcon(ClassLoader.getSystemResource("images/login.jpeg"));
        Image img = login_image.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon new_login_image = new ImageIcon(img);
        JLabel login_image_label = new JLabel(new_login_image);
        login_image_label.setBounds(150,50,200,200);
        add(login_image_label);

        // Username label and its size and location
        JLabel un_label = new JLabel("Username : ");
        un_label.setBounds(140,300,100,30);
        add(un_label);

        // Password label and its size and location
        JLabel psd_label = new JLabel("Password : ");
        psd_label.setBounds(140,350,100,30);
        add(psd_label);

        // Username field and its size and location
        JTextField un_field = new JTextField();
        un_field.setBounds(210,300,150,30);
        add(un_field);

        // Password field and its size and location
        JPasswordField psd_field = new JPasswordField();
        psd_field.setBounds(210,350,150,30);
        add(psd_field);

        // Login button and its properties, size and location
        JButton login_button = new JButton("Login");
        login_button.setBounds(150,400,90,30);
        login_button.setBackground(Color.BLACK);
        login_button.setForeground(Color.WHITE);
        add(login_button);

        // Cancel button and its properties, size and location
        JButton cancel_button = new JButton("Cancel");
        cancel_button.setBounds(250,400,90,30);
        cancel_button.setBackground(Color.BLACK);
        cancel_button.setForeground(Color.WHITE);
        add(cancel_button);

        // Change dialog box background color
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Login login = new Login();
    }

}
