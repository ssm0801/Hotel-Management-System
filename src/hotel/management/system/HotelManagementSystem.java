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

    // all objects declared globally in class to use in methods
    ImageIcon main_image;
    JLabel main_image_lable, heading;
    JButton button;

    public HotelManagementSystem(){
        // size and location of bounding box
        setBounds(450,225,640,427);

        // image path and label
        main_image = new ImageIcon(ClassLoader.getSystemResource("images/hotel.jpg"));
        main_image_lable = new JLabel(main_image);

        // image size and location inside bounding box
        main_image_lable.setBounds(0,0,640,427);
        add(main_image_lable);

        // heading and its properties (bounds, foreground color, font)
        heading = new JLabel("Hotel Management System");
        heading.setBounds(120,0,400,70);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("times new roman", Font.ITALIC, 35));
        main_image_lable.add(heading);

        // Button and its properties (bounds, background color, foreground color, font)
        button = new JButton("CONTINUE");
        button.setBounds(243,300,150,50);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("times new roman", Font.BOLD, 20));
        button.addActionListener(this);
        main_image_lable.add(button);

        setLayout(null);
        setVisible(true);

        // heading blinker function
        while(true){
            heading.setVisible(false);

            // 1000 = 1 second
            try{ Thread.sleep(300); }
            catch (Exception e){ }

            heading.setVisible(true);

            try{ Thread.sleep(300); }
            catch (Exception e){ }
        }
    }

    // action function for continue button
    public void actionPerformed(ActionEvent action){
        new Login().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        HotelManagementSystem hotel = new HotelManagementSystem();
    }

}
