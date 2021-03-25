package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{

    public Dashboard(){

        setLayout(null);
        // maximise the dialog box
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // menu bar of dialog box
        JMenuBar menu_bar = new JMenuBar();
        setJMenuBar(menu_bar);

        // first menu
        JMenu menu1 = new JMenu("Hotel Management");
        menu_bar.add(menu1);
        // item of first menu
        JMenuItem item1 = new JMenuItem("Reception");
        // reception click event
        item1.addActionListener(this);
        menu1.add(item1);

        // second menu
        JMenu menu2 = new JMenu("Admin");
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

        // background image of dialog box
        ImageIcon dashboard_image = new ImageIcon(ClassLoader.getSystemResource("images/dashboard.jpg"));
        // resize image
        Image img = dashboard_image.getImage().getScaledInstance(1540,860, Image.SCALE_DEFAULT);
        ImageIcon new_dashboard_image = new ImageIcon(img);
        JLabel dashboard_image_lable = new JLabel(new_dashboard_image);
        dashboard_image_lable.setBounds(0,0,1540,860);
        add(dashboard_image_lable);

        // title on image
        JLabel title = new JLabel("The SIZZLING welcomes you !!!");
        title.setBounds(475,100,1500,200);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("times new roman", Font.BOLD, 70));
        dashboard_image_lable.add(title);

        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("Reception")){

        }else if (ae.getActionCommand().equals("Add Employee")){
            new AddEmployee().setVisible(true);
        }else if (ae.getActionCommand().equals("Add Room")){

        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }

}
