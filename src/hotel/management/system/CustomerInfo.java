package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JButton check_button, back_button;
    JTable table;
    JCheckBox foreigner;

    CustomerInfo(){

        // size and location of bounding box
        setBounds(160,85,1250,700);

        // heading and its properties
        JLabel heading = new JLabel("CUSTOMER INFO");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(450,15,350,35);
        add(heading);

        // foreigner checkbox and its properties
        foreigner = new JCheckBox("only foreigner");
        foreigner.setBackground(new Color(32,32,32));
        foreigner.setForeground(Color.WHITE);
        foreigner.setFont(new Font("arial", Font.PLAIN, 15));
        foreigner.setBounds(550,75,125,20);
        add(foreigner);

        // all labels declared which are used below
        JLabel name, id, gender, phone, country, room, deposit, check_status;

        // name
        name = new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.BOLD, 15));
        name.setForeground(Color.WHITE);
        name.setBounds(50,115,70,30);
        add(name);

        // phone no
        phone = new JLabel("PHONE NO.");
        phone.setFont(new Font("Tahoma",Font.BOLD, 15));
        phone.setForeground(Color.WHITE);
        phone.setBounds(180,115,100,30);
        add(phone);

        // gender
        gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.BOLD, 15));
        gender.setForeground(Color.WHITE);
        gender.setBounds(360,115,70,30);
        add(gender);

        // id
        id = new JLabel("ID");
        id.setFont(new Font("Tahoma",Font.BOLD, 15));
        id.setForeground(Color.WHITE);
        id.setBounds(525,115,70,30);
        add(id);

        // country
        country = new JLabel("COUNTRY");
        country.setFont(new Font("Tahoma",Font.BOLD, 15));
        country.setForeground(Color.WHITE);
        country.setBounds(650,115,100,30);
        add(country);

        // room no
        room = new JLabel("ROOM NO.");
        room.setFont(new Font("Tahoma",Font.BOLD, 15));
        room.setForeground(Color.WHITE);
        room.setBounds(815,115,100,30);
        add(room);

        // deposit
        deposit = new JLabel("DEPOSIT");
        deposit.setFont(new Font("Tahoma",Font.BOLD, 15));
        deposit.setForeground(Color.WHITE);
        deposit.setBounds(975,115,70,30);
        add(deposit);

        // check status
        check_status = new JLabel("CHECK STATUS");
        check_status.setFont(new Font("Tahoma",Font.BOLD, 15));
        check_status.setForeground(Color.WHITE);
        check_status.setBounds(1100,115,125,30);
        add(check_status);

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
            if (foreigner.isSelected()){
                // query when only foreigner is selected
                String query = "SELECT * FROM customer WHERE country != 'india'";
                try {
                    ResultSet result = connection.statement.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(result));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else {
                // query when only available is not selected
                String query = "SELECT * FROM customer";
                try {
                    ResultSet result = connection.statement.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(result));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back_button) {
            // get back to reception on clicking back button
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CustomerInfo().setVisible(true);
    }
}
