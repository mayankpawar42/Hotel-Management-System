package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    Dashboard() {
        setBounds(0,0,1550,1000);
        setUndecorated(true);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);  
        add(image); 
        
        JLabel text = new JLabel("THE TAJ GROUP WELCOME YOU"); 
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma", Font.BOLD, 46));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTAL MANAGEMENT");
        hotel.setForeground(Color.red);
        hotel.setFont(new Font("Tahoma", Font.BOLD, 15));
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setFont(new Font("Tahoma", Font.BOLD, 15));
        admin.setForeground(Color.blue);
        mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrives = new JMenuItem("ADD DRIVERS");
        adddrives.addActionListener(this);
        admin.add(adddrives);
        
        JMenu exit = new JMenu("EXIT");
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Tahoma", Font.BOLD, 15));
        mb.add(exit);
        
        JMenuItem Exit = new JMenuItem("Exit");
        Exit.addActionListener(this);
        exit.add(Exit);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }else if (ae.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms();
        } else if (ae.getActionCommand().equals("ADD DRIVERS")) {
            new AddDriver();
        } else if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String args[]) {
        new Dashboard();
    }
}
