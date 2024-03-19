package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

        String cardno,pin;
        TextField textField;

        JButton buttonWithdraw, buttonMenu;
        Withdraw(String cardno,String pin){
            this.pin=pin;
            this.cardno=cardno;

            JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
            label1.setForeground(Color.BLACK);
            label1.setFont(new Font("System", Font.BOLD, 10));
            label1.setBounds(400,540,700,35);
            add(label1);

            JLabel label2 = new JLabel("PLEASE ENTER AMOUNT");
            label2.setForeground(Color.BLACK);
            label2.setFont(new Font("System", Font.BOLD, 16));
            label2.setBounds(200,150,400,35);
            add(label2);


            textField = new TextField();
            textField.setForeground(Color.BLACK);
            textField.setBounds(200,180,320,30);
            textField.setFont(new Font("Raleway", Font.BOLD,16));
            add(textField);

            buttonWithdraw = new JButton("WITHDRAW");
            buttonWithdraw.setBounds(200,250,150,35);
            buttonWithdraw.setBackground(new Color(65, 94,128));
            buttonWithdraw.setForeground(Color.white);
            buttonWithdraw.addActionListener(this);
            add(buttonWithdraw);

            buttonMenu = new JButton("BACK");
            buttonMenu.setBounds(200,300,150,35);
            buttonMenu.setBackground(new Color(65, 94,128));
            buttonMenu.setForeground(Color.white);
            buttonMenu.addActionListener(this);
            add(buttonMenu);

            setLayout(null);
            setSize(750,480);
            setLocation(300,100);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==buttonWithdraw) {
                try {
                    String amount = textField.getText();
                    Date date = new Date();
                    if (textField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                    } else {
                        Connect c = new Connect();
                        ResultSet resultSet = c.statement.executeQuery("select * from BalanceInfo where CardNo='" + cardno + "'");
                        int balance = 0;
                        while (resultSet.next()) {
                            if (resultSet.getString("Type").equals("Deposit")) {
                                balance += Integer.parseInt(resultSet.getString("amount"));
                            } else {
                                balance -= Integer.parseInt(resultSet.getString("amount"));
                            }
                        }
                        if (balance < Integer.parseInt(amount)) {
                            JOptionPane.showMessageDialog(null, "Insuffient Balance");
                            return;
                        }

                        c.statement.executeUpdate("insert into BalanceInfo values('" + date + "','" + pin + "', '" + amount + "', 'Withdrawl' ,'" + cardno + "')");
                        JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    }
                } catch (Exception E) {
                    E.printStackTrace();

                }
            } else if (e.getSource()==buttonMenu) {
              // new Menu(cardno,pin);
               setVisible(false);
            }
        }

        public static void main(String[] args) {
            new Withdraw("","");
        }
}
