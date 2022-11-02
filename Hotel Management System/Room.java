package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;
    
    Room() {
        setBounds(260,160,1050,600);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600); 
        add(image);
                
        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(10,10,100,20);
        roomno.setFont(new Font("TAHOMA",Font.BOLD, 12));
        add(roomno);
        
        JLabel availibility = new JLabel("Availibility");
        availibility.setBounds(120,10,100,20);
        availibility.setFont(new Font("TAHOMA",Font.BOLD, 12));
        add(availibility);
        
        JLabel status = new JLabel("Status");
        status.setBounds(230,10,100,20);
        status.setFont(new Font("TAHOMA",Font.BOLD, 12));
        add(status);
        
        JLabel price = new JLabel("Price");
        price.setBounds(330,10,100,20);
        price.setFont(new Font("TAHOMA",Font.BOLD, 12));
        add(price);
        
        JLabel bedtype = new JLabel("Bed Type");
        bedtype.setBounds(410,10,100,20);
        bedtype.setFont(new Font("TAHOMA",Font.BOLD, 12));
        add(bedtype);
        
        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(" select * from room ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(390,560, 100, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    
    public static void main(String args[]) {
        new Room();
    }
}
