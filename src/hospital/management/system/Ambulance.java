package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {
    Ambulance(){
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
            String q="select * from  Ambulance";
            ResultSet resultSet= c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){


            e.printStackTrace();

        }
        JLabel label=new JLabel("Name");
        label.setBounds(31,40,100,14);
        label.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label);

        JLabel label1=new JLabel("Gender");
        label1.setBounds(220,40,100,14);
        label1.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Car Name");
        label2.setBounds(350,40,100,14);
        label2.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label2);

        JLabel label3=new JLabel("Available");
        label3.setBounds(490,40,100,14);
        label3.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label3);

        JLabel label4=new JLabel("Location");
        label4.setBounds(700,40,100,14);
        label4.setFont(new Font("tohama",Font.BOLD,14));
        panel.add(label4);


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
        new Ambulance();
    }
}
