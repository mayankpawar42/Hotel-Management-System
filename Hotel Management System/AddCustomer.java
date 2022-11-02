package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
    
    JComboBox comboid;
    JTextField tfnumber, tfname, tfcountry, tfdeposit;
    JRadioButton rmale, rfemale;
    Choice croom;
    JLabel checkingTime;
    JButton add, cancel;
    
    AddCustomer() {
        setBounds(410,200,730,470);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("TAHOMA",Font.BOLD, 21));
        add(text);
        
        JLabel IbIid = new JLabel("ID");
        IbIid.setBounds(35,240,100,20);
        IbIid.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIid);

        String options[] = { "Aadhar Card", "Passport", "Driving License", "Voter-Id Card", "Ration Card", "Pan Card" };
        comboid = new JComboBox(options);
        comboid.setBounds(200,240,150,25);
        comboid.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        comboid.setBackground(Color.white);
        add(comboid);
        
        JLabel IbInumber = new JLabel("Number");
        IbInumber.setBounds(35,280,150,20);
        IbInumber.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbInumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,280,150,25);
        tfnumber.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfnumber);
        
        JLabel IbIname = new JLabel("Name");
        IbIname.setBounds(35,160,70,20);
        IbIname.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        tfname.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfname);
        
        JLabel IbIgender = new JLabel("Gender");
        IbIgender.setBounds(35,200,100,20);
        IbIgender.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIgender);
        
        rmale= new JRadioButton("Male");
        rmale.setBounds(200,200,70,25);
        rmale.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        rmale.setBackground(Color.white);
        add(rmale);
        
        rfemale= new JRadioButton("Female");
        rfemale.setBounds(270,200,100,25);
        rfemale.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        rfemale.setBackground(Color.white);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel IbIcountry = new JLabel("Country");
        IbIcountry.setBounds(35,320,150,20);
        IbIcountry.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,320,150,25);
        tfcountry.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfcountry);
        
        JLabel IbIroom = new JLabel("Room Number");
        IbIroom.setBounds(35,120,150,20);
        IbIroom.setFont(new Font("TAHOMA",Font.BOLD, 15));
        add(IbIroom);
        
        croom = new Choice();
        
        try {
            Conn conn = new Conn();
            String query = " select * from room where availability = 'Available' ";
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        croom.setBounds(200,120,150,25);
        croom.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(croom);
        
        JLabel IbItime = new JLabel("Checking Time");
        IbItime.setBounds(35,80,150,20);
        IbItime.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbItime);
        
        Date date = new Date();
        
        checkingTime = new JLabel("" + date);
        checkingTime.setBounds(200,80,150,25);
        checkingTime.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(checkingTime);
        
        JLabel IbIdeposit = new JLabel("Deposit");
        IbIdeposit.setBounds(35,360,150,20);
        IbIdeposit.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIdeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        tfdeposit.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfdeposit);
        
        add = new JButton("Add");
        add.setBounds(35,410, 150, 30);
        add.setFont(new Font("Tahoma", Font.BOLD, 15));
        add.setBackground(Color.blue);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 410, 150, 30);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/customer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,420, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,20,300,420); 
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            
            String gender = null;
            
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name Should Not be Empty");
                
                if (rmale.isSelected()) {
                    gender = "Male";
                }
            } else if (rfemale.isSelected()) {
                gender = "Female";
            }

            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkingTime.getText();
            String deposit = tfdeposit.getText();
            
            try {
                String query = " insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+time+"', '"+deposit+"')";
                String query2 = " update room set availability = 'Occupied' where roomnumber = '"+room+"' ";
                
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                
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
        new AddCustomer();
    }
}
