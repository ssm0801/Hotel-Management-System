package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    // all objects declared globally in class to use in methods
    JButton login_button, cancel_button;
    JTextField un_field;
    JPasswordField psd_field;

    public Login(){
        // size and location of bounding box
        setBounds(500,130,500,600);
        setLayout(null);

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
        login_button = new JButton("Login");
        login_button.setBounds(150,400,90,30);
        login_button.setBackground(Color.BLACK);
        login_button.setForeground(Color.WHITE);
        login_button.addActionListener(this);
        add(login_button);

        // Cancel button and its properties, size and location
        cancel_button = new JButton("Cancel");
        cancel_button.setBounds(250,400,90,30);
        cancel_button.setBackground(Color.BLACK);
        cancel_button.setForeground(Color.WHITE);
        cancel_button.addActionListener(this);
        add(cancel_button);

        // Change dialog box background color
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    // action function for login and cancel buttons
    public void actionPerformed(ActionEvent action){
        if (action.getSource() == login_button){
            try {
                String username = un_field.getText();
                String password = psd_field.getText();
                DatabaseConnection connect = new DatabaseConnection();
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet result = connect.statement.executeQuery(query);
                if (result.next()){
                    new Dashboard().setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Login !!!");
                }
                setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        // exit the application
        else if (action.getSource() == cancel_button){
//            System.exit(0);
            setVisible(false);
            new HotelManagementSystem().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
