package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class All_Patient_Info extends JFrame {
    All_Patient_Info(){
       JTable table;
       JPanel panel=new JPanel();
       panel.setBounds(5,5,790,490);
       panel.setBackground(new Color(247,181,202));
       panel.setLayout(null);
       add(panel);

       table = new JTable();
       table.setBounds(0,60,800,300);
       table.setBackground(new Color(247,181,202));
       table.setFont(new Font("Tohama",Font.BOLD,10));
       panel.add(table);
       try{
          conn c =new conn();
          String q="select * from  patient_info";
           ResultSet resultSet= c.statement.executeQuery(q);
           table.setModel(DbUtils.resultSetToTableModel(resultSet));
       }catch(Exception e){


           e.printStackTrace();

       }
       JLabel label=new JLabel("ID");
       label.setBounds(10,40,100,14);
       label.setFont(new Font("tohama",Font.BOLD,14));
       panel.add(label);

        JLabel label1=new JLabel("ID NO");
        label1.setBounds(130,40,100,14);
        label1.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("NAME");
        label2.setBounds(230,40,100,14);
        label2.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label2);

        JLabel label3=new JLabel("GENDER");
        label3.setBounds(310,40,100,14);
        label3.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label3);

        JLabel label4=new JLabel("DISEASES");
        label4.setBounds(410,40,100,14);
        label4.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label4);

        JLabel label5=new JLabel("ROOM NO");
        label5.setBounds(510,40,100,14);
        label5.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label5);

        JLabel label6=new JLabel("TIME");
        label6.setBounds(610,40,100,14);
        label6.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label6);

        JLabel label7=new JLabel("DEPOSITE");
        label7.setBounds(705,40,100,14);
        label7.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label7);

        JButton b1 =new JButton("back");
        b1.setBounds(400,350,130,30);
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
        setLocation(300,170);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args){
       new  All_Patient_Info();
    }
}
