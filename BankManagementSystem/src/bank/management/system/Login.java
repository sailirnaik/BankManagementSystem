package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel labelMyBank, labelUsername, labelPassword , labelWelcome;
    JTextField textUserName;
    JPasswordField passwordField;
    JButton buttonSignIn,buttonCreateAcc,buttonForgotPassword,buttonExit;

    JPanel panel ;
    Login(){
        super("Bank Management System");//gives name to the frame, it should be always in the top

        //bank icon
        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/bank1.png"));//image gets stored in i1, converts image to icon
        Image i21= i11.getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT);//to give height and width
        ImageIcon i31=new ImageIcon(i21);
        JLabel image1=new JLabel(i31);
        image1.setBounds(80,50,200,150);//to give position of the image
        add(image1);


        this.labelMyBank = new JLabel("MY BANK");
        this.labelMyBank.setForeground(Color.WHITE);
        this.labelMyBank.setFont(new Font("AvantGarde", 1, 14));
        this.labelMyBank.setBounds(140,195,150,40);
        this.add(this.labelMyBank);

        this.buttonCreateAcc = new JButton("Create Account");
        this.buttonCreateAcc.setFont(new Font("Arial", 1, 18));
        this.buttonCreateAcc.setForeground(Color.WHITE);
        this.buttonCreateAcc.setBackground(new Color(12, 53, 158));
        this.buttonCreateAcc.setBorder(BorderFactory.createLineBorder(new Color(12, 53, 158)));
        this.buttonCreateAcc.setBounds(55, 325, 200, 30);
        this.buttonCreateAcc.addActionListener(this);
        this.add(this.buttonCreateAcc);

        this.buttonForgotPassword = new JButton("Forgot Password");
        this.buttonForgotPassword.setFont(new Font("Arial", 1, 18));
        this.buttonForgotPassword.setForeground(Color.WHITE);
        this.buttonForgotPassword.setBackground(new Color(12, 53, 158));
        this.buttonForgotPassword.setBorder(BorderFactory.createLineBorder(new Color(12, 53, 158)));
        this.buttonForgotPassword.setBounds(55, 365, 200, 30);
        this.buttonForgotPassword.addActionListener(this);
        this.add(this.buttonForgotPassword);


        this.buttonExit = new JButton("Exit");
        this.buttonExit.setFont(new Font("Arial", 1, 18));
        this.buttonExit.setForeground(Color.WHITE);
        this.buttonExit.setBackground(new Color(12, 53, 158));
        this.buttonExit.setBorder(BorderFactory.createLineBorder(new Color(12, 53, 158)));
        this.buttonExit.setBounds(55, 400, 200, 30);
        this.buttonExit.addActionListener(this);
        this.add(this.buttonExit);

        this.labelWelcome = new JLabel("Welcome");
        this.labelWelcome.setForeground(new Color(12, 53, 158));
        this.labelWelcome.setFont(new Font("Arial", 1, 40));
        this.labelWelcome.setBounds(700,200,200,40);
        this.add(this.labelWelcome);

        this.labelUsername = new JLabel("User Name");
        this.labelUsername.setForeground(Color.BLACK);
        this.labelUsername.setFont(new Font("Arial", 1, 14));
        this.labelUsername.setBounds(650,300,200,40);
        this.add(this.labelUsername);
        this.textUserName=new JTextField(14);
        this.textUserName.setBounds(650,340,300,25);
        this.textUserName.setFont(new Font("Arial", 1, 12));
        this.textUserName.setForeground(Color.BLACK);
        this.add(this.textUserName);

        this.labelPassword = new JLabel("Password");
        this.labelPassword.setForeground(Color.BLACK);
        this.labelPassword.setFont(new Font("Arial", 1, 14));
        this.labelPassword.setBounds(650,370,200,40);
        this.add(this.labelPassword);
        this.passwordField=new JPasswordField(14);
        this.passwordField=new JPasswordField(14);
        this.passwordField.setBounds(650,410,300,25);
        this.passwordField.setFont(new Font("Arial",1,12));
        this.passwordField.setForeground(Color.BLACK);
        this.add(this.passwordField);

        this.buttonSignIn = new JButton("SIGN IN");
        this.buttonSignIn.setFont(new Font("Arial", 1, 14));
        this.buttonSignIn.setForeground(Color.WHITE);
        this.buttonSignIn.setBackground(new Color(12, 53, 158));
        this.buttonSignIn.setBounds(850, 460, 100, 30);
        this.buttonSignIn.addActionListener(this);
        this.add(this.buttonSignIn);


        this.panel=new JPanel();
        this.panel.setVisible(true);
        this.panel.setBackground(new Color(237, 238, 243));
        this.panel.setBounds(500,150,600,400);
        this.add(this.panel);


        //whitebackground
        ImageIcon i12=new ImageIcon(ClassLoader.getSystemResource("icon/whitebg.png"));//image gets stored in i1, converts image to icon
        Image i22= i12.getImage().getScaledInstance(1050,1080, Image.SCALE_DEFAULT);//to give height and width
        ImageIcon i32=new ImageIcon(i22);
        JLabel image2=new JLabel(i32);
        image2.setBounds(350,0,1050,1080);//to give position of the image
        add(image2);




        setLayout(null);
//        setSize(750,480);
//        setLocation(250,100);
        setSize(1650,1080);
        setLocation(0,0);
        getContentPane().setBackground( new Color(12, 53, 158));
        setVisible(true);// to make the frame visible by default visibility is hidden, always keep at last
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pin, cardNo;
        try{
            if(e.getSource()==buttonSignIn){//sign in
                Connect c = new Connect();
                String username = textUserName.getText();
                String password = passwordField.getText();
                ResultSet resultSet = c.statement.executeQuery("select CardNo, Pin from Login where Username = '"+username+"' and  Password = '"+password+"'");
                if (resultSet.next()){
                    pin =resultSet.getString("Pin");
                    cardNo=resultSet.getString("CardNo");
                    setVisible(false);
                    new Features(cardNo, pin);

                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect UserName and Password");
                }
            }else if(e.getSource()==buttonCreateAcc){//create
                new PersonalDetails();
                setVisible(false);// new account
            }else if(e.getSource()==buttonForgotPassword){ //forgot password
                new ForgotPassword();
                //setVisible(false);
            }else //exit
                if(e.getSource()==buttonExit) System.exit(0);
        }
        catch(Exception E){
            E.printStackTrace();
        }
    }
}
