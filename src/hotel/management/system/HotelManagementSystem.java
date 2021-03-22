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


    }

    public static void main(String[] args) {
        HotelManagementSystem hotel1 = new HotelManagementSystem();
    }

}
