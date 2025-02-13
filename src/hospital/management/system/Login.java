package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField passwordField;
    JButton b1, b2;

    Login() {

        JPanel panel=new JPanel();
        panel.setBounds(5,5,590,290);
        panel.setBackground(new Color(247,181,202));
        panel.setLayout(null);
        add(panel);

        JLabel namelabel = new JLabel("USERNAME");
        namelabel.setBounds(40, 40, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.black);
        panel.add(namelabel);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(40, 100, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.black);
        panel.add(password);

        textField = new JTextField();
        textField.setBounds(150, 40, 150, 30);
        textField.setBackground(new Color(255, 179, 0));
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 30);
        passwordField.setBackground(new Color(255, 179, 0));
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
         panel.add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login9.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(250, -40, 400, 300);

        panel.add(label);

        b1 = new JButton("LOGIN");
        b1.setBounds(30, 160, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
         panel.add(b1);

        b2 = new JButton("CANCEL");
        b2.setBounds(180, 160, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
       panel. add(b2);

        setUndecorated(true);
        getContentPane().setBackground(Color.white);
        setSize(600, 300);
        setLocation(350, 200);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)

            try {
                conn c = new conn();
                String user = textField.getText();
                String pass =new String(passwordField.getPassword());
                String q = "select * from login where ID = '" + user + "' and  PW = '" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }

        else {
            System.exit(10);
        }
    }
    public static void main(String[] args) {
        new Login();

    }

}