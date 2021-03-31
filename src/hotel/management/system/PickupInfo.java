package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class PickupInfo extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JButton check_button, back_button;
    JTable table;

    PickupInfo(){

        // size and location of bounding box
        setBounds(160,85,1250,700);

        // heading and its properties
        JLabel heading = new JLabel("PICKUP INFO");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(450,15,350,35);
        add(heading);

        // all labels declared which are used below
        JLabel car, address, time;

        // car
        car = new JLabel("CAR");
        car.setFont(new Font("Tahoma",Font.BOLD, 15));
        car.setForeground(Color.WHITE);
        car.setBounds(175,115,70,30);
        add(car);

        // address
        address = new JLabel("ADDRESS");
        address.setFont(new Font("Tahoma",Font.BOLD, 15));
        address.setForeground(Color.WHITE);
        address.setBounds(550,115,100,30);
        add(address);

        // time
        time = new JLabel("TIME");
        time.setFont(new Font("Tahoma",Font.BOLD, 15));
        time.setForeground(Color.WHITE);
        time.setBounds(1000,115,70,30);
        add(time);

        // table and its properties
        table = new JTable();
        table.setBackground(new Color(32,32,32));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("arial", Font.PLAIN, 15));
        table.setRowHeight(20);
        table.setBounds(0,160,1250,400);
        add(table);

        // check button
        check_button = new JButton("CHECK");
        check_button.setForeground(Color.WHITE);
        check_button.setBackground(new Color(66,34,130));
        check_button.setFont(new Font("times new roman", Font.PLAIN, 20));
        check_button.addActionListener(this);
        check_button.setBounds(475,600,115,30);
        add(check_button);

        // back button
        back_button = new JButton("BACK");
        back_button.setForeground(Color.WHITE);
        back_button.setBackground(new Color(66,34,130));
        back_button.setFont(new Font("times new roman", Font.PLAIN, 20));
        back_button.addActionListener(this);
        back_button.setBounds(625,600,100,30);
        add(back_button);

        // dialog box background color
        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check_button) {
            DatabaseConnection connection = new DatabaseConnection();
            // query for pickup table
            String query = "SELECT * FROM pickup";
            try {
                ResultSet result = connection.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(result));
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back_button) {
            // get back to reception on clicking back button
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new PickupInfo().setVisible(true);
    }
}
