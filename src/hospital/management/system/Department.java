package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    JTable table;
    Department(){
       JPanel panel =new JPanel();
        panel.setBounds(5,5,790,490);
        panel.setBackground(new Color(247,181,202));
        panel.setLayout(null);
       add(panel);

       table = new JTable();
        table.setBounds(0,90,700,200);
        table.setBackground(new Color(247,181,202));
        table.setFont(new Font("Tohama",Font.BOLD,16));
        panel.add(table);

        try{
            conn c =new conn();
            String q = "select * from department";
            ResultSet resultSet =c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();

        }

        JLabel label1=new JLabel("Department");
        label1.setBounds(145,50,105,20);
        label1.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Phone Number");
        label2.setBounds(450,50,105,20);
        label2.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label2);

        JButton b1 =new JButton("back");
        b1.setBounds(400,400,130,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
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
        new Department();

    }
}
