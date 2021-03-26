package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JButton new_customer, room, department, all_employee, customer_info, check_out, update_check_status, update_room_status, pickup_service, search_room;

    Reception(){
        // size and location of bounding box
        setBounds(360,125,800,625);

        // heading and its properties
        JLabel heading = new JLabel("RECEPTION");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(290,15,250,35);
        add(heading);

        // reception image resized and added
        ImageIcon employee_image = new ImageIcon(ClassLoader.getSystemResource("images/reception.jpg"));
        JLabel employee_image_label = new JLabel(employee_image);
        employee_image_label.setBounds(305,170,425,285);
        add(employee_image_label);

        // new customer button
        new_customer = new JButton("New Customer Form");
        new_customer.setBackground(new Color(255,158,158));
        new_customer.setForeground(Color.BLACK);
        new_customer.setFont(new Font("serif", Font.BOLD, 20));
        new_customer.addActionListener(this);
        new_customer.setBounds(30,70,225,30);
        add(new_customer);

        // room button
        room = new JButton("Room");
        room.setBackground(new Color(255,205,158));
        room.setForeground(Color.BLACK);
        room.addActionListener(this);
        room.setFont(new Font("serif", Font.BOLD, 20));
        room.setBounds(30,120,225,30);
        add(room);

        // department button
        department = new JButton("Department");
        department.setBackground(new Color(255,255,158));
        department.setForeground(Color.BLACK);
        department.addActionListener(this);
        department.setFont(new Font("serif", Font.BOLD, 20));
        department.setBounds(30,170,225,30);
        add(department);

        // all employee info button
        all_employee = new JButton("All Employee Info");
        all_employee.setBackground(new Color(183,255,158));
        all_employee.setForeground(Color.BLACK);
        all_employee.setFont(new Font("serif", Font.BOLD, 20));
        all_employee.setBounds(30,220,225,30);
        add(all_employee);

        // customer info button
        customer_info = new JButton("Customer Info");
        customer_info.setBackground(new Color(158,177,255));
        customer_info.setForeground(Color.BLACK);
        customer_info.addActionListener(this);
        customer_info.setFont(new Font("serif", Font.BOLD, 20));
        customer_info.setBounds(30,270,225,30);
        add(customer_info);

        // check out button
        check_out = new JButton("Check Out");
        check_out.setBackground(new Color(180,150,255));
        check_out.setForeground(Color.BLACK);
        check_out.setFont(new Font("serif", Font.BOLD, 20));
        check_out.addActionListener(this);
        check_out.setBounds(30,320,225,30);
        add(check_out);

        // update check status button
        update_check_status = new JButton("Update Check Status");
        update_check_status.setBackground(new Color(255,158,158));
        update_check_status.setForeground(Color.BLACK);
        update_check_status.setFont(new Font("serif", Font.BOLD, 20));
        update_check_status.addActionListener(this);
        update_check_status.setBounds(30,370,225,30);
        add(update_check_status);

        // update room status button
        update_room_status = new JButton("Update Room Status");
        update_room_status.setBackground(new Color(255,205,158));
        update_room_status.setForeground(Color.BLACK);
        update_room_status.setFont(new Font("serif", Font.BOLD, 20));
        update_room_status.addActionListener(this);
        update_room_status.setBounds(30,420,225,30);
        add(update_room_status);

        // pickup service button
        pickup_service = new JButton("Pickup Service");
        pickup_service.setBackground(new Color(255,255,158));
        pickup_service.setForeground(Color.BLACK);
        pickup_service.setFont(new Font("serif", Font.BOLD, 20));
        pickup_service.addActionListener(this);
        pickup_service.setBounds(30,470,225,30);
        add(pickup_service);

        // search room button
        search_room = new JButton("Search Room");
        search_room.setBackground(new Color(183,255,158));
        search_room.setForeground(Color.BLACK);
        search_room.setFont(new Font("serif", Font.BOLD, 20));
        search_room.addActionListener(this);
        search_room.setBounds(30,520,225,30);
        add(search_room);

        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == new_customer){

        }else if (ae.getSource() == room){

        }else if (ae.getSource() == department){

        }else if (ae.getSource() == all_employee){
            // all employee info dialog box
            new EmployeeInfo().setVisible(true);
        }else if (ae.getSource() == customer_info){

        }else if (ae.getSource() == check_out){

        }else if (ae.getSource() == update_check_status){

        }else if (ae.getSource() == update_room_status){

        }else if (ae.getSource() == pickup_service){

        }else if (ae.getSource() == search_room){

        }
    }

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }
}
