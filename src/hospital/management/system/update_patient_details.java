package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {
    update_patient_details(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(241,181,202));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 =new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(550,40,200,200);
        panel.add(label);

        JLabel label1=new JLabel("Update Patient Details");
        label1.setBounds(100,20,250,22);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tohama",Font.BOLD,20));
        panel.add(label1);



        JLabel label2=new JLabel("Name");
        label2.setBounds(30,90,150,20);
        label2.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label2);



       Choice choice =new Choice();
       choice.setBounds(200,90,150,20);
       panel.add(choice);
       try {
           conn c = new conn();
           ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
           while(resultSet.next()){
               choice.add(resultSet.getString("Name"));

           }
       }catch(Exception e){
           e.printStackTrace();

       }
        JLabel label3=new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label3);

        JTextField textFielddR =new JTextField();
        textFielddR.setBounds(200,130,150,20);
        textFielddR.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(textFielddR);


        JLabel label4=new JLabel("IN-Time");
        label4.setBounds(30,170,150,20);
        label4.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label4);
        JTextField textFieldInTime =new JTextField();
        textFieldInTime.setBounds(200,170,150,20);
        textFieldInTime.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(textFieldInTime);


        JLabel label5=new JLabel("Amount Paid(Rs)");
        label5.setBounds(30,210,150,20);
        label5.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label5);
        JTextField textFieldAmt =new JTextField();
        textFieldAmt.setBounds(200,210,150,20);
        textFieldAmt.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(textFieldAmt);

        JLabel label6=new JLabel("Pending Amount(Rs)");
        label6.setBounds(30,250,150,20);
        label6.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label6);
        JTextField textFieldPending =new JTextField();
        textFieldPending.setBounds(200,250,150,20);
        textFieldPending.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(textFieldPending);

        JButton check=new JButton("CHECK");
        check.setBounds(150,300,100,30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q= "select * from patient_info where Name='"+id+"'";
                try{
                    conn c=new conn();
                     ResultSet resultSet=c.statement.executeQuery(q);
                     while(resultSet.next()){
                         textFielddR.setText(resultSet.getString("Room_Number"));
                         textFieldInTime.setText(resultSet.getString("Time"));
                         textFieldAmt.setText(resultSet.getString("Deposite"));

                     }
                     ResultSet resultSet1=c.statement.executeQuery("select * from room where Room_number='"+textFielddR.getText()+"'");
                     while (resultSet1.next()){
                         String price =resultSet1.getString("Price");
                         int amountpaid =Integer.parseInt(price)-Integer.parseInt(textFieldAmt.getText());
                         textFieldPending.setText(""+amountpaid);
                     }
                }catch (Exception E){
                    E.printStackTrace();

                }
            }
        });
        JButton update=new JButton("UPDATE");
        update.setBounds(30,300,100,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   conn c =new conn();
                   String q =choice.getSelectedItem();
                   String room =textFielddR.getText();
                   String time=textFieldInTime.getText();
                   String amount =textFieldAmt.getText();
                   c.statement.executeUpdate("update patient_info set Room_Number='"+room+"',Time='"+time+"',Deposite='"+amount+"' where Name='"+q+"'");
                   JOptionPane.showMessageDialog(null,"Updated Successfully");
                   setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton back=new JButton("BACK");
        back.setBounds(280,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(300,170);
        setVisible(true);
    }
    public static void main(String[] args){
        new update_patient_details();
    }
}
