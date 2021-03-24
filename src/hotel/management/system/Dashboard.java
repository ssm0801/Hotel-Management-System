package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame{

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    public Dashboard(){

        setLayout(null);
        // maximise the dialog box
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JMenuBar menu_bar = new JMenuBar();
        setJMenuBar(menu_bar);

        JMenu menu1 = new JMenu("Hotel Management");
        menu_bar.add(menu1);
        JMenuItem item1 = new JMenuItem("Reception");
        menu1.add(item1);

        JMenu menu2 = new JMenu("Admin");
        menu_bar.add(menu2);
        JMenuItem item2 = new JMenuItem("Add Employee");
        menu2.add(item2);
        JMenuItem item3 = new JMenuItem("Add Room");
        menu2.add(item3);

        ImageIcon dashboard_image = new ImageIcon(ClassLoader.getSystemResource("images/dashboard.jpg"));
        Image img = dashboard_image.getImage().getScaledInstance(1540,860, Image.SCALE_DEFAULT);
        ImageIcon new_dashboard_image = new ImageIcon(img);
        JLabel dashboard_image_lable = new JLabel(new_dashboard_image);
        dashboard_image_lable.setBounds(0,0,1540,860);
        add(dashboard_image_lable);

        JLabel title = new JLabel("The SIZZLING welcomes you !!!");
        title.setBounds(475,100,1500,200);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("times new roman", Font.BOLD, 70));
        dashboard_image_lable.add(title);

        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

}
