package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener {
    
    JTable table;
    JButton check, cancel;
    Choice typeofcar;
    JCheckBox available;
    
    Pickup(){
        setBounds(270,170,1000,600);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel heading = new JLabel("PICKUP SERVICE");
        heading.setBounds(400,20,200,30);
        heading.setFont(new Font("TAHOMA",Font.BOLD, 20));
        add(heading);
        
        JLabel lblbed = new JLabel("Type of Car");
        lblbed.setBounds(50,100,100,25);
        lblbed.setFont(new Font("TAHOMA",Font.BOLD, 15));
        lblbed.setForeground(Color.DARK_GRAY);
        add(lblbed);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150,103,150,25);
        typeofcar.setFont(new Font("TAHOMA",Font.PLAIN, 13));
        add(typeofcar);
        
        try {
            Conn conn = new Conn();
            ResultSet rs=conn.s.executeQuery(" select * from driver ");
            
            while(rs.next()) {
                typeofcar.add(rs.getString("brand"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(700,100,180,25);
        available.setBackground(Color.WHITE);
        available.setForeground(Color.DARK_GRAY);
        available.setFont(new Font("TAHOMA",Font.BOLD, 13));
        add(available);
        
        JLabel name = new JLabel("Name");
        name.setBounds(50,170,100,20);
        name.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(name);
        
        JLabel age = new JLabel("Age");
        age.setBounds(200,170,100,20);
        age.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(age);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(330,170,100,20);
        gender.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(gender);
        
        JLabel company = new JLabel("Company");
        company.setBounds(460,170,100,20);
        company.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(company);
        
        JLabel brand = new JLabel("Brand");
        brand.setBounds(610,170,100,20);
        brand.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(brand);
        
        JLabel available = new JLabel("Available");
        available.setBounds(750,170,100,20);
        available.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(available);
        
        JLabel location = new JLabel("Location");
        location.setBounds(890,170,100,20);
        location.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(location);
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        table.setFont(new Font("TAHOMA",Font.PLAIN, 13));
        add(table);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
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
                String query1 = " select * from driver where brand = '"+typeofcar.getSelectedItem()+"' ";
                String query2 = " select * from driver where available = 'Availabel' AND brand = '"+typeofcar.getSelectedItem()+"' ";

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
        new Pickup();
    }
}
