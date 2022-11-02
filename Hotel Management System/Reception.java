package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    
    JButton newCustomer, rooms, department, employee, Customers, managerInfo, checkout, update, roomStatus, pickup, searchRoom, Cancel;
    
    Reception() {
        setBounds(370,170,800,530);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,30,200,30);
        searchRoom.setFont(new Font("TAHOMA",Font.BOLD, 14));
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.white);
        searchRoom.addActionListener(this); 
        add(searchRoom);
        
        newCustomer = new JButton("New Customer");
        newCustomer.setBounds(10,70,200,30);
        newCustomer.setFont(new Font("TAHOMA",Font.BOLD, 14));
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10,110,200,30);
        checkout.setFont(new Font("TAHOMA",Font.BOLD, 14));
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this); 
        add(checkout);
        
        rooms = new JButton("Room Info");
        rooms.setBounds(10,150,200,30);
        rooms.setFont(new Font("TAHOMA",Font.BOLD, 14));
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);
        
        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10,190,200,30);
        managerInfo.setFont(new Font("TAHOMA",Font.BOLD, 14));
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.white);
        managerInfo.addActionListener(this);        
        add(managerInfo);  
        
        Customers = new JButton("Customer Info");
        Customers.setBounds(10,230,200,30);
        Customers.setFont(new Font("TAHOMA",Font.BOLD, 14));
        Customers.setBackground(Color.BLACK);
        Customers.setForeground(Color.white);
        Customers.addActionListener(this); 
        add(Customers);       

        employee = new JButton("Employees Info");
        employee.setBounds(10,270,200,30);
        employee.setFont(new Font("TAHOMA",Font.BOLD, 14));
        employee.setBackground(Color.BLACK);
        employee.setForeground(Color.white);
        employee.addActionListener(this);
        add(employee);
        
        department = new JButton("Department Info");
        department.setBounds(10,310,200,30);
        department.setFont(new Font("TAHOMA",Font.BOLD, 14));
        department.setBackground(Color.BLACK);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);
        
        update = new JButton("Update Status");
        update.setBounds(10,350,200,30);
        update.setFont(new Font("TAHOMA",Font.BOLD, 14));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10,390,200,30);
        roomStatus.setFont(new Font("TAHOMA",Font.BOLD, 14));
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.white);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10,430,200,30);
        pickup.setFont(new Font("TAHOMA",Font.BOLD, 14));
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);
                
        Cancel = new JButton("Cancel");
        Cancel.setBounds(10,470,200,30);
        Cancel.setFont(new Font("TAHOMA",Font.BOLD, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(this);
        add(Cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470); 
        add(image);
        
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();
        } else if (ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == checkout) {
            setVisible(false);
            new Checkout();
        } else if (ae.getSource() == rooms) {
            setVisible(false);
            new Room();
        } else if (ae.getSource() == managerInfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource() == Customers) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource() == employee) {
            setVisible(false);
            new EmployeeInfo();
        } else if (ae.getSource() == department) {
            setVisible(false);
            new Department();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateCheck();
        } else if (ae.getSource() == roomStatus) {
            setVisible(false);
            new UpdateRoom();
        }  else if (ae.getSource() == pickup) {
            setVisible(false);
            new Pickup();
        } else {
            setVisible(false);
            new Dashboard();
        }
    }
     
    public static void main(String args[]) {
        new Reception();
    }
}
