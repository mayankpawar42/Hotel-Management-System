package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    
    JTable table;
    JButton cancel, check;
    JComboBox bedType;
    JCheckBox available;
    
    SearchRoom() {
        setBounds(270,170,1000,600);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel heading = new JLabel("SEARCH FOR ROOM");
        heading.setBounds(400,20,200,30);
        heading.setForeground(Color.black);
        heading.setFont(new Font("TAHOMA",Font.BOLD, 20));
        add(heading);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(80,100,100,20);
        lblbed.setForeground(Color.DARK_GRAY);
        lblbed.setFont(new Font("TAHOMA",Font.BOLD, 13));
        add(lblbed);
        
        bedType = new JComboBox(new String[] { "Single Bed", "Double Bed" } );
        bedType.setBounds(160,100,150,20);
        bedType.setBackground(Color.WHITE);
        bedType.setFont(new Font("TAHOMA",Font.PLAIN, 14));
        add(bedType);
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(700,100,180,25);
        available.setBackground(Color.WHITE);
        available.setForeground(Color.DARK_GRAY);
        available.setFont(new Font("TAHOMA",Font.BOLD, 13));
        add(available);
        
        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(50,170,150,20);
        roomno.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(roomno);
        
        JLabel availibility = new JLabel("Availibility");
        availibility.setBounds(260,170,100,20);
        availibility.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(availibility);
        
        JLabel cleaningStatus = new JLabel("Cleaning Status");
        cleaningStatus.setBounds(450,170,150,20);
        cleaningStatus.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(cleaningStatus);
        
        JLabel price = new JLabel("Price");
        price.setBounds(670,170,100,20);
        price.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(price);
        
        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(850,170,100,20);
        bedType.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(bedType);
        
        table = new JTable();
        table.setBounds(0,200,1000,280);
        table.setFont(new Font("TAHOMA",Font.PLAIN, 13));
        add(table);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(" select * from room ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        check = new JButton("Check");
        check.setBounds(890,520, 100, 30);
        check.setFont(new Font("Tahoma", Font.BOLD, 15));
        check.setBackground(Color.blue);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
 
        cancel = new JButton("Cancel");
        cancel.setBounds(890,560, 100, 30);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            
            try {
                String query1 = " select * from room where bed_type = '"+bedType.getSelectedItem()+"' ";
                String query2 = " select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"' ";
                
                Conn conn = new Conn();
                
                ResultSet rs;
                if (available.isSelected()) {
                    rs = conn.s.executeQuery(query2);
                } else {
                    rs = conn.s.executeQuery(query1);
                }
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String args[]) {
        new SearchRoom();
    }
}
