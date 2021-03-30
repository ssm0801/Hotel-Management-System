package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import com.placeholder.PlaceHolder;

public class NewCustomer extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JTextField name_field, phone_field, country_field, deposit_field, check_status_field;
    JComboBox id_combobox, room_allocated_combobox;
    JButton submit, back;
    ButtonGroup gender_group;

    NewCustomer(){
        // size and location of bounding box
        setBounds(425,150,700,500);
        PlaceHolder holder;

        // heading label
        JLabel heading = new JLabel("New Customer");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(190,10,290,40);
        add(heading);

        // customer image resized and added
        ImageIcon customer_image = new ImageIcon(ClassLoader.getSystemResource("images/customer.jpg"));
        Image img = customer_image.getImage().getScaledInstance(250,300, Image.SCALE_DEFAULT);
        ImageIcon new_customer_image = new ImageIcon(img);
        JLabel customer_image_label = new JLabel(new_customer_image);
        customer_image_label.setBounds(400,75,250,300);
        add(customer_image_label);

        // name label
        JLabel name_label = new JLabel("Name : ");
        name_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        name_label.setForeground(Color.WHITE);
        name_label.setBounds(50,70,60,20);
        add(name_label);

        // name field
        name_field = new JTextField();
        name_field.setBounds(160,70,200,20);
        add(name_field);
        // name place holder
        holder = new PlaceHolder(name_field,"full name");

        // phone label
        JLabel phone_label = new JLabel("Phone : ");
        phone_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        phone_label.setForeground(Color.WHITE);
        phone_label.setBounds(50,110,70,20);
        add(phone_label);

        // phone field
        phone_field = new JTextField();
        phone_field.setBounds(160,110,200,20);
        add(phone_field);
        // phone placeholder
        holder = new PlaceHolder(phone_field,"+91xxxxxxxxxx");

        // gender label
        JLabel gender_label = new JLabel("Gender : ");
        gender_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        gender_label.setForeground(Color.WHITE);
        gender_label.setBounds(50,150,80,20);
        add(gender_label);

        // male radio button
        JRadioButton male = new JRadioButton("Male");
        male.setActionCommand("male");
        male.setFont(new Font("Tahoma",Font.PLAIN,14));
        male.setBackground(new Color(32,32,32));
        male.setForeground(Color.WHITE);
        male.setBounds(160,150,70,20);
        add(male);

        // female radio button
        JRadioButton female = new JRadioButton("Female");
        female.setActionCommand("female");
        female.setFont(new Font("Tahoma",Font.PLAIN,14));
        female.setBackground(new Color(32,32,32));
        female.setForeground(Color.WHITE);
        female.setBounds(160,180,80,20);
        add(female);

        // other radio button
        JRadioButton other = new JRadioButton("Other");
        other.setActionCommand("other");
        other.setFont(new Font("Tahoma",Font.PLAIN,14));
        other.setBackground(new Color(32,32,32));
        other.setForeground(Color.WHITE);
        other.setBounds(160,210,80,20);
        add(other);

        // gender radio buttons grouped
        gender_group = new ButtonGroup();
        gender_group.add(male);
        gender_group.add(female);
        gender_group.add(other);

        // id label
        JLabel id_label = new JLabel("ID : ");
        id_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        id_label.setForeground(Color.WHITE);
        id_label.setBounds(50,250,70,20);
        add(id_label);

        // id list and combobox
        String id_list[] = {"Aadhar Card", "Passport", "Driving License", "Voter ID"};
        id_combobox = new JComboBox(id_list);
        String id = (String)id_combobox.getSelectedItem();
        id_combobox.setBackground(Color.WHITE);
        id_combobox.setBounds(160,250,200,20);
        add(id_combobox);

        // country label
        JLabel country_label = new JLabel("Country : ");
        country_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        country_label.setForeground(Color.WHITE);
        country_label.setBounds(50,290,70,20);
        add(country_label);

        // country field
        country_field = new JTextField();
        country_field.setBounds(160,290,200,20);
        add(country_field);

        // allocated room no. label
        JLabel room_allocated_label = new JLabel("Allocate Room : ");
        room_allocated_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        room_allocated_label.setForeground(Color.WHITE);
        room_allocated_label.setBounds(50,330,110,20);
        add(room_allocated_label);

        // created array list of string data type
        ArrayList<String> available_rooms_list = new ArrayList<>();
        try {
            // query for available rooms
            DatabaseConnection connect = new DatabaseConnection();
            String query = "SELECT * FROM room WHERE availability = 'available' ORDER BY room_no ASC";
            ResultSet result = connect.statement.executeQuery(query);
            while (result.next()){
                // added each available room in array list
                available_rooms_list.add(result.getString("room_no"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        // converting available rooms arraylist to array
        String[] available_rooms = available_rooms_list.toArray(new String[available_rooms_list.size()]);
        room_allocated_combobox = new JComboBox(available_rooms);
        String room_no = (String)room_allocated_combobox.getSelectedItem();
        room_allocated_combobox.setBackground(Color.WHITE);
        room_allocated_combobox.setBounds(160,330,200,20);
        add(room_allocated_combobox);

        // deposit label
        JLabel deposit_label = new JLabel("Deposit : ");
        deposit_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        deposit_label.setForeground(Color.WHITE);
        deposit_label.setBounds(50,370,70,20);
        add(deposit_label);

        // deposit field
        deposit_field = new JTextField();
        deposit_field.setBounds(160,370,200,20);
        add(deposit_field);

        // submit button
        submit = new JButton("SUBMIT");
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(66,34,130));
        submit.setFont(new Font("times new roman", Font.PLAIN, 20));
        submit.addActionListener(this);
        submit.setBounds(210,410,115,30);
        add(submit);

        // back  button
        back = new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(66,34,130));
        back.setFont(new Font("times new roman", Font.PLAIN, 20));
        back.addActionListener(this);
        back.setBounds(340,410,115,30);
        add(back);

        // dialog box background color
        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            // all variables
            String name = name_field.getText();
            String phone = phone_field.getText();
            String gender = gender_group.getSelection().getActionCommand();
            String id = (String) id_combobox.getSelectedItem();
            String country = country_field.getText();
            String room_no = (String) room_allocated_combobox.getSelectedItem();
            String deposit = deposit_field.getText();

            DatabaseConnection connect = new DatabaseConnection();
            // database query
            // insert new customer in customer table
            String query = "INSERT INTO customer values( '" + name + "', '" + phone + "', '" + gender + "','" + id + "', '" + country + "', '" + room_no + "','" + deposit + "','check_in')";
            try {
                // Execute the query
                connect.statement.executeUpdate(query);
                // update availability status in room table
                query = "UPDATE room SET availability = 'occupied' WHERE room_no = '" + room_no + "'";
                connect.statement.executeUpdate(query);
                String message = "New Customer Added in Room no. " + room_no + " !!!";
                // popup message
                JOptionPane.showMessageDialog(null, message);
                this.setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new NewCustomer().setVisible(true);
    }
}