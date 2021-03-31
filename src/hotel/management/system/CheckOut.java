package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class CheckOut extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JComboBox rooms_combobox;
    JButton submit, back;

    CheckOut(){
        // size and location of bounding box
        setBounds(520,250,500,300);

        // heading label
        JLabel heading = new JLabel("CHECK OUT");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(125,5,500,50);
        add(heading);

        // customer image resized and added
        ImageIcon checkout_image = new ImageIcon(ClassLoader.getSystemResource("images/checkout.png"));
        JLabel checkout_image_label = new JLabel(checkout_image);
        checkout_image_label.setBounds(150,10,400,300);
        add(checkout_image_label);

        // allocated room no. label
        JLabel room_label = new JLabel("Occupied Room No. : ");
        room_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        room_label.setForeground(Color.WHITE);
        room_label.setBounds(20,75,150,20);
        add(room_label);

        // created array list of string data type
        ArrayList<String> rooms_list = new ArrayList<>();

        try {
            // query for available rooms
            DatabaseConnection connect = new DatabaseConnection();
            String query = "SELECT * FROM room WHERE availability = 'occupied'";
            ResultSet result = connect.statement.executeQuery(query);
            while (result.next()){
                // added each available room in array list
                rooms_list.add(result.getString("room_no"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        // converting available rooms arraylist to array
        String[] available_rooms = rooms_list.toArray(new String[rooms_list.size()]);
        rooms_combobox = new JComboBox(available_rooms);
        String room_no = (String)rooms_combobox.getSelectedItem();
        rooms_combobox.setBackground(Color.WHITE);
        rooms_combobox.setBounds(170,75,100,20);
        add(rooms_combobox);

        // submit button
        submit = new JButton("SUBMIT");
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(66,34,130));
        submit.setFont(new Font("times new roman", Font.PLAIN, 20));
        submit.addActionListener(this);
        submit.setBounds(70,125,115,30);
        add(submit);

        // back  button
        back = new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(66,34,130));
        back.setFont(new Font("times new roman", Font.PLAIN, 20));
        back.addActionListener(this);back.setBounds(70,175,115,30);
        add(back);

        // dialog box background color
        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){
            String room_no = (String)rooms_combobox.getSelectedItem();
            if (room_no == null){
                String message = "No Room Selected !!!";
                JOptionPane.showMessageDialog(null, message, "WARNING", JOptionPane.WARNING_MESSAGE);
            } else{
                DatabaseConnection connect = new DatabaseConnection();
                // database query
                // Update availability status in room table
                String query1 = "UPDATE room SET availability = 'available' WHERE room_no = '" + room_no + "'";
                // Update check status in customer table
                String query2 = "UPDATE customer SET check_status = 'check_out' WHERE room_no = '" + room_no + "' and check_status = 'check_in'";
                // Update clean status in room table
                String query3 = "UPDATE room SET cleaning_status = 'dirty' WHERE room_no = '" + room_no + "'";
                try {
                    // Execute the query
                    connect.statement.executeUpdate(query1);
                    connect.statement.executeUpdate(query2);
                    connect.statement.executeUpdate(query3);
                    String message = "Room no. '"+room_no+"' is now available !!!";
                    // popup message
                    JOptionPane.showMessageDialog(null, message);
                    this.setVisible(false);
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
        new CheckOut().setVisible(true);
    }
}