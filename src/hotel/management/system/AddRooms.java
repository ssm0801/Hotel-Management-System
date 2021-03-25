package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JTextField room_no_field, price_field;
    JComboBox availability_combobox, cleaning_status_combobox, bed_type_combobox;
    String availability, cleaning_status, bed_type;

    AddRooms(){
        // size and location of bounding box
        setBounds(375,240,800,375);

        // heading and its properties
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(270,7,250,35);
        add(heading);

        // employee image resized and added
        ImageIcon employee_image = new ImageIcon(ClassLoader.getSystemResource("images/room.jpg"));
        Image img = employee_image.getImage().getScaledInstance(300,200, Image.SCALE_DEFAULT);
        ImageIcon new_employee_image = new ImageIcon(img);
        JLabel employee_image_label = new JLabel(new_employee_image);
        employee_image_label.setBounds(430,60,300,200);
        add(employee_image_label);

        // room number label
        JLabel room_no_label = new JLabel("Room No. : ");
        room_no_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        room_no_label.setForeground(Color.WHITE);
        room_no_label.setBounds(50,70,100,20);
        add(room_no_label);

        // room number field
        room_no_field = new JTextField();
        room_no_field.setBounds(175,70,50,20);
        add(room_no_field);

        // availability label
        JLabel availability_label = new JLabel("Availability : ");
        availability_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        availability_label.setForeground(Color.WHITE);
        availability_label.setBounds(50,110,100,20);
        add(availability_label);

        // availability combobox and variable
        availability_combobox = new JComboBox(new String[] {"Available", "Occupied"});
        availability = (String)availability_combobox.getSelectedItem();
        availability_combobox.setBackground(Color.WHITE);
        availability_combobox.setBounds(175,110,200,20);
        add(availability_combobox);

        // cleaning status label
        JLabel cleaning_status_label = new JLabel("Cleaning Status : ");
        cleaning_status_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        cleaning_status_label.setForeground(Color.WHITE);
        cleaning_status_label.setBounds(50,150,150,20);
        add(cleaning_status_label);

        // cleaning status combobox and variable
        cleaning_status_combobox = new JComboBox(new String[] {"Cleaned", "Dirty"});
        cleaning_status = (String)cleaning_status_combobox.getSelectedItem();
        cleaning_status_combobox.setBackground(Color.WHITE);
        cleaning_status_combobox.setBounds(175,150,200,20);
        add(cleaning_status_combobox);

        // bed type label
        JLabel bed_type_label = new JLabel("Bed Type : ");
        bed_type_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        bed_type_label.setForeground(Color.WHITE);
        bed_type_label.setBounds(50,190,100,20);
        add(bed_type_label);

        // bed type combobox and variable
        bed_type_combobox = new JComboBox(new String[] {"Single Bed", "Double Bed"});
        bed_type = (String)bed_type_combobox.getSelectedItem();
        bed_type_combobox.setBackground(Color.WHITE);
        bed_type_combobox.setBounds(175,190,200,20);
        add(bed_type_combobox);

        // price label
        JLabel price_label = new JLabel("Price : ");
        price_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        price_label.setForeground(Color.WHITE);
        price_label.setBounds(50,230,100,20);
        add(price_label);

        // price field
        price_field = new JTextField();
        price_field.setBounds(175,230,50,20);
        add(price_field);

        // submit button
        JButton submit = new JButton("SUBMIT");
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(66,34,130));
        submit.setFont(new Font("times new roman", Font.PLAIN, 20));
        submit.addActionListener(this);
        submit.setBounds(315,280,115,30);
        add(submit);

        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // all info took in separate variable
        String room_no = room_no_field.getText();
        // availability, cleaning_status, bed_type variable added above
        String price = price_field.getText();

        // database connection object
        DatabaseConnection connect = new DatabaseConnection();
        // database query
        String query = "INSERT INTO room values( '"+room_no+"', '"+availability+"', '"+cleaning_status+"','"+bed_type+"', '"+price+"')";

        try {
            // Execute the query
            connect.statement.executeUpdate(query);
            String message = "New Room "+room_no+" Added !!!";
            // popup message
            JOptionPane.showMessageDialog(null, message);
            this.setVisible(false);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }
}
