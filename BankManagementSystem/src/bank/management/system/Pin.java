package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String cardno,pin;
    Pin(String cardno,String  pin){
        this.pin =pin;
        this.cardno=cardno;

        

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.black);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(300,50,400,35);
        add(label1);

        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(100,150,150,35);
        add(label2);

        p1 = new JPasswordField();
        p1.setBounds(300,150,180,25);
        p1.setFont(new Font("Raleway", Font.BOLD,22));
        add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(100,200,400,35);
        add(label3);

        p2 = new JPasswordField();
        p2.setBounds(300,200,180,25);
        p2.setFont(new Font("Raleway", Font.BOLD,22));
        add(p2);

        b1 = new JButton("CHANGE");
        b1.setBounds(400,350,150,35);
        b1.setBackground(new Color(65, 94,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(200,350,150,35);
        b2.setBackground(new Color(65, 94,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setLayout(null);
//        setSize(1550,1080);
        setSize(750,480);
        getContentPane().setBackground(Color.white);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{

            String pin1 = p1.getText();
            String pin2 = p2.getText();


            if (e.getSource()==b1){
                if (!pin1.equals(pin2)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }
                Connect c = new Connect();
                String q1 = "update BalanceInfo set Pin = '"+pin1+"' where Pin = '"+pin+"'";
                String q2 = "update Login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update AccountDetails set Pin = '"+pin1+"' where Pin = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new Features(cardno,pin);

            } else if (e.getSource()==b2) {
              // new Menu(cardno,pin);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Pin("","");
    }
}
