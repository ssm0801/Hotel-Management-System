package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{

    public Dashboard(){

        // maximise the dialog box
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // menu bar of dialog box
        JMenuBar menu_bar = new JMenuBar();
        menu_bar.setBackground(new Color(23,32,42));
        UIManager.put("Menu.font", new Font("Verdana", Font.BOLD, 15));
        setJMenuBar(menu_bar);

        // first menu
        JMenu menu1 = new JMenu("Hotel Management");
        menu1.setForeground(new Color(171,235,198));
        menu_bar.add(menu1);
        // item of first menu
        JMenuItem item1 = new JMenuItem("Reception");
        // reception click event
        item1.addActionListener(this);
        menu1.add(item1);

        // second menu
        JMenu menu2 = new JMenu("Admin");
        menu2.setForeground(new Color(246,221,204));
        menu_bar.add(menu2);
        // items of second menu
        JMenuItem item2 = new JMenuItem("Add Employee");
        menu2.add(item2);
        // add employee click event
        item2.addActionListener(this);
        JMenuItem item3 = new JMenuItem("Add Room");
        // add room click event
        item3.addActionListener(this);
        menu2.add(item3);
        JMenuItem item4 = new JMenuItem("Add Car");
        // add car click event
        item4.addActionListener(this);
        menu2.add(item4);

        // log out button
        JButton logout_button = new JButton("Log Out");
        logout_button.setForeground(Color.BLACK);
        logout_button.setBackground(new Color(255,0,0));
        logout_button.addActionListener(this);
        logout_button.setFont(new Font("verdana", Font.BOLD, 15));
        menu_bar.add(logout_button);

        // background image of dialog box
        ImageIcon dashboard_image = new ImageIcon(ClassLoader.getSystemResource("images/dashboard.jpg"));
        // resize image
        Image img = dashboard_image.getImage().getScaledInstance(1550,820, Image.SCALE_DEFAULT);
        ImageIcon new_dashboard_image = new ImageIcon(img);
        JLabel dashboard_image_lable = new JLabel(new_dashboard_image);
        dashboard_image_lable.setBounds(0,0,1550,820);
        add(dashboard_image_lable);

        // title on image
        JLabel title = new JLabel("The SIZZLING welcomes you !!!");
        title.setBounds(300,50,1500,200);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("times new roman", Font.BOLD, 70));
        dashboard_image_lable.add(title);

        // exit program on closing dialog box
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // dialog box background color
        getContentPane().setBackground(new Color(23,32,42));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("Reception")){
            // reception dialog box
            new Reception().setVisible(true);
        }else if (ae.getActionCommand().equals("Add Employee")){
            // add employee dialog box
            new AddEmployee().setVisible(true);
        }else if (ae.getActionCommand().equals("Add Room")) {
            // add room dialog box
            new AddRooms().setVisible(true);
        }else if (ae.getActionCommand().equals("Add Car")){
            // add car dialog box
            new AddCar().setVisible(true);
        } else if (ae.getActionCommand().equals("Log Out")){
            // logout dashboard
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }

}
