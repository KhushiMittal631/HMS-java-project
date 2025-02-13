package hospital.management.system;

import com.mysql.cj.xdevapi.Table;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;
    Room() {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,490);
        panel.setBackground(new Color(247,181,202));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
         Image image = imageIcon.getImage().getScaledInstance(200,200 ,Image.SCALE_DEFAULT);
         ImageIcon imageIcon1 =new ImageIcon(image);
         JLabel label = new JLabel(imageIcon1);
         label.setBounds(550,200,200,200);
          panel.add(label);

           table = new JTable();
          table.setBounds(10,50,530,350);
          table.setBackground(new Color(247,181,202));
          panel.add(table);

          try {
            conn c= new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
          }catch (Exception e){
            e.printStackTrace();
          }
          JLabel label1= new JLabel("New Room");
          label1.setBounds(12,15,80,15);
          label1.setFont(new Font("Tohama",Font.BOLD,14));
          panel.add(label1);

        JLabel label2= new JLabel("Availablility");
        label2.setBounds(140,15,80,15);
        label2.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label2);

        JLabel label3= new JLabel("Price");
        label3.setBounds(290,15,80,15);
        label3.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label3);

        JLabel label4= new JLabel("Room Type");
        label4.setBounds(410,15,80,15);
        label4.setFont(new Font("Tohama",Font.BOLD,14));
        panel.add(label4);

        JButton back = new JButton("Back");
        back.setBounds(400,400,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


      setLayout(null);
      setLocation(300,170);
      setUndecorated(true);
      setSize(800,500);
      setVisible(true);



    }

    public static void main(String[] args) {

        new Room();
    }
}
