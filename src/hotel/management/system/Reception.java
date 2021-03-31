package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JButton new_customer, all_employee, customer_info, check_out, update_room_status, pickup_service, search, search_room, pickup_info;

    Reception(){
        // size and location of bounding box
        setBounds(370,175,800,520);

        // colors that used for button background
        Color red = new Color(255,158,158);
        Color orange = new Color(255,205,158);
        Color yellow = new Color(255,255,158);
        Color green = new Color(183,255,158);
        Color blue = new Color(158,177,255);
        Color purple = new Color(221,160,221);
        Color violet = new Color(180,150,255);

        // heading and its properties
        JLabel heading = new JLabel("RECEPTION");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(290,15,250,35);
        add(heading);

        // reception image resized and added
        ImageIcon employee_image = new ImageIcon(ClassLoader.getSystemResource("images/reception.jpg"));
        JLabel employee_image_label = new JLabel(employee_image);
        employee_image_label.setBounds(305,110,425,285);
        add(employee_image_label);

        // new customer button
        new_customer = new JButton("New Customer Form");
        new_customer.setBackground(red);
        new_customer.setForeground(Color.BLACK);
        new_customer.setFont(new Font("serif", Font.BOLD, 20));
        new_customer.addActionListener(this);
        new_customer.setBounds(30,70,225,30);
        add(new_customer);

        // search room button
        search_room = new JButton("Search Room");
        search_room.setBackground(orange);
        search_room.setForeground(Color.BLACK);
        search_room.setFont(new Font("serif", Font.BOLD, 20));
        search_room.addActionListener(this);
        search_room.setBounds(30,120,225,30);
        add(search_room);

        // all employee info button
        all_employee = new JButton("Employee Info");
        all_employee.setBackground(yellow);
        all_employee.setForeground(Color.BLACK);
        all_employee.addActionListener(this);
        all_employee.setFont(new Font("serif", Font.BOLD, 20));
        all_employee.setBounds(30,170,225,30);
        add(all_employee);

        // customer info button
        customer_info = new JButton("Customer Info");
        customer_info.setBackground(green);
        customer_info.setForeground(Color.BLACK);
        customer_info.addActionListener(this);
        customer_info.setFont(new Font("serif", Font.BOLD, 20));
        customer_info.setBounds(30,220,225,30);
        add(customer_info);

        // check out button
        check_out = new JButton("Check Out");
        check_out.setBackground(blue);
        check_out.setForeground(Color.BLACK);
        check_out.setFont(new Font("serif", Font.BOLD, 20));
        check_out.addActionListener(this);
        check_out.setBounds(30,270,225,30);
        add(check_out);

        // pickup service button
        pickup_service = new JButton("Pickup Service");
        pickup_service.setBackground(purple);
        pickup_service.setForeground(Color.BLACK);
        pickup_service.setFont(new Font("serif", Font.BOLD, 20));
        pickup_service.addActionListener(this);
        pickup_service.setBounds(30,320,225,30);
        add(pickup_service);

        // update room status button
        update_room_status = new JButton("Update Room Status");
        update_room_status.setBackground(violet);
        update_room_status.setForeground(Color.BLACK);
        update_room_status.setFont(new Font("serif", Font.BOLD, 20));
        update_room_status.addActionListener(this);
        update_room_status.setBounds(30,370,225,30);
        add(update_room_status);

        // pickup info button
        pickup_info = new JButton("Pickup Info");
        pickup_info.setBackground(red);
        pickup_info.setForeground(Color.BLACK);
        pickup_info.setFont(new Font("serif", Font.BOLD, 20));
        pickup_info.addActionListener(this);
        pickup_info.setBounds(30,420,225,30);
        add(pickup_info);

        // dialog box background
        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == new_customer){
            // add new customer
            new NewCustomer().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == search_room){
            // search room
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == all_employee){
            // all employee info dialog box
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == customer_info){
            // customer info dialog box
            new CustomerInfo().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == check_out){
            // check out program
            new CheckOut().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == pickup_service){
            // pickup service
            new PickupService().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == update_room_status){
            // update room status
            new UpdateRoomStatus().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == pickup_info){
            // pickup info
            new PickupInfo().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }
}
