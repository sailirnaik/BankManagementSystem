package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AccountDetails extends JFrame implements ActionListener {

    JRadioButton at1,at2,at3,at4;
    JCheckBox sr1,sr2,sr3,sr4,sr5,sr6;
    JButton submitButton,buttonBackToLogin;
    String formno;
    JLabel username, password;
    JTextField textfieldUsername, textfieldPassword;
    AccountDetails(String formno){

        this.formno = formno;

        JLabel labelAccountDetails = new JLabel("Account Details");
        labelAccountDetails.setBounds(580,20,600,20);
        labelAccountDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelAccountDetails);

        JLabel labelFormNo = new JLabel("Form No : ");
        labelFormNo.setFont(new Font("Raleway", Font.BOLD,14));
        labelFormNo.setBounds(900,20,100,20);
        add(labelFormNo);
        JLabel labelformNo = new JLabel(formno);
        labelformNo.setBounds(1000,20,100,14);
        labelformNo.setFont(new Font("Raleway", Font.BOLD, 14));
        add(labelformNo);

        JLabel labelAccounttype = new JLabel("Account Type:");
        labelAccounttype.setFont(new Font("Raleway",Font.BOLD,14));
        labelAccounttype.setBounds(100,65,200,20);
        add(labelAccounttype);
        at1 = new JRadioButton("Saving Account");
        at1.setBackground(Color.WHITE);
        at1.setBounds(100,90,220,20);
        add(at1);
        at2 = new JRadioButton("Fixed Deposit Account");
        at2.setBackground(Color.WHITE);
        at2.setBounds(320,90,200,20);
        add(at2);
        at3 = new JRadioButton("Current Account");
        at3.setBackground(Color.WHITE);
        at3.setBounds(540,90,200,20);
        add(at3);
        at4 = new JRadioButton("Recurring Deposit Account");
        at4.setBackground(Color.WHITE);
        at4.setBounds(860,90,200,20);
        add(at4);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(at1);
        buttonGroup.add(at2);
        buttonGroup.add(at3);
        buttonGroup.add(at4);

        JLabel labelCardNo = new JLabel("Card Number:");
        labelCardNo.setFont(new Font("Raleway",Font.BOLD,14));
        labelCardNo.setBounds(100,150,200,20);
        add(labelCardNo);
        JLabel labelCard = new JLabel("(Your 14-digit Card Number)");
        labelCard.setFont(new Font("Raleway",Font.BOLD,10));
        labelCard.setBounds(100,170,200,14);
        add(labelCard);
        JLabel labelCardDispllay = new JLabel("XXXX-XXXX-XXXX-4841");
        labelCardDispllay.setFont(new Font("Raleway",Font.BOLD,14));
        labelCardDispllay.setBounds(320,150,200,20);
        add(labelCardDispllay);
        JLabel labelCardMsg = new JLabel("(It would appear on atm card/cheque Book and Statements)");
        labelCardMsg.setFont(new Font("Raleway",Font.BOLD,10));
        labelCardMsg.setBounds(320,170,350,14);
        add(labelCardMsg);

        JLabel labelPin = new JLabel("PIN:");
        labelPin.setFont(new Font("Raleway",Font.BOLD,14));
        labelPin.setBounds(100,200,200,20);
        add(labelPin);
        JLabel labelpin = new JLabel("XXXX");
        labelpin.setFont(new Font("Raleway",Font.BOLD,14));
        labelpin.setBounds(320,200,200,20);
        add(labelpin);
        JLabel labelPinMsg = new JLabel("(4-digit Password)");
        labelPinMsg.setFont(new Font("Raleway",Font.BOLD,10));
        labelPinMsg.setBounds(320,215,200,14);
        add(labelPinMsg);

        JLabel l11 = new JLabel("Services Required:");
        l11.setFont(new Font("Raleway",Font.BOLD,14));
        l11.setBounds(100,240,200,20);
        add(l11);
        sr1 = new JCheckBox("ATM CARD");
        sr1.setFont(new Font("Raleway",Font.BOLD,12));
        sr1.setBackground(Color.white);
        sr1.setBounds(320,270,200,14);
        add(sr1);
        sr2 = new JCheckBox("Internet Banking");
        sr2.setFont(new Font("Raleway",Font.BOLD,12));
        sr2.setBackground(Color.white);
        sr2.setBounds(540,270,200,14);
        add(sr2);
        sr3 = new JCheckBox("Mobile Banking");
        sr3.setFont(new Font("Raleway",Font.BOLD,12));
        sr3.setBackground(Color.white);
        sr3.setBounds(860,270,200,14);
        add(sr3);
        sr4 = new JCheckBox("EMAIL Alerts");
        sr4.setFont(new Font("Raleway",Font.BOLD,12));
        sr4.setBackground(Color.white);
        sr4.setBounds(320,300,200,14);
        add(sr4);
        sr5 = new JCheckBox("Cheque Book");
        sr5.setFont(new Font("Raleway",Font.BOLD,12));
        sr5.setBackground(Color.white);
        sr5.setBounds(540,300,200,14);
        add(sr5);
        sr6 = new JCheckBox("E-Statement");
        sr6.setFont(new Font("Raleway",Font.BOLD,12));
        sr6.setBackground(Color.white);
        sr6.setBounds(860,300,200,20);
        add(sr6);


        username= new JLabel("Set UserName: ");
        username.setBounds(100,350,180,14);
        username.setFont(new Font("Raleway", Font.BOLD, 14));
        add(username);
        textfieldUsername=new JTextField();
        textfieldUsername.setBounds(320,350,200,20);
        add(textfieldUsername);

        password= new JLabel("Set Password: ");
        password.setBounds(100,380,180,14);
        password.setFont(new Font("Raleway", Font.BOLD, 14));
        add(password);
        textfieldPassword=new JTextField();
        textfieldPassword.setBounds(320,380,200,20);
        add(textfieldPassword);

        JCheckBox c7 = new JCheckBox("I here by decleares that the above entered details correct to the best of my knlowledge.",true);
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,550,600,20);
        add(c7);


        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Raleway", Font.BOLD,14));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground( new Color(12, 53, 158));
        submitButton.setBounds(700,600,100,20);
        submitButton.addActionListener(this);
        add(submitButton);



        buttonBackToLogin= new JButton("Back To Login");
        buttonBackToLogin.setFont(new Font("Raleway", Font.BOLD,14));
        buttonBackToLogin.setBackground( new Color(12, 53, 158));
        buttonBackToLogin.setForeground(Color.WHITE);
        buttonBackToLogin.setBounds(450,600,200,20);
        buttonBackToLogin.addActionListener(this);
        add(buttonBackToLogin);

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(1650,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username=textfieldUsername.getText();
        String password=textfieldPassword.getText();
        String accountType = null;
        if (at1.isSelected()){
            accountType = "Saving Account";
        } else if (at2.isSelected()) {
            accountType ="Fixed Deposit Account";
        }else if (at3.isSelected()){
            accountType ="Current Account";
        }else if (at4.isSelected()){
            accountType = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L)+ 1000L;
        String pin = "" + Math.abs(first3);

        String serviceRequired = "";
        if(sr1.isSelected()){
            serviceRequired = serviceRequired+"ATM CARD ";
        } else if (sr2.isSelected()) {
            serviceRequired = serviceRequired+"Internet Banking";
        } else if (sr3.isSelected()) {
            serviceRequired = serviceRequired+"Mobile Banking";
        } else if (sr4.isSelected()) {
            serviceRequired = serviceRequired+"EMAIL Alerts";
        } else if (sr5.isSelected()) {
            serviceRequired=serviceRequired+"Cheque Book";
        } else if (sr6.isSelected()) {
            serviceRequired=serviceRequired+"E-Statement";
        }

        try {
            if (e.getSource()==submitButton){
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }else {
                    Connect con = new Connect();
                    String query1 = "insert into AccountDetails values('"+formno+"', '"+accountType+"','"+cardno+"','"+pin+"','"+serviceRequired+"','"+username+"','"+password+"')";
                    String query2 = "insert into Login values('"+formno+"','"+cardno+"','"+pin+"','"+username+"','"+password+"')";
                    con.statement.executeUpdate(query1);
                    con.statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n Pin : "+pin );
                    new Deposit(cardno,pin);
                    setVisible(false);
                }

            } else if (e.getSource()==buttonBackToLogin) {
                new Login();
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AccountDetails("");
    }

}