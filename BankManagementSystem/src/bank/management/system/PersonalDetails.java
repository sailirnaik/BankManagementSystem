package bank.management.system;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PersonalDetails extends JFrame  implements ActionListener {
    JRadioButton radiobuttonMale,radiobuttonFemale,radiobuttonMarried,radiobuttonUnmarried,radiobuttonOthers;
    JButton buttonNext, buttonBack;
    JTextField textName ,textFname, textEmail,textAdd,textcity,textState,textPin;
    JDateChooser dateChooser;
    Random ran = new Random();
    JComboBox comboBoxReligion,comboBoxCateory,comboBoxIncome,comboBox4,comboBoxOccupation;
    JTextField textfieldPan,textfieldAadhar;
    JRadioButton r1,r2, e1,e2;

    long first4 =(ran.nextLong() % 9000L) +1000L;
    String FormNO = " " + Math.abs(first4);
    PersonalDetails(){
        super("APPLICATION FORM");

        JLabel labelApplication = new JLabel("APPLICATION FORM NO."+ FormNO);
        labelApplication.setBounds(580,20,600,15);
        labelApplication.setForeground(new Color(12, 53, 158));
        labelApplication.setFont(new Font("Raleway",Font.BOLD,15));
        add(labelApplication);

        JLabel labelPersonalDetails = new JLabel("Personal Details");
        labelPersonalDetails.setFont(new Font("Raleway", Font.BOLD,14));
        labelPersonalDetails.setBounds(630,40,600,14);
        add(labelPersonalDetails);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 14));
        labelName.setBounds(100,100,200,14);
        add(labelName);
        textName = new JTextField();
        //textName.setFont(new Font("Raleway",Font.BOLD, 14));
        textName.setBounds(220,100,400,20);
        add(textName);

        JLabel labelReligion = new JLabel("Religion :");
        labelReligion.setBounds(700,100,100,15);
        labelReligion.setFont(new Font("Raleway", Font.BOLD, 14));
        add(labelReligion);
        String religion[] = {"Hindu","Muslim","Sikh", "Christian", "Other"};
        comboBoxReligion = new JComboBox(religion);
        comboBoxReligion.setBounds(800,100,400,20);
        add(comboBoxReligion);

        JLabel labelfName = new JLabel("Father's Name :");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 14));
        labelfName.setBounds(100,150,200,14);
        add(labelfName);
        textFname = new JTextField();
        textFname.setBounds(220,150,400,20);
        add(textFname);

        JLabel labelCateory = new JLabel("Category : ");
        labelCateory.setBounds(700,150,100,15);
        labelCateory.setFont(new Font("Raleway", Font.BOLD, 14));
        add(labelCateory);
        String Category [] = {"General","OBC","SC", "ST", "Other"};
        comboBoxCateory = new JComboBox(Category);
        comboBoxCateory.setBounds(800,150,400,20);
        add(comboBoxCateory);

        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setFont(new Font("Raleway", Font.BOLD, 14));
        DOB.setBounds(100,200,200,14);
        add(DOB);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(220,200,400,20);
        add(dateChooser);

        JLabel labelIncome = new JLabel("Income : ");
        labelIncome.setBounds(700,200,100,14);
        labelIncome.setFont(new Font("Raleway", Font.BOLD, 14));
        add(labelIncome);
        String income [] = {"Null","<1,50,000","<2,50,000", "5,00,000", "Upto 10,00,000","Above 10,00,000"};
        comboBoxIncome = new JComboBox(income);
        comboBoxIncome.setBounds(800,200,400,20);
        add(comboBoxIncome);

        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(new Font("Raleway", Font.BOLD, 14));
        labelG.setBounds(100,250,200,14);
        add(labelG);
        radiobuttonMale = new JRadioButton("Male");
        //radiobuttonMale.setFont(new Font("Raleway", Font.BOLD,14));
        radiobuttonMale.setBackground(new Color(255,255,255));
        radiobuttonMale.setBounds(220,250,90,14);
        add(radiobuttonMale);
        radiobuttonFemale = new JRadioButton("Female");
      //  radiobuttonFemale.setFont(new Font("Raleway", Font.BOLD,14));
        radiobuttonFemale.setBackground(new Color(255,255,255));
        radiobuttonFemale.setBounds(320,250,90,14);
        add(radiobuttonFemale);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radiobuttonMale);
        buttonGroup.add(radiobuttonFemale);

        JLabel labelEducation = new JLabel("Education : ");
        labelEducation.setBounds(700,250,150,14);
        labelEducation.setFont(new Font("Raleway", Font.BOLD, 14));
        add(labelEducation);
        String education [] = {"Non-Graduate","Graduate","Post-Graduate", "Doctrate", "Others"};
        comboBox4 = new JComboBox(education);
        comboBox4.setBounds(800,250,400,20);
        add(comboBox4);



        JLabel labelEmail = new JLabel("Email address :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        labelEmail.setBounds(100,300,200,14);
        add(labelEmail);
        textEmail = new JTextField();
        //textEmail.setFont(new Font("Raleway",Font.BOLD, 14));
        textEmail.setBounds(220,300,400,20);
        add(textEmail);

        JLabel labelOccupation = new JLabel("Occupation : ");
        labelOccupation.setBounds(700,300,150,14);
        labelOccupation.setFont(new Font("Raleway", Font.BOLD, 14));
        add(labelOccupation);
        String Occupation [] = {"Salaried","Self-Employed","Business", "Student", "Retired", "Other"};
        comboBoxOccupation = new JComboBox(Occupation);
        comboBoxOccupation.setBounds(800,300,400,20);
        add(comboBoxOccupation);

        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 14));
        labelMs.setBounds(100,350,200,14);
        add(labelMs);
        radiobuttonMarried = new JRadioButton("Married");
        radiobuttonMarried.setBounds(220,350,100,14);
        radiobuttonMarried.setBackground(new Color(255,255,255));
        //radiobuttonMarried.setFont(new Font("Raleway", Font.BOLD,14));
        add(radiobuttonMarried);
        radiobuttonUnmarried = new JRadioButton("Unmarried");
        radiobuttonUnmarried.setBounds(320,350,100,14);
        radiobuttonUnmarried.setBackground(new Color(255,255,255));
        //radiobuttonUnmarried.setFont(new Font("Raleway", Font.BOLD,14));
        add(radiobuttonUnmarried);
        radiobuttonOthers = new JRadioButton("Other");
        radiobuttonOthers.setBounds(420,350,100,14);
        radiobuttonOthers.setBackground(new Color(255,255,255));
       // radiobuttonOthers.setFont(new Font("Raleway", Font.BOLD,14));
        add(radiobuttonOthers);
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radiobuttonMarried);
        buttonGroup1.add(radiobuttonUnmarried);
        buttonGroup1.add(radiobuttonOthers);

        JLabel labelPan = new JLabel("PAN Number : ");
        labelPan.setBounds(700,350,150,14);
        labelPan.setFont(new Font("Raleway", Font.BOLD, 14));
        add(labelPan);
        textfieldPan = new JTextField();
        textfieldPan.setBounds(800,350,400,20);
        add(textfieldPan);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 14));
        labelAdd.setBounds(100,400,100,14);
        add(labelAdd);
        textAdd = new JTextField();
        //textAdd.setFont(new Font("Raleway",Font.BOLD, 14));
        textAdd.setBounds(220,400,400,20);
        add(textAdd);

        JLabel labelAadhar = new JLabel("Aadhar No: ");
        labelAadhar.setBounds(700,400,180,14);
        labelAadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        add(labelAadhar);
        textfieldAadhar = new JTextField();
        textfieldAadhar.setBounds(800,400,400,20);
        add(textfieldAadhar);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 14));
        labelCity.setBounds(100,450,200,20);
        add(labelCity);
        textcity = new JTextField();
        //textcity.setFont(new Font("Raleway",Font.BOLD, 14));
        textcity.setBounds(220,450,400,20);
        add(textcity);

        JLabel labelSeniorCitizen = new JLabel("Senior Citizen : ");
        labelSeniorCitizen.setBounds(700,450,180,14);
        labelSeniorCitizen.setFont(new Font("Raleway", Font.BOLD, 14));
        add(labelSeniorCitizen);
        r1 = new JRadioButton("Yes");
        r1.setBounds(850,450,100,20);
        r1.setBackground(Color.WHITE);
        add(r1);
        r2 = new JRadioButton("No");
        r2.setBackground(Color.WHITE);
        r2.setBounds(950,450,100,20);
        add(r2);
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(r1);
        buttonGroup2.add(r2);

        JLabel labelPin = new JLabel("Pin Code :");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 14));
        labelPin.setBounds(100,500,200,14);
        add(labelPin);
        textPin = new JTextField();
        //textPin.setFont(new Font("Raleway",Font.BOLD, 14));
        textPin.setBounds(220,500,400,20);
        add(textPin);

        JLabel labelExistingAccount = new JLabel("Existing Acc: ");
        labelExistingAccount.setBounds(700,500,180,14);
        labelExistingAccount.setFont(new Font("Raleway", Font.BOLD, 14));
        add(labelExistingAccount);
        e1 = new JRadioButton("Yes");
        e1.setBackground(Color.WHITE);
        e1.setBounds(800,500,100,20);
        add(e1);
        e2 = new JRadioButton("No");
        e2.setBackground(Color.WHITE);
        e2.setBounds(900,500,100,20);
        add(e2);
        ButtonGroup GroupButtons=new ButtonGroup();
        GroupButtons.add(e1);
        GroupButtons.add(e2);

        JLabel labelstate = new JLabel("State :");
        labelstate.setFont(new Font("Raleway", Font.BOLD, 14));
        labelstate.setBounds(100,550,200,14);
        add( labelstate);
        textState = new JTextField();
        //textState.setFont(new Font("Raleway",Font.BOLD, 14));
        textState.setBounds(220,550,400,20);
        add(textState);

        buttonNext = new JButton("Next");
        buttonNext.setFont(new Font("Raleway",Font.BOLD, 14));
        buttonNext.setBackground( new Color(12, 53, 158));
        buttonNext.setForeground(Color.WHITE);
        buttonNext.setBounds(700,600,80,20);
        buttonNext.addActionListener(this);
        add(buttonNext);

        buttonBack = new JButton("Back");
        buttonBack.setFont(new Font("Raleway",Font.BOLD, 14));
        buttonBack.setBackground( new Color(12, 53, 158));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBounds(600,600,80,20);
        buttonBack.addActionListener(this);
        add(buttonBack);

        setLayout(null);
       //setSize(750,480);
       setSize(1550,1080);
        getContentPane().setBackground(Color.white);
      // setLocation(250,100);
       setLocation(0,0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PersonalDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = FormNO;
        String name = textName.getText();
        String fathername = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(radiobuttonMale.isSelected()){
            gender = "Male";
        }else if (radiobuttonFemale.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText();
        String marital =null;
        if (radiobuttonMarried.isSelected()){
            marital = "Married";
        } else if (radiobuttonUnmarried.isSelected()) {
            marital = "Unmarried";
        } else if (radiobuttonOthers.isSelected()) {
            marital = "Other";
        }
        String address = textAdd.getText();
        String city = textcity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();
        String religion = (String) comboBoxReligion.getSelectedItem();
        String category = (String) comboBoxCateory.getSelectedItem();
        String income = (String) comboBoxIncome.getSelectedItem();
        String education = (String) comboBox4.getSelectedItem();
        String occupation = (String) comboBoxOccupation.getSelectedItem();
        String pan = textfieldPan.getText();
        String addhar = textfieldAadhar.getText();
        String scitizen = " ";
        if (r1.isSelected()){
            scitizen = "Yes";
        } else if (r2.isSelected()) {
            scitizen ="No";
        }
        String eAccount = " ";
        if (r1.isSelected()){
            eAccount = "Yes";
        } else if (r2.isSelected()) {
            eAccount ="No";
        }

        try{
            if(e.getSource()==buttonNext){
            if (textName.getText().equals("")||textfieldPan.getText().equals("") || textfieldAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(textName, "Fill all the fields");
            }else {
                Connect con = new Connect();
                String query = "insert into PersonalDetails values('"+formno+"', '"+name+"','"+fathername+"','"+dob+"','"+gender+"','"+email+"','"+marital+"', '"+address+"', '"+city+"','"+pincode+"','"+state+"','"+religion+"', '"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+addhar+"','"+scitizen+"','"+eAccount+"')";
                con.statement.executeUpdate(query);
                new AccountDetails(formno);
                setVisible(false);
            }}
            else if(e.getSource()==buttonBack){
                new Login();
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }
}
