package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    
    Login() {
        setBounds(500,200,600,270);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setLayout(null);
        
        JLabel user = new JLabel("Username"); 
        user.setBounds(70,80,100,30);
        user.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(user);
        
        username = new JTextField();
        username.setBounds(180,80,150,30);
        username.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(username);
        
        JLabel pass = new JLabel("Password"); 
        pass.setBounds(70,130,100,30);
        pass.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(180,130,150,30);
        password.setFont(new Font("Tahoma", Font.PLAIN, 19));
        add(password);
        
        login = new JButton("Login");
        login.setBounds(70, 200, 120, 30);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        login.setBackground(Color.BLUE);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(210, 200, 120, 30);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);  
        add(image); 
        
        setVisible(true);
    }
     
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();
            
            try {
                Conn c = new Conn();
                String query = " select * from login where username = '"+ user +"' and password = '"+ pass +"' ";
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
