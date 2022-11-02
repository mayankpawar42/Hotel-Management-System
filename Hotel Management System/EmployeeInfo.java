package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;
    
    EmployeeInfo() {
        setBounds(280,180,1000,600);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40,10,100,20);
        name.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(name);
        
        JLabel age = new JLabel("Age");
        age.setBounds(170,10,100,20);
        age.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(age);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(280,10,100,20);
        gender.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(gender);
        
        JLabel job = new JLabel("Job");
        job.setBounds(410,10,100,20);
        job.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(job);
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(540,10,100,20);
        salary.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(salary);
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(660,10,100,20);
        phone.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(phone);
        
        JLabel email = new JLabel("Email");
        email.setBounds(780,10,100,20);
        email.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(email);
        
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(900,10,100,20);
        aadhar.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(aadhar);
        
        table = new JTable();
        table.setBounds(0,40,1000,400);
        table.setFont(new Font("TAHOMA",Font.PLAIN, 13));
        add(table);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(" select * from employee ");
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
        new EmployeeInfo();
    }
}
