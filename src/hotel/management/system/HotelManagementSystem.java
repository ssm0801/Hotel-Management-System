/*
==================================================
DOCUMENTATION
-------------
Author          = Sudhanshu Motewar, Sukhada Takle
Starting Date   = 22/03/21
Completion Date =
==================================================
*/
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    public HotelManagementSystem(){

        // size and location of bounding box
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // image path and label
        ImageIcon main_image = new ImageIcon(ClassLoader.getSystemResource("images/hotel.jpg"));
        Image img = main_image.getImage().getScaledInstance(1550,1050, Image.SCALE_DEFAULT);
        ImageIcon new_main_image = new ImageIcon(img);
        JLabel main_image_lable = new JLabel(new_main_image);
        main_image_lable.setBounds(0,0,1550,1050);
        add(main_image_lable);

        // heading and its properties (bounds, foreground color, font)
        JLabel heading = new JLabel("Hotel Management System");
        heading.setForeground(new Color(0,0,204));
        heading.setBounds(425,30,1000,100);
        heading.setFont(new Font("times new roman", Font.ITALIC, 70));
        main_image_lable.add(heading);

        // Button and its properties (bounds, background color, foreground color, font)
        JButton button = new JButton("Continue");
        button.setBounds(700,750,150,50);
        button.setBackground(new Color(66,34,130));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("times new roman", Font.PLAIN, 20));
        button.addActionListener(this);
        main_image_lable.add(button);

        // stop program after exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);
        setVisible(true);
    }

    // action function for continue button
    public void actionPerformed(ActionEvent action){
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
