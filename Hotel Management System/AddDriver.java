package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    
    JButton add, cancel;
    JTextField tfname, tfage, tfcompany, tfmodel, tflocation;
    JComboBox availableCombo, genderCombo;
    
    AddDriver() {
        setBounds(300,190,940,430);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setBounds(150,10,200,50);
        heading.setFont(new Font("TAHOMA",Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel IbIroomno = new JLabel("Name");
        IbIroomno.setBounds(60,70,120,30);
        IbIroomno.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIroomno);

        tfname = new JTextField();
        tfname.setBounds(200,70,150,30);
        tfname.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(tfname);
        
        JLabel IbIage = new JLabel("Age");
        IbIage.setBounds(60,110,120,30);
        IbIage.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIage);

        tfage = new JTextField();
        tfage.setBounds(200,110,150,30);
        tfage.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(tfage);
        
        JLabel IbIclean = new JLabel("Gender");
        IbIclean.setBounds(60,150,150,30);
        IbIclean.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIclean);

        String cleanOptions[] = { "Male", "Female" };
        genderCombo = new JComboBox(cleanOptions);
        genderCombo.setBounds(200,150,150,30);
        genderCombo.setBackground(Color.white);
        genderCombo.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(genderCombo);
        
        JLabel IbIprice = new JLabel("Car Company");
        IbIprice.setBounds(60,190,120,30);
        IbIprice.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIprice);

        tfcompany = new JTextField();
        tfcompany.setBounds(200,190,150,30);
        tfcompany.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(tfcompany);
        
        JLabel IbItype = new JLabel("Car Model");
        IbItype.setBounds(60,230,150,30);
        IbItype.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbItype);

        tfmodel = new JTextField();
        tfmodel.setBounds(200,230,150,30);
        tfmodel.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(tfmodel);
        
        JLabel IbIavailabel = new JLabel("Availabel");
        IbIavailabel.setBounds(60,270,150,30);
        IbIavailabel.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIavailabel);
        
        String driverOptions[] = { "Availabel", "Busy" };
        availableCombo=new JComboBox(driverOptions);
        availableCombo.setBounds(200,270,150,30);
        availableCombo.setBackground(Color.white);
        availableCombo.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(availableCombo);
        
        JLabel IbIlocation = new JLabel("Location");
        IbIlocation.setBounds(60,310,120,30);
        IbIlocation.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIlocation);

        tflocation = new JTextField();
        tflocation.setBounds(200,310,150,30);
        tflocation.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(tflocation);
        
        add = new JButton("Add Driver");
        add.setBounds(60,370, 140, 30);
        add.setFont(new Font("Tahoma", Font.BOLD, 15));
        add.setBackground(Color.BLUE);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(210,370, 140, 30);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.white);        
        cancel.addActionListener(this);        
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/driver.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,70,500,300); 
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) genderCombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfmodel.getText();
            String available = (String) availableCombo.getSelectedItem();
            String location = tflocation.getText();
            
            try {
                Conn conn = new Conn();
                String str = " insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+brand+"', '"+available+"', '"+location+"')";
                conn.s.executeUpdate(str);
               
                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
                
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
                    
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String args[]) {
        new AddDriver();
    }
}
