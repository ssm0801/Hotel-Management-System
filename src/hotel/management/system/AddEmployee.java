package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.placeholder.PlaceHolder;

public class AddEmployee extends JFrame implements ActionListener {

    // declared objects globally which are needed outside of constructor
    JTextField name_field, age_field, salary_field, phone_field, aadhar_field, email_field;
    ButtonGroup gender_group;
    JComboBox job_combobox;

    AddEmployee(){

        // size and location of bounding box
        setBounds(375,140,800,550);
        // placeholder object
        PlaceHolder holder;

        // heading and its properties
        JLabel heading = new JLabel("ADD EMPLOYEE");
        heading.setForeground(new Color(204,246,221));
        heading.setFont(new Font("monospaced",Font.BOLD, 40));
        heading.setBounds(250,10,300,35);
        add(heading);

        // employee image resized and added
        ImageIcon employee_image = new ImageIcon(ClassLoader.getSystemResource("images/employee.jpg"));
        Image img = employee_image.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
        ImageIcon new_employee_image = new ImageIcon(img);
        JLabel employee_image_label = new JLabel(new_employee_image);
        employee_image_label.setBounds(355,100,400,300);
        add(employee_image_label);

        // name label
        JLabel name_label = new JLabel("Name : ");
        name_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        name_label.setForeground(Color.WHITE);
        name_label.setBounds(50,70,60,20);
        add(name_label);

        // name field
        name_field = new JTextField();
        name_field.setBounds(125,70,200,20);
        add(name_field);
        // name place holder
        holder = new PlaceHolder(name_field,"full name");

        // age label
        JLabel age_label = new JLabel("Age : ");
        age_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        age_label.setForeground(Color.WHITE);
        age_label.setBounds(50,110,60,20);
        add(age_label);

        // age field
        age_field = new JTextField();
        age_field.setBounds(125,110,200,20);
        add(age_field);

        // gender label
        JLabel gender_label = new JLabel("Gender : ");
        gender_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        gender_label.setForeground(Color.WHITE);
        gender_label.setBounds(50,150,80,20);
        add(gender_label);

        // gender radio buttons
        JRadioButton male = new JRadioButton("Male");
        male.setActionCommand("male");
        male.setFont(new Font("Tahoma",Font.PLAIN,14));
        male.setBackground(new Color(32,32,32));
        male.setForeground(Color.WHITE);
        male.setBounds(125,150,70,20);
        add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setActionCommand("female");
        female.setFont(new Font("Tahoma",Font.PLAIN,14));
        female.setBackground(new Color(32,32,32));
        female.setForeground(Color.WHITE);
        female.setBounds(125,180,80,20);
        add(female);

        JRadioButton other = new JRadioButton("Other");
        other.setActionCommand("other");
        other.setFont(new Font("Tahoma",Font.PLAIN,14));
        other.setBackground(new Color(32,32,32));
        other.setForeground(Color.WHITE);
        other.setBounds(125,210,80,20);
        add(other);

        // gender radio buttons grouped
        gender_group = new ButtonGroup();
        gender_group.add(male);
        gender_group.add(female);
        gender_group.add(other);

        // job label
        JLabel job_label = new JLabel("Job : ");
        job_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        job_label.setForeground(Color.WHITE);
        job_label.setBounds(50,250,70,20);
        add(job_label);

        // https://www.revfine.com/hotel-positions/
        // job list and combobox
        String jobs[] = {"Restaurant Manager", "Kitchen staff", "Head Chef", "Room Service", "Hotel Porter", "Front Desk Employee", "Waiter/Waitress", "Driver", "Housekeeping"};
        job_combobox = new JComboBox(jobs);
        String job = (String)job_combobox.getSelectedItem();
        job_combobox.setBackground(Color.WHITE);
        job_combobox.setBounds(125,250,200,20);
        add(job_combobox);

        // salary label
        JLabel salary_label = new JLabel("Salary : ");
        salary_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        salary_label.setForeground(Color.WHITE);
        salary_label.setBounds(50,290,70,20);
        add(salary_label);

        // salary field
        salary_field = new JTextField();
        salary_field.setBounds(125,290,200,20);
        add(salary_field);

        // phone label
        JLabel phone_label = new JLabel("Phone : ");
        phone_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        phone_label.setForeground(Color.WHITE);
        phone_label.setBounds(50,330,70,20);
        add(phone_label);

        // phone field
        phone_field = new JTextField();
        phone_field.setBounds(125,330,200,20);
        add(phone_field);
        // phone placeholder
        holder = new PlaceHolder(phone_field,"+91xxxxxxxxxx");

        // aadhar label
        JLabel aadhar_label = new JLabel("Aadhar : ");
        aadhar_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        aadhar_label.setForeground(Color.WHITE);
        aadhar_label.setBounds(50,370,80,20);
        add(aadhar_label);

        // aadhar field
        aadhar_field = new JTextField();
        aadhar_field.setBounds(125,370,200,20);
        add(aadhar_field);
        // aadhar placeholder
        holder = new PlaceHolder(aadhar_field,"xxxx-xxxx-xxxx");

        // email label
        JLabel email_label = new JLabel("Email : ");
        email_label.setFont(new Font("Tahoma",Font.PLAIN, 15));
        email_label.setForeground(Color.WHITE);
        email_label.setBounds(50,410,70,20);
        add(email_label);

        // email field
        email_field = new JTextField();
        email_field.setBounds(125,410,200,20);
        add(email_field);

        // submit button
        JButton submit = new JButton("SUBMIT");
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(66,34,130));
        submit.setFont(new Font("times new roman", Font.PLAIN, 20));
        submit.addActionListener(this);
        submit.setBounds(325,455,115,30);
        add(submit);

        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        // all info took in separate variable
        String name = name_field.getText();
        String age = age_field.getText();
        String gender = gender_group.getSelection().getActionCommand();
        String job = (String)job_combobox.getSelectedItem();
        String salary = salary_field.getText();
        String phone = phone_field.getText();
        String aadhar = aadhar_field.getText();
        String email = email_field.getText();

        // database connection object
        DatabaseConnection connect = new DatabaseConnection();
        // database query
        String query = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+aadhar+"', '"+email+"')";
        try {
            // Execute the query
            connect.statement.executeUpdate(query);
            String message = "New Employee "+name+" Added !!!";
            // popup message
            JOptionPane.showMessageDialog(null, message);
            this.setVisible(false);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }
}
