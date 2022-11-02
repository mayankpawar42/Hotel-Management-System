package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField  tfroom, tfavailable, tfstatus;
    JButton check, update, cancel;
    
    UpdateRoom(){
        setBounds(300,180,940,400);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel heading = new JLabel("UPDATE ROOM STATUS");
        heading.setBounds(80,40,250,30);
        heading.setFont(new Font("TAHOMA",Font.BOLD, 20));
        add(heading);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,110,130,20);
        lblid.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(lblid);
                
        ccustomer = new Choice();
        ccustomer.setBounds(200,110,150,25);
        ccustomer.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(ccustomer);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(" select * from customer ");
            
            while(rs.next()) {
                ccustomer.add(rs.getString("number"));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,160,150,20);
        lblroom.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,160,150,25);
        tfroom.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfroom);
        
        JLabel lblname = new JLabel("Availability");
        lblname.setBounds(30,210,100,20);
        lblname.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(lblname);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(200,210,150,25);
        tfavailable.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfavailable); 
        
        JLabel lblcheckin = new JLabel("Checkin Status");
        lblcheckin.setBounds(30,260,150,20);
        lblcheckin.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(lblcheckin);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(200,260,150,25);
        tfstatus.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfstatus); 
        
        check = new JButton("Check");
        check.setBounds(30,320, 100, 30);
        check.setFont(new Font("Tahoma", Font.BOLD, 14));        
        check.setBackground(Color.blue);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(140,320, 100, 30);
        update.setFont(new Font("Tahoma", Font.BOLD, 15));
        update.setBackground(Color.red);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250,320, 100, 30);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updateRoom.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300); 
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            String query = " select * from customer where number = '"+id+"' ";
            
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                
                while(rs.next()) {
                    tfroom.setText(rs.getString("room"));
                }
                
                ResultSet rs2 = conn.s.executeQuery(" select * from room where roomnumber = '"+tfroom.getText()+"' ");
                
                while(rs2.next()) {
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == update) {
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();
            
            try {
                Conn conn = new Conn();
                conn.s.executeUpdate(" update room set availability = '"+available+"', cleaning_status = '"+status+"' where roomnumber = '"+room+"' ");
                
                JOptionPane.showMessageDialog(null, "Date Update Successfuly");
                
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String args[]) {
       new UpdateRoom();
    }
}