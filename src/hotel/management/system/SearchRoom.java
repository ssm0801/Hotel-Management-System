package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JButton check, back;
    ButtonGroup bed_type_group;
    JTable rooms_table;
    JCheckBox available;

    SearchRoom(){
        // size and location of bounding box
        setBounds(275,125,1000,600);

        // heading and its properties
        JLabel heading = new JLabel("SEARCH ROOM");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(345,15,300,35);
        add(heading);

        // bed type label and its properties
        JLabel bed_type_label = new JLabel("Bed Type : ");
        bed_type_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        bed_type_label.setForeground(Color.WHITE);
        bed_type_label.setBounds(275,75,150,20);
        add(bed_type_label);

        // single bed button and its properties
        JRadioButton single_bed = new JRadioButton("Single Bed");
        single_bed.setActionCommand("single");
        single_bed.setFont(new Font("Tahoma",Font.PLAIN,14));
        single_bed.setBackground(new Color(32,32,32));
        single_bed.setForeground(Color.WHITE);
        single_bed.setBounds(360,75,100,20);
        add(single_bed);

        // double bed button and its properties
        JRadioButton double_bed = new JRadioButton("Double Bed");
        double_bed.setActionCommand("double");
        double_bed.setFont(new Font("Tahoma",Font.PLAIN,14));
        double_bed.setBackground(new Color(32,32,32));
        double_bed.setForeground(Color.WHITE);
        double_bed.setBounds(360,100,100,20);
        add(double_bed);

        // availability button group
        bed_type_group = new ButtonGroup();
        bed_type_group.add(single_bed);
        bed_type_group.add(double_bed);

        // available checkbox and its properties
        available = new JCheckBox("only available");
        available.setBackground(new Color(32,32,32));
        available.setForeground(Color.WHITE);
        available.setFont(new Font("arial", Font.PLAIN, 15));
        available.setBounds(550,75,125,20);
        add(available);

        // table headings
        JLabel room_no = new JLabel("ROOM NO.");
        room_no.setFont(new Font("Tahoma",Font.BOLD, 15));
        room_no.setForeground(Color.WHITE);
        room_no.setBounds(65,140,150,20);
        add(room_no);

        JLabel availability_status = new JLabel("AVAILABILITY");
        availability_status.setFont(new Font("Tahoma",Font.BOLD, 15));
        availability_status.setForeground(Color.WHITE);
        availability_status.setBounds(235,140,150,20);
        add(availability_status);

        JLabel cleaning_status = new JLabel("CLEANING");
        cleaning_status.setFont(new Font("Tahoma",Font.BOLD, 15));
        cleaning_status.setForeground(Color.WHITE);
        cleaning_status.setBounds(450,140,150,20);
        add(cleaning_status);

        JLabel bed_type = new JLabel("BED TYPE");
        bed_type.setFont(new Font("Tahoma",Font.BOLD, 15));
        bed_type.setForeground(Color.WHITE);
        bed_type.setBounds(660,140,150,20);
        add(bed_type);

        JLabel price = new JLabel("PRICE");
        price.setFont(new Font("Tahoma",Font.BOLD, 15));
        price.setForeground(Color.WHITE);
        price.setBounds(860,140,150,20);
        add(price);

        // table and its properties
        rooms_table = new JTable();
        rooms_table.setBackground(new Color(32,32,32));
        rooms_table.setForeground(Color.WHITE);
        rooms_table.setFont(new Font("arial", Font.PLAIN, 15));
        rooms_table.setRowHeight(20);
        rooms_table.setBounds(0,175,1000,300);
        add(rooms_table);

        // check button and its properties
        check = new JButton("CHECK");
        check.setForeground(Color.WHITE);
        check.setBackground(new Color(66,34,130));
        check.setFont(new Font("times new roman", Font.PLAIN, 20));
        check.addActionListener(this);
        check.setBounds(360,500,115,30);
        add(check);

        // back button and its properties
        back = new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(66,34,130));
        back.setFont(new Font("times new roman", Font.PLAIN, 20));
        back.addActionListener(this);
        back.setBounds(490,500,115,30);
        add(back);

        // dialog box background
        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check){
            // bed type selected button
            String bed_type = bed_type_group.getSelection().getActionCommand();
            DatabaseConnection connection = new DatabaseConnection();
            if (available.isSelected()){
                // query when only available is selected
                String query = "select * from room where availability ='available' and bed_type ='"+ bed_type+"'";
                try {
                    ResultSet result = connection.statement.executeQuery(query);
                    rooms_table.setModel(DbUtils.resultSetToTableModel(result));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else {
                // query when only available is not selected
                String query = "select * from room where bed_type ='"+ bed_type+"'";
                try {
                    ResultSet result = connection.statement.executeQuery(query);
                    rooms_table.setModel(DbUtils.resultSetToTableModel(result));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }else if (ae.getSource() == back){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }
}
