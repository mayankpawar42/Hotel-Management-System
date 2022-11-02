package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;
    
    CustomerInfo(){
        setBounds(280,170,1000,600);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(5,10,150,20);
        l1.setFont(new Font("TAHOMA",Font.BOLD, 13));
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(160,10,100,20);
        l2.setFont(new Font("TAHOMA",Font.BOLD, 13));
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(280,10,100,20);
        l3.setFont(new Font("TAHOMA",Font.BOLD, 13));
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(410,10,100,20);
        l4.setFont(new Font("TAHOMA",Font.BOLD, 13));
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(520,10,100,20);
        l5.setFont(new Font("TAHOMA",Font.BOLD, 13));
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(630,10,150,20);
        l6.setFont(new Font("TAHOMA",Font.BOLD, 13));
        add(l6);
        
        JLabel l7 = new JLabel("Checkin Time");
        l7.setBounds(770,10,190,20);
        l7.setFont(new Font("TAHOMA",Font.BOLD, 13));
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(900,10,100,20);
        l8.setFont(new Font("TAHOMA",Font.BOLD, 13));
        add(l8);
        
        table = new JTable();
        table.setBounds(0,40,1000,400);
        table.setFont(new Font("TAHOMA",Font.PLAIN, 12));
        add(table);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(" select * from customer ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(890,560, 100, 30);
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
        new CustomerInfo();
    }
}

