package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    
    JTextField tfroom, tfprice;
    JComboBox availableCombo, cleanCombo, typeCombo;
    JButton add, cancel;
    
    AddRooms() {
        setBounds(310,200,950,410);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(150,20,200,20);
        heading.setFont(new Font("TAHOMA",Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel IbIroomno = new JLabel("Add Rooms");
        IbIroomno.setBounds(60,80,120,30);
        IbIroomno.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        tfroom.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfroom);
        
        JLabel IbIprice = new JLabel("Price");
        IbIprice.setBounds(60,130,120,30);
        IbIprice.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIprice);

        tfprice = new JTextField();
        tfprice.setBounds(200,130,150,30);
        tfprice.setFont(new Font("TAHOMA",Font.PLAIN, 15));
        add(tfprice);
        
        JLabel IbIclean = new JLabel("Cleaning Status");
        IbIclean.setBounds(60,280,150,30);
        IbIclean.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIclean);

        String cleanOptions[] = { "Cleaned", "Dirty "};
        cleanCombo = new JComboBox(cleanOptions);
        cleanCombo.setBounds(200,280,150,30);
        cleanCombo.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        cleanCombo.setBackground(Color.white);
        add(cleanCombo);
        
        JLabel IbIavailabel = new JLabel ("Availabel");
        IbIavailabel.setBounds(60,230,120,30);
        IbIavailabel.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbIavailabel);

        String availabelOptions[] = { "Available", "Occupied" };
        availableCombo = new JComboBox(availabelOptions);
        availableCombo.setBounds(200,230,150,30);
        availableCombo.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        availableCombo.setBackground(Color.white);
        add(availableCombo);
        
        JLabel IbItype = new JLabel ("Bad Type");
        IbItype.setBounds(60,180,150,30);
        IbItype.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(IbItype);

        String typeOptions[] = { "Single Bed", "Double Bed" };
        typeCombo = new JComboBox(typeOptions);
        typeCombo.setBounds(200,180,150,30);
        typeCombo.setFont(new Font("TAHOMA",Font.PLAIN, 16));
        typeCombo.setBackground(Color.white);
        add(typeCombo);
        
        add = new JButton("Add Room");
        add.setBounds(60,350, 140, 30);
        add.setFont(new Font("Tahoma", Font.BOLD, 15));
        add.setBackground(Color.blue);
        add.setForeground(Color.white);
        add.addActionListener(this);        
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(210,350, 140, 30);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image i2 = i1.getImage().getScaledInstance(530,360, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390,25,530,360); 
        add(image);
   
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String roomnumber = tfroom.getText();
            String availability = (String) availableCombo.getSelectedItem();
            String status = (String) cleanCombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typeCombo.getSelectedItem();
            
            try {
                Conn conn = new Conn();
                String str = " insert into room values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            setVisible(false);
            new Dashboard();
        
        } else {
            setVisible(false);
            new Dashboard();
        }
    }
    
    public static void main(String args[]) {
        new AddRooms();
    }
}
