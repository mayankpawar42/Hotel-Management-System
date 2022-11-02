package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname, tfage, tfsalary, tfphone, tfemail, tfaadhar;
    JRadioButton rbmale, rbfemale;
    JComboBox cbjob;
    JButton submit, cancel;
    
    AddEmployee() {
        setBounds(350,170,850,560);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD EMPLOYEE");
        heading.setBounds(120,20,250,30);
        heading.setFont(new Font("TAHOMA",Font.BOLD, 25));
        add(heading);
        
        JLabel IbIjob = new JLabel("Job");
        IbIjob.setBounds(60,80,120,30);
        IbIjob.setFont(new Font("TAHOMA",Font.BOLD, 17));
        add(IbIjob);
        
        String str[] = { "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant" };
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,80,180,30);
        cbjob.setBackground(Color.white);
        cbjob.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(cbjob);
        
        JLabel IbIage = new JLabel("Age");
        IbIage.setBounds(60,180,120,30);
        IbIage.setFont(new Font("TAHOMA",Font.BOLD, 17));
        add(IbIage);
        
        tfage = new JTextField();
        tfage.setBounds(200,180,180,30);
        tfage.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(tfage);
        
        JLabel IbIgender = new JLabel("Gender");
        IbIgender.setBounds(60,230,120,30);
        IbIgender.setFont(new Font("TAHOMA",Font.BOLD, 17));
        add(IbIgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,230,70,30);
        rbmale.setBackground(Color.white);
        rbmale.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300,230,100,30);
        rbfemale.setBackground(Color.white);
        rbfemale.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel IbIname = new JLabel("Name");
        IbIname.setBounds(60,130,120,30);
        IbIname.setFont(new Font("TAHOMA",Font.BOLD, 17));
        add(IbIname);
        
        tfname = new JTextField();
        tfname.setBounds(200,130,180,30);
        tfname.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(tfname);
        
        JLabel IbIsalary = new JLabel("Salary");
        IbIsalary.setBounds(60,280,120,30);
        IbIsalary.setFont(new Font("TAHOMA",Font.BOLD, 17));
        add(IbIsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200,280,180,30);
        tfsalary.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(tfsalary);
        
        JLabel IbIphone = new JLabel("Phone");
        IbIphone.setBounds(60,330,120,30);
        IbIphone.setFont(new Font("TAHOMA",Font.BOLD, 17));
        add(IbIphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200,330,180,30);
        tfphone.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(tfphone); 
        
        JLabel IbIemail = new JLabel("Email");
        IbIemail.setBounds(60,380,120,30);
        IbIemail.setFont(new Font("TAHOMA",Font.BOLD, 17));
        add(IbIemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,380,180,30);
        tfemail.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(tfemail);
        
        JLabel IbIaadhar = new JLabel("Aadhar");
        IbIaadhar.setBounds(60,430,120,30);
        IbIaadhar.setFont(new Font("TAHOMA",Font.BOLD, 17));
        add(IbIaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,430,180,30);
        tfaadhar.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        add(tfaadhar);
        
        submit = new JButton("Submit");
        submit.setBounds(60, 490, 150, 30);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
 
        cancel = new JButton("Cancel");
        cancel.setBounds(230, 490, 150, 30);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,120,450,370); 
        add(image);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource() == submit) {
            String name = tfname.getText();
            String age = tfage.getText();
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aadhar = tfaadhar.getText();
                
            String gender = null;
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name Should Not be Empty");
                
                if (rbmale.isSelected()) {
                    gender = "Male";
                }
            
            } else if (rbfemale.isSelected()) {
                gender = "Female";
            }
            
            String job = (String) cbjob.getSelectedItem();
            
            try {
                Conn conn = new Conn();
                String query = " insert into employee values('"+name+"' ,'"+age+"', '"+gender+"' ,'"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Employee added Successfully");
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            setVisible(false);
       
       } else {
           setVisible(false);
           new Dashboard();
       }
    }
    
    public static void main(String args[]) {
        new AddEmployee();
    }
}
