package hotel.management.system;

import com.placeholder.PlaceHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class PickupService extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JComboBox cars_combobox;
    JTextField address_field, time_field;
    JButton submit, back;

    PickupService(){
        // size and location of bounding box
        setBounds(460,100,600,675);

        // placeholder object
        PlaceHolder holder;

        // heading label
        JLabel heading = new JLabel("PICKUP SERVICE");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(125,5,500,50);
        add(heading);

        // pickup image resized and added
        ImageIcon checkout_image = new ImageIcon(ClassLoader.getSystemResource("images/pickup.jpg"));
        Image img = checkout_image.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon new_checkout_image = new ImageIcon(img);
        JLabel checkout_image_label = new JLabel(new_checkout_image);
        checkout_image_label.setBounds(150,70,300,300);
        add(checkout_image_label);

        // car label
        JLabel car_label = new JLabel("Car : ");
        car_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        car_label.setForeground(Color.WHITE);
        car_label.setBounds(225,400,150,20);
        add(car_label);

        // created array list of string data type
        ArrayList<String> car_list = new ArrayList<>();

        try {
            // query for available cars
            DatabaseConnection connect = new DatabaseConnection();
            String query = "SELECT * FROM car";
            ResultSet result = connect.statement.executeQuery(query);
            while (result.next()){
                // added each car in array list
                car_list.add(result.getString("model"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        // converting available cars arraylist to array
        String[] available_cars = car_list.toArray(new String[car_list.size()]);
        cars_combobox = new JComboBox(available_cars);
        String car = (String)cars_combobox.getSelectedItem();
        cars_combobox.setBackground(Color.WHITE);
        cars_combobox.setBounds(275,400,100,20);
        add(cars_combobox);

        // address label
        JLabel address_label = new JLabel("Address : ");
        address_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        address_label.setForeground(Color.WHITE);
        address_label.setBounds(195,440,150,20);
        add(address_label);

        // address field
        address_field = new JTextField();
        address_field.setBounds(275,440,100,20);
        add(address_field);
        // address place holder
        holder = new PlaceHolder(address_field,"address");

        // time label
        JLabel time_label = new JLabel("Time : ");
        time_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        time_label.setForeground(Color.WHITE);
        time_label.setBounds(215,480,150,20);
        add(time_label);

        // time field
        time_field = new JTextField();
        time_field.setBounds(275,480,100,20);
        add(time_field);
        // time place holder
        holder = new PlaceHolder(time_field,"hh:mm");

        // submit button
        submit = new JButton("SUBMIT");
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(66,34,130));
        submit.setFont(new Font("times new roman", Font.PLAIN, 20));
        submit.addActionListener(this);
        submit.setBounds(250,525,115,30);
        add(submit);

        // back button
        back = new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(66,34,130));
        back.setFont(new Font("times new roman", Font.PLAIN, 20));
        back.addActionListener(this);
        back.setBounds(250,575,115,30);
        add(back);

        // dialog box background color
        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){
            String car = (String)cars_combobox.getSelectedItem();
            String address = address_field.getText();
            String time = time_field.getText();

            // inserting pickup values in pickup table
            String query = "INSERT INTO pickup VALUES('" + car + "', '" + address + "', '" + time + "')";

            try {
                DatabaseConnection connection = new DatabaseConnection();
                connection.statement.executeUpdate(query);
                connection.statement.executeUpdate("DELETE FROM pickup WHERE time = 'hh:mm'");
                String message = "New Pickup added !!!";
                JOptionPane.showMessageDialog(null, message);
                this.setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }

        }else if (ae.getSource() == back){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PickupService().setVisible(true);
    }
}
