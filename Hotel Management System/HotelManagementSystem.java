package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JButton start, exit;
            
    HotelManagementSystem() {
        setBounds(100,100,1366,565);
        setUndecorated(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/intro.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);   
        add(image);  
        
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(770,40,1000,90);
        text.setFont(new Font("serif",Font.BOLD, 40));
        text.setForeground(Color.white);
        image.add(text);
        
        start = new JButton("Start");
        start.setBounds(880, 470, 120, 40);
        start.setFont(new Font("Tahoma",Font.BOLD, 20));
        start.setBackground(Color.orange);
        start.setForeground(Color.black);
        start.addActionListener(this);
        image.add(start);
        
        exit = new JButton("Exit");
        exit.setBounds(1010, 470, 120, 40);
        exit.setFont(new Font("Tahoma",Font.BOLD, 20));
        exit.setBackground(Color.orange);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        image.add(exit);
        
        setVisible(true);
        
        while(true) {
            text.setVisible(false);
            
            try {
                Thread.sleep(900);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            text.setVisible(true);
            
            try {
                Thread.sleep(900);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Login();
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
