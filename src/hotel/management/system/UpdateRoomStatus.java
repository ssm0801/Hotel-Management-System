package hotel.management.system;

import com.placeholder.PlaceHolder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class UpdateRoomStatus extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JTextField cleaning_status_field;
    JComboBox rooms_combobox;
    JButton check, submit, back;

    UpdateRoomStatus(){

        // size and location of bounding box
        setBounds(425,160,700,500);
        PlaceHolder holder;

        // heading label
        JLabel heading = new JLabel("Update Room Status");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(125,5,500,50);
        add(heading);

        // customer image resized and added
        ImageIcon updateroom_image = new ImageIcon(ClassLoader.getSystemResource("images/updateroom.jpg"));
        Image img = updateroom_image.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
        ImageIcon new_updateroom_image = new ImageIcon(img);
        JLabel updateroom_image_label = new JLabel(new_updateroom_image);
        updateroom_image_label.setBounds(260,75,400,300);
        add(updateroom_image_label);

        // allocated room no. label
        JLabel room_label = new JLabel("Dirty Room No. : ");
        room_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        room_label.setForeground(Color.WHITE);
        room_label.setBounds(20,150,150,20);
        add(room_label);

        // created array list of string data type
        ArrayList<String> rooms_list = new ArrayList<>();
        try {
            // query for available rooms
            DatabaseConnection connect = new DatabaseConnection();
            String query = "SELECT * FROM room WHERE availability = 'Available' and cleaning_status = 'dirty'";
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
        rooms_combobox.setBounds(140,150,100,20);
        add(rooms_combobox);

        // cleaning status label
        JLabel cleaning_status_label = new JLabel("Clean Status : ");
        cleaning_status_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        cleaning_status_label.setForeground(Color.WHITE);
        cleaning_status_label.setBounds(40,190,100,20);
        add(cleaning_status_label);

        // cleaning status field
        cleaning_status_field = new JTextField();
        cleaning_status_field.setBounds(140,190,100,20);
        add(cleaning_status_field);

        // check button
        check = new JButton("CHECK");
        check.setForeground(Color.WHITE);
        check.setBackground(new Color(66,34,130));
        check.setFont(new Font("times new roman", Font.PLAIN, 20));
        check.addActionListener(this);
        check.setBounds(75,250,115,30);
        add(check);

        // submit button
        submit = new JButton("SUBMIT");
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(66,34,130));
        submit.setFont(new Font("times new roman", Font.PLAIN, 20));
        submit.addActionListener(this);
        submit.setBounds(210,400,115,30);
        add(submit);

        // back  button
        back = new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(66,34,130));
        back.setFont(new Font("times new roman", Font.PLAIN, 20));
        back.addActionListener(this);back.setBounds(340,400,115,30);
        add(back);

        // dialog box background color
        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check){
            String room_no = (String)rooms_combobox.getSelectedItem();
            DatabaseConnection connect = new DatabaseConnection();
            // database query
            String query = "SELECT * FROM room WHERE room_no = '"+room_no+"'";
            try {
                ResultSet result = connect.statement.executeQuery(query);
                while (result.next()){
                    // added each available room in array list
                    cleaning_status_field.setText(result.getString("cleaning_status"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if (ae.getSource() == submit){
            String room_no = (String)rooms_combobox.getSelectedItem();
            String clean_status = cleaning_status_field.getText();
            if (room_no == null){
                String message = "No Room Selected !!!";
                // pop up message
                JOptionPane.showMessageDialog(null, message, "WARNING", JOptionPane.WARNING_MESSAGE);
            }
            else{
                DatabaseConnection connect = new DatabaseConnection();
                // database query
                String query = "UPDATE room SET cleaning_status = '"+clean_status+"' WHERE room_no = '"+room_no+"'";
                try {
                    // Execute the query
                    connect.statement.executeUpdate(query);
                    // pop up message
                    String message = "Changed clean status of room " + room_no + " to "+clean_status+"!!!";
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
        new UpdateRoomStatus().setVisible(true);
    }
}