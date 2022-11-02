package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField  tfroom, tfname, tfcheckin, tfpaid, tfpending;
    JButton check, update, cancel;
    
    UpdateCheck() {
        setBounds(300,200,930,400);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel heading = new JLabel("UPDATE STATUS");
        heading.setBounds(110,20,200,30);
        heading.setFont(new Font("TAHOMA",Font.BOLD, 20));
        add(heading);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,130,20);
        lblid.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(lblid);
                
        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,20);
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
        lblroom.setBounds(30,120,150,20);
        lblroom.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,120,150,25);
        tfroom.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfroom);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,160,100,20);
        lblname.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        tfname.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfname); 
        
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,200,150,20);
        lblcheckin.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(lblcheckin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        tfcheckin.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfcheckin); 
        
        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setBounds(30,240,150,20);
        lblpaid.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(200,240,150,25);
        tfpaid.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfpaid);
        
        JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setBounds(30,280,150,20);
        lblpending.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(lblpending);
        
        tfpending = new JTextField();
        tfpending.setBounds(200,280,150,25);
        tfpending.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfpending);
        
        check = new JButton("Check");
        check.setBounds(30,340, 100, 30);
        check.setFont(new Font("Tahoma", Font.BOLD, 15));
        check.setBackground(Color.blue);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(140,340, 100, 30);
        update.setFont(new Font("Tahoma", Font.BOLD, 15));
        update.setBackground(Color.red);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250,340, 100, 30);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updateCheck.jpg"));
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
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                }
                
                ResultSet rs2 = conn.s.executeQuery(" select * from room where roomnumber = '"+tfroom.getText()+"' ");
                
                while(rs2.next()) {
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText(" "+ amountPaid);
                }
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == update) {
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();
            
            try {
                Conn conn = new Conn();
                conn.s.executeUpdate(" update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"' where number = '"+number+"' ");
                
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
       new UpdateCheck();
    }
}
