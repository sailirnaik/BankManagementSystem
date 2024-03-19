package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgotPassword extends JFrame implements ActionListener {

    JButton button1, button2;
    JTextField cardField1,pinField, passwordField1, passwordField2;
    ForgotPassword() {

        JLabel label1 = new JLabel("Enter the Card Number:");
        label1.setForeground(Color.black);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(100,50,400,35);
        add(label1);

        cardField1 = new JTextField();
        cardField1.setBounds(300,50,180,20);
        cardField1.setFont(new Font("Raleway", Font.BOLD,14));
        add(cardField1);

        JLabel label2 = new JLabel("Enter the Pin:");
        label2.setForeground(Color.black);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(100,100,400,35);
        add(label2);

        pinField = new JTextField();
        pinField.setBounds(300,100,180,20);
        pinField.setFont(new Font("Raleway", Font.BOLD,14));
        add(pinField);

        JLabel label3 = new JLabel("New Password: ");
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(100,150,150,35);
        add(label3);

        passwordField1 = new JTextField();
        passwordField1.setBounds(300,150,180,20);
        passwordField1.setFont(new Font("Raleway", Font.BOLD,14));
        add(passwordField1);

        JLabel label4 = new JLabel("Re-Enter New Password: ");
        label4.setForeground(Color.BLACK);
        label4.setFont(new Font("System", Font.BOLD, 16));
        label4.setBounds(100,200,400,35);
        add(label4);

        passwordField2 = new JTextField();
        passwordField2.setBounds(300,200,180,20);
        passwordField2.setFont(new Font("Raleway", Font.BOLD,14));
        add(passwordField2);

        button1 = new JButton("CHANGE");
        button1.setBounds(400,350,150,30);
        button1.setBackground(new Color(65, 94,128));
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setBounds(200,350,150,30);
        button2.setBackground(new Color(65, 94,128));
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);
        add(button2);

        setLayout(null);
//        setSize(1550,1080);
        setSize(750,480);
        getContentPane().setBackground(Color.white);
        setLocation(300,100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String card=cardField1.getText();
        String pin=pinField.getText();

        try{
            String pin1 = passwordField1.getText();
            String pin2 = passwordField2.getText();

            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if (e.getSource()==button1){
                if (passwordField1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if (passwordField2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }

                Connect c = new Connect();
                ResultSet resultSet = c.statement.executeQuery("Select CardNo, Pin from Login where CardNo = '"+card+"'and Pin='"+pin+"'" );
                if(resultSet!=null) {
                    String q2 = "update Login set Password = '" + pin1 + "' where CardNo = '" + card + "'";
                    String q3 = "update AccountDetails set Password = '" + pin1 + "' where CardNo = '" + card + "'";
                    c.statement.executeUpdate(q2);
                    c.statement.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                }

            } else if (e.getSource()==button2) {
              // new Login();
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ForgotPassword();
    }
}
