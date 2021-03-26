package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back_button;

    EmployeeInfo(){

        setBounds(100,100,1000,500);

        table = new JTable();
        table.setBounds(0,30,1000,200);
        add(table);

        back_button = new JButton("Back");
        back_button.setForeground(Color.WHITE);
        back_button.setBackground(new Color(66,34,130));
        back_button.setBounds(300,400,80,30);
        add(back_button);

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new EmployeeInfo().setVisible(true);
    }
}
