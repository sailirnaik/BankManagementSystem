package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini extends JFrame implements ActionListener {
    String cardno;
    JButton button;
    mini(String cardno){
        this.cardno = cardno;


        JLabel cardlabel = new JLabel();
        cardlabel.setBounds(20,10,400,20);
        cardlabel.setFont(new Font("Arial",Font.BOLD,16));
        add(cardlabel);


        JLabel statementlabel = new JLabel();
        statementlabel.setBounds(20,100,300,200);
        add(statementlabel);

        JLabel balancelabel = new JLabel();
        balancelabel.setBounds(20,400,300,20);
        add(balancelabel);

        try{
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("select * from Login where CardNo = '"+cardno+"'");
            while (resultSet.next()){
                cardlabel.setText("Card Number:  "+ resultSet.getString("CardNo").substring(0,4) + "XXXXXXXX"+ resultSet.getString("CardNo").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        try{
            int balance =0;
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("select * from BalanceInfo where CardNo = '"+cardno+"'");
            while (resultSet.next()){

               statementlabel.setText(statementlabel.getText() + "<html>"+resultSet.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("Amount")+ "<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("Amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("Amount"));
                }
            }
            balancelabel.setText("Your Total Balance is Rs "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(new Color(65, 94,128));
        button.setForeground(Color.WHITE);
        add(button);

        getContentPane().setBackground(new Color(255,255,255));
        setSize(400,600);
        setLocation(500,20);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new mini("");
    }
}
