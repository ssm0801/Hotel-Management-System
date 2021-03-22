package hotel.management.system;
import javax.swing.*;
import java.awt.*;

public class HotelManagementSystem extends JFrame {

    HotelManagementSystem(){

        // size and location of bounding box
        setBounds(450,225,640,427);

        // image path and label
        ImageIcon main_image = new ImageIcon(ClassLoader.getSystemResource("images/hotel1.jpg"));
        JLabel main_image_lable = new JLabel(main_image);

        // image size and location inside bounding box
        main_image_lable.setBounds(0,0,640,427);
        add(main_image_lable);

        // heading and its properties
        JLabel heading = new JLabel("Hotel Management System");
        heading.setBounds(120,0,400,70);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("times new roman", Font.ITALIC, 35));
        main_image_lable.add(heading);

        setLayout(null);
        setVisible(true);



    }

    public static void main(String[] args) {
        HotelManagementSystem hotel1 = new HotelManagementSystem();
    }

}
