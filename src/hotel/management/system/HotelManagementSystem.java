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
        setBounds(450,225,640,427);
        setLayout(null);

        // image path and label
        ImageIcon main_image = new ImageIcon(ClassLoader.getSystemResource("images/hotel.jpg"));
        JLabel main_image_lable = new JLabel(main_image);
        main_image_lable.setBounds(0,0,640,427);
        add(main_image_lable);

        // heading and its properties (bounds, foreground color, font)
        JLabel heading = new JLabel("Hotel Management System");
        heading.setBounds(120,0,400,70);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("times new roman", Font.ITALIC, 35));
        main_image_lable.add(heading);

        // Button and its properties (bounds, background color, foreground color, font)
        JButton button = new JButton("CONTINUE");
        button.setBounds(243,300,150,50);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("times new roman", Font.BOLD, 20));
        button.addActionListener(this);
        main_image_lable.add(button);

        setVisible(true);
    }

    // action function for continue button
    public void actionPerformed(ActionEvent action){
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new HotelManagementSystem().setVisible(true);
    }
}
