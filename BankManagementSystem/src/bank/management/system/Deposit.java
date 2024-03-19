package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String cardNo,pin;
    TextField textFieldDeposit;
    JButton buttonDeposit, buttonBack;
    Deposit(String cardNo, String pin){
        this.cardNo = cardNo;
        this.pin=pin;



        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(100,100,400,35);
        add(label1);

        textFieldDeposit = new TextField();
        textFieldDeposit.setBounds(100,180,320,20);
        textFieldDeposit.setFont(new Font("Raleway", Font.BOLD,14));
        add(textFieldDeposit);

        buttonDeposit = new JButton("DEPOSIT");
        buttonDeposit.setBounds(100,250,150,35);
        buttonDeposit.setBackground(new Color(65, 94,128));
        buttonDeposit.setForeground(Color.WHITE);
        buttonDeposit.addActionListener(this);
        add(buttonDeposit);

        buttonBack = new JButton("BACK");
        buttonBack.setBounds(100,300,150,35);
        buttonBack.setBackground(new Color(65, 94,128));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.addActionListener(this);
       add(buttonBack);


        setLayout(null);
//        setSize(1550,1080);
        setSize(750,480);
        getContentPane().setBackground(Color.white);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textFieldDeposit.getText();
            Date date = new Date();
            if (e.getSource()==buttonDeposit){
                if (textFieldDeposit.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Deposit");
                }else {
                    Connect c = new Connect();
                    c.statement.executeUpdate("insert into BalanceInfo values( '"+date+"','"+pin+"','"+amount+"','Deposit','"+cardNo+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");

                }
            }else if (e.getSource()==buttonBack){
               // new Menu(cardNo,pin);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("","");
    }


}
