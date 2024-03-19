package bank.management.system;

import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Features extends JFrame implements ActionListener {

    JButton buttonDeposit,buttonCashwithdrawal,buttonFastCash,buttonMiniStatement,buttoncardNoChange,buttonBalanceQuery,buttonExit;
    String cardNo, username, password, pin;
    JPanel panel ;
    Features(String cardNo, String pin){
        super("MENU");
        this.cardNo=cardNo;
        this.pin=pin;

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(550,100,700,20);
        label.setForeground(new Color(65, 94,128));
        label.setFont(new Font("System",Font.BOLD,20));
        add(label);

        buttonDeposit = new JButton("DEPOSIT");
        buttonDeposit.setForeground(Color.white);
        buttonDeposit.setBackground(new Color(65, 94,128));
        buttonDeposit.setBounds(600,150,150,35);
        buttonDeposit.addActionListener(this);
        add(buttonDeposit);

        buttonCashwithdrawal = new JButton("CASH WITHDRAWL");
        buttonCashwithdrawal.setForeground(Color.white);
        buttonCashwithdrawal.setBounds(600,200,150,35);
        buttonCashwithdrawal.setBackground(new Color(65, 94,128));
        buttonCashwithdrawal.addActionListener(this);
        add(buttonCashwithdrawal);

        buttonFastCash = new JButton("FAST CASH");
        buttonFastCash.setForeground(Color.white);
        buttonFastCash.setBackground(new Color(65, 94,128));
        buttonFastCash.setBounds(600,250,150,35);
        buttonFastCash.addActionListener(this);
        add(buttonFastCash);

        buttonMiniStatement = new JButton("MINI STATEMENT");
        buttonMiniStatement.setForeground(Color.white);
        buttonMiniStatement.setBounds(600,300,150,35);
        buttonMiniStatement.setBackground(new Color(65, 94,128));
        buttonMiniStatement.addActionListener(this);
        add(buttonMiniStatement);

        buttoncardNoChange = new JButton("PIN CHANGE");
        buttoncardNoChange.setForeground(Color.white);
        buttoncardNoChange.setBackground(new Color(65, 94,128));
        buttoncardNoChange.setBounds(600,350,150,35);
        buttoncardNoChange.addActionListener(this);
        add(buttoncardNoChange);

        buttonBalanceQuery = new JButton("BALANCE");
        buttonBalanceQuery.setForeground(Color.white);
        buttonBalanceQuery.setBackground(new Color(65, 94,128));
        buttonBalanceQuery.setBounds(600,400,150,35);
        buttonBalanceQuery.addActionListener(this);
        add(buttonBalanceQuery);

        buttonExit = new JButton("BACK TO LOGIN");
        buttonExit.setForeground(Color.white);
        buttonExit.setBackground(new Color(65, 94,128));
        buttonExit.setBounds(600,450,150,35);
        buttonExit.addActionListener(this);
        add(buttonExit);

        this.panel=new JPanel();
        this.panel.setVisible(true);
        this.panel.setBackground(new Color(255, 255, 255));
        this.panel.setBounds(380,60,600,500);
        this.add(this.panel);

        setLayout(null);
        //setSize(750,480);
        setSize(1550,1080);
        getContentPane().setBackground(new Color(64, 81, 171));
        // setLocation(250,100);
        setLocation(0,0);
        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonDeposit){
            new Deposit(cardNo, pin);
           //setVisible(false);
        }else if (e.getSource()==buttonExit){
           new Login();
            setVisible(false);
        } else if (e.getSource()==buttonCashwithdrawal) {
            new Withdraw(cardNo,pin);
          // setVisible(false);
        } else if (e.getSource()==buttonBalanceQuery) {
            new BalanceEnquiry(cardNo,pin);
            //setVisible(false);
        } else if (e.getSource()==buttonFastCash) {
            new FastCash(cardNo,pin);
           //setVisible(false);
        } else if (e.getSource()==buttoncardNoChange) {
            new Pin(cardNo,pin);
          //setVisible(false);
        } else if (e.getSource()==buttonMiniStatement) {
            new mini(cardNo);
        }

    }

    public static void main(String[] args) {
        new Features("","");
    }
}
