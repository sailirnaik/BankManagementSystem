package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,buttonBack;
    String cardno, pin;
    FastCash(String cardno,String pin){
        this.pin =pin;
        this.cardno=cardno;

        JLabel label = new JLabel("SELECT WITHDRAWL AMOUNT");
        label.setBounds(100,30,700,35);
        label.setFont(new Font("System",Font.BOLD,23));
        add(label);

        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 94,128));
        b1.setBounds(100,150,150,35);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.WHITE);
        b2.setBounds(300,150,150,35);
        b2.setBackground(new Color(65, 94,128));
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setForeground(Color.WHITE);
        b3.setBounds(100,200,150,35);
        b3.setBackground(new Color(65, 94,128));
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setForeground(Color.WHITE);
        b4.setBounds(300,200,150,35);
        b4.setBackground(new Color(65, 94,128));
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setForeground(Color.WHITE);
        b5.setBounds(100,250,150,35);
        b5.setBackground(new Color(65, 94,128));
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65, 94,128));
        b6.setBounds(300,250,150,35);
        b6.addActionListener(this);
        add(b6);

        buttonBack = new JButton("BACK");
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBackground(new Color(65, 94,128));
        buttonBack.setBounds(100,350,150,35);
        buttonBack.addActionListener(this);
        add(buttonBack);

        setLayout(null);
        setSize(750,480);
        getContentPane().setBackground(Color.white);
        setLocation(300,100);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonBack) {
            //new Menu(cardno,pin);
            setVisible(false);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Connect c = new Connect();
            Date date = new Date();
            try{
                ResultSet resultSet = c.statement.executeQuery("select * from BalanceInfo where CardNo = '"+cardno+"'");
                int balance =0;
                while (resultSet.next()){
                    if (resultSet.getString("Type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("Amount"));
                    }else {
                        balance -= Integer.parseInt(resultSet.getString("Amount"));
                    }
                }

                if (e.getSource() != buttonBack && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }

                c.statement.executeUpdate("insert into BalanceInfo values('"+date+"','"+pin+"', '"+amount+"', 'withdrawl','"+cardno+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
            }catch (Exception E){
                E.printStackTrace();
            }


        }


    }

    public static void main(String[] args) {
        new FastCash("","");
    }
}
