package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    Employee_info(){
        JTable table;
        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,490);
        panel.setBackground(new Color(247,181,202));
        panel.setLayout(null);
        add(panel);

        table=new JTable();
        table.setBounds(0,90,800,250);
        table.setBackground(new Color(247,181,202));
        table.setFont(new Font("Tohama",Font.BOLD,11));
        panel.add(table);

        try{
            conn c =new conn();
            String q="select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch(Exception e){
           e.printStackTrace();
        }
        JLabel label1= new JLabel("Name");
        label1.setBounds(60,50,80,20);
        label1.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label1);

        JLabel label2= new JLabel("Age");
        label2.setBounds(150,50,80,20);
        label2.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label2);

        JLabel label3= new JLabel("Gmail Id");
        label3.setBounds(280,50,80,20);
        label3.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label3);

        JLabel label4= new JLabel("Department");
        label4.setBounds(430,50,80,20);
        label4.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label4);

        JLabel label5= new JLabel("Salary");
        label5.setBounds(590,50,80,20);
        label5.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label5);

        JLabel label6= new JLabel("Adhar No");
        label6.setBounds(700,50,80,20);
        label6.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label6);

        Button b2 = new Button("back");
        b2.setBounds(500,400,130,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setSize(800,500);
        setLayout(null);
        setLocation(300,170);
        setVisible(true);

    }
    public static void main(String[] args){
       new Employee_info();
    }
}
