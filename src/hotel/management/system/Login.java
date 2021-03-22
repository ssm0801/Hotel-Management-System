package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{

    Login(){
        // size and location of bounding box
        setBounds(500,130,500,600);

        // Inserted image and changed its dimension and gave location in dialog box
        ImageIcon login_image = new ImageIcon(ClassLoader.getSystemResource("images/login.jpeg"));
        Image img = login_image.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon new_login_image = new ImageIcon(img);
        JLabel login_image_label = new JLabel(new_login_image);
        login_image_label.setBounds(150,50,200,200);
        add(login_image_label);


        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Login login = new Login();
    }

}
