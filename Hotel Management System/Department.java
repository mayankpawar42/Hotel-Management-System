package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;
    
    Department() {
        setBounds(425,200,700,480);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel department = new JLabel("Department");
        department.setBounds(150,10,150,20);
        department.setFont(new Font("TAHOMA",Font.BOLD, 17));
        add(department);
        
        JLabel budget = new JLabel("Budget");
        budget.setBounds(500,10,100,20);
        budget.setFont(new Font("TAHOMA",Font.BOLD, 17));
        add(budget);
                
        table = new JTable();
        table.setBounds(0,40,700,350);
        table.setFont(new Font("TAHOMA",Font.PLAIN, 13));
        add(table);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(" select * from department ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(590,440,100, 30);
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
        new Department();
    }
}

