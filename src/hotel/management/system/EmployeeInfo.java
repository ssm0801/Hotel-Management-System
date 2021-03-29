package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back_button;

    EmployeeInfo(){

        setBounds(100,100,1000,700);

        table = new JTable();
        table.setBounds(0,30,1000,400);
        add(table);

        JLabel name, age, gender, job, salary, phone, aadhar, email;

        name = new JLabel("Name");
        add(name);
        age = new JLabel("Age");
        add(age);
        gender = new JLabel("Gender");
        add(gender);
        job = new JLabel("Job");
        add(job);
        salary = new JLabel("Salary");
        add(salary);
        phone = new JLabel("Phone no.");
        add(phone);
        aadhar = new JLabel("Aadhar");
        add(aadhar);
        email = new JLabel("Email ID");
        add(email);

        back_button = new JButton("Back");
        back_button.setForeground(Color.WHITE);
        back_button.setBackground(new Color(66,34,130));
        back_button.addActionListener(this);
        back_button.setBounds(300,600,80,30);
        add(back_button);

        DatabaseConnection connect = new DatabaseConnection();
        String query = "SELECT * FROM employee";
        try {
            ResultSet result = connect.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception e) {
            System.out.println(e);
        }

        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        new Reception().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new EmployeeInfo().setVisible(true);
    }
}
