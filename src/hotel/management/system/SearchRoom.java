package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    JButton check, back;

    SearchRoom(){
        // size and location of bounding box
        setBounds(520,50,500,700);



        // check button
        check = new JButton("CHECK");
        check.setForeground(Color.WHITE);
        check.setBackground(new Color(66,34,130));
        check.setFont(new Font("times new roman", Font.PLAIN, 20));
        check.addActionListener(this);
        check.setBounds(110,400,115,30);
        add(check);

        // back  button
        back = new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(66,34,130));
        back.setFont(new Font("times new roman", Font.PLAIN, 20));
        back.addActionListener(this);
        back.setBounds(250,400,115,30);
        add(back);

        getContentPane().setBackground(new Color(32,32,32));

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check){

        }else if (ae.getSource() == back){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }
}
