package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {
    Choice choice;
    JTable table;
    SearchRoom(){
      JPanel panel = new JPanel();
      panel.setBounds(5,5,690,490);
      panel.setBackground(new Color(247,181,202));
      panel.setLayout(null);
      add(panel);

      JLabel For=new JLabel("Search For Room");
      For.setBounds(250,11,186,31);
      For.setForeground(Color.white);
      For.setFont(new Font("Tohama",Font.BOLD,20));
      panel.add(For);

        JLabel status =new JLabel("Status");
        status.setBounds(70,70,80,20);
        status.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(status);

        choice =new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table= new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(247,181,202));
        panel.add(table);
        try{
            conn c= new conn();
            String q= "select * from room";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();

        }
        JLabel Roomno =new JLabel("Room Number");
        Roomno.setBounds(23,162,150,20);
        Roomno.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(Roomno);

        JLabel available =new JLabel("Available");
        available.setBounds(175,162,150,20);
        available.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(available);

        JLabel price =new JLabel("Price");
        price.setBounds(458,162,150,20);
        price.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(price);

        JLabel bed  =new JLabel("Bed Type");
        bed.setBounds(580,162,150,20);
        bed.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(bed);

        JButton Search = new JButton("Search");
        Search.setBounds(200,420,120,25);
        Search.setBackground(Color.black);
        Search.setForeground(Color.white);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q= "select * from room where Available ='"+choice.getSelectedItem()+"'";
                try{
                    conn c =new conn();
                    ResultSet resultSet =c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(380,420,120,25);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(300,170);
        setVisible(true);
    }
    public static void main(String[] args){
        new SearchRoom();
    }
}
