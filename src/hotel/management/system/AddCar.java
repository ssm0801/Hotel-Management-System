package hotel.management.system;

import com.placeholder.PlaceHolder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCar extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JTextField company_field, model_field, car_no_field, color_field, price_field;
    ButtonGroup fuel_type_group;

    AddCar(){
        // size and location of bounding box
        setBounds(375,175,800,500);
        // placeholder object
        PlaceHolder holder;

        // heading and its properties
        JLabel heading = new JLabel("ADD CAR");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(300,10,300,35);
        add(heading);

        // car image resized and added
        ImageIcon car_image = new ImageIcon(ClassLoader.getSystemResource("images/car.jpg"));
        Image img = car_image.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
        ImageIcon new_car_image = new ImageIcon(img);
        JLabel car_image_label = new JLabel(new_car_image);
        car_image_label.setBounds(300,70,400,300);
        add(car_image_label);

        // company label
        JLabel company_label = new JLabel("Company : ");
        company_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        company_label.setForeground(Color.WHITE);
        company_label.setBounds(50,70,100,20);
        add(company_label);

        // company field
        company_field = new JTextField();
        company_field.setBounds(140,70,100,20);
        add(company_field);
        // name place holder
        holder = new PlaceHolder(company_field,"company name");

        // model label
        JLabel model_label = new JLabel("Model : ");
        model_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        model_label.setForeground(Color.WHITE);
        model_label.setBounds(50,110,100,20);
        add(model_label);

        // model field
        model_field = new JTextField();
        model_field.setBounds(140,110,100,20);
        add(model_field);
        // name place holder
        holder = new PlaceHolder(model_field,"model name");

        // car number label
        JLabel car_no_label = new JLabel("Number : ");
        car_no_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        car_no_label.setForeground(Color.WHITE);
        car_no_label.setBounds(50,150,100,20);
        add(car_no_label);

        // car number field
        car_no_field = new JTextField();
        car_no_field.setBounds(140,150,100,20);
        add(car_no_field);
        // name place holder
        holder = new PlaceHolder(car_no_field,"car number");

        // fuel type label
        JLabel fuel_type_label = new JLabel("Fuel : ");
        fuel_type_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        fuel_type_label.setForeground(Color.WHITE);
        fuel_type_label.setBounds(50,190,100,20);
        add(fuel_type_label);

        // petrol cars
        JRadioButton petrol = new JRadioButton("Petrol");
        petrol.setActionCommand("petrol");
        petrol.setFont(new Font("Tahoma",Font.PLAIN,14));
        petrol.setBackground(new Color(32,32,32));
        petrol.setForeground(Color.WHITE);
        petrol.setBounds(140,190,80,20);
        add(petrol);

        // diesel cars
        JRadioButton diesel = new JRadioButton("Diesel");
        diesel.setActionCommand("diesel");
        diesel.setFont(new Font("Tahoma",Font.PLAIN,14));
        diesel.setBackground(new Color(32,32,32));
        diesel.setForeground(Color.WHITE);
        diesel.setBounds(140,220,80,20);
        add(diesel);

        // electric cars
        JRadioButton electric = new JRadioButton("Electric");
        electric.setActionCommand("electric");
        electric.setFont(new Font("Tahoma",Font.PLAIN,14));
        electric.setBackground(new Color(32,32,32));
        electric.setForeground(Color.WHITE);
        electric.setBounds(140,250,80,20);
        add(electric);

        // fuel type radio buttons grouped
        fuel_type_group = new ButtonGroup();
        fuel_type_group.add(petrol);
        fuel_type_group.add(diesel);
        fuel_type_group.add(electric);

        // color label
        JLabel color_label = new JLabel("Color : ");
        color_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        color_label.setForeground(Color.WHITE);
        color_label.setBounds(50,290,100,20);
        add(color_label);

        // color field
        color_field = new JTextField();
        color_field.setBounds(140,290,100,20);
        add(color_field);
        // name place holder
        holder = new PlaceHolder(color_field,"color");

        // price label
        JLabel price_label = new JLabel("Price : ");
        price_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        price_label.setForeground(Color.WHITE);
        price_label.setBounds(50,330,100,20);
        add(price_label);

        // price field
        price_field = new JTextField();
        price_field.setBounds(140,330,100,20);
        add(price_field);
        // name place holder
        holder = new PlaceHolder(price_field,"price");

        // submit button
        JButton submit = new JButton("SUBMIT");
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(66,34,130));
        submit.setFont(new Font("times new roman", Font.PLAIN, 20));
        submit.addActionListener(this);
        submit.setBounds(325,400,115,30);
        add(submit);

        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // all info took in separate variable
        String company = company_field.getText();
        String model = model_field.getText();
        String number = car_no_field.getText();
        String fuel = fuel_type_group.getSelection().getActionCommand();
        String color = color_field.getText();
        String price = price_field.getText();

        // database connection object
        DatabaseConnection connect = new DatabaseConnection();
        // database query
        String query = "INSERT INTO car values( '"+company+"', '"+model+"', '"+number+"','"+fuel+"','"+color+"', '"+price+"')";

        try {
            // Execute the query
            connect.statement.executeUpdate(query);
            String message = "New Car "+company+" - "+model+" Added !!!";
            // popup message
            JOptionPane.showMessageDialog(null, message);
            this.setVisible(false);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new AddCar().setVisible(true);
    }
}
