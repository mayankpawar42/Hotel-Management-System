package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;
    JButton checkout, cancel;
    
    Checkout() {
        setBounds(370,200,800,350);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel heading = new JLabel("CHECKOUT");
        heading.setBounds(110,20,150,30);
        heading.setFont(new Font("TAHOMA",Font.BOLD, 20));
        add(heading);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,24);
        lblid.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(170,80,150,25);
        ccustomer.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(ccustomer);
                
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,150,30);
        lblroom.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(lblroom);
        
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(170,130,100,30);
        lblroomnumber.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(lblroomnumber);
        
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,150,30);
        lblcheckin.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(lblcheckin);
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(170,180,100,30);
        lblcheckintime.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(lblcheckintime);
        
        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,150,30);
        lblcheckout.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(lblcheckout);
        
        Date date = new Date();
        lblcheckouttime = new JLabel(""+ date);
        lblcheckouttime.setBounds(170,230,150,30);
        lblcheckouttime.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(lblcheckouttime);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(30,280, 140, 30);
        checkout.setFont(new Font("Tahoma", Font.BOLD, 15));
        checkout.setBackground(Color.BLUE);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,280, 140, 30);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(" select * from customer ");
            
            while(rs.next()) {
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(370,50,400,250); 
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkout) {
            String query1 = " delete from customer where number = '"+ccustomer.getSelectedItem()+"' ";
            String query2 = " update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"' ";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                        
                JOptionPane.showMessageDialog(null, "Checkout Done");
                
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
        new Checkout();
    }
}
