import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Create_acc_menu extends JPanel{
    //Probably a more secure idea to remove variables later and directly upload to servlet
    private String usr, pw;
    private JButton register_btn;
    private JTextField usr_tfield, pw_tfield, c_pw_tfield ;
    private JLabel check = new JLabel();

    public Create_acc_menu() {
        setLayout(new GridLayout(12,1));
        JLabel title = new JLabel("PHAB Pharmacy Account Registration");
        Color title_col = Color.decode("#3E5641");
        title.setForeground(title_col);
        check.setForeground(Color.red);
        usr_tfield = new JTextField();
        pw_tfield = new JTextField();
        c_pw_tfield = new JTextField();
        register_btn = new JButton("Register");

        register_btn.addActionListener(new ActionListener() {
            //Add implementation of database here
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean create_acc = false;
                String checktest;

                if(pw_tfield.getText().equals(c_pw_tfield.getText()) && usr_tfield.getText().isEmpty()==false ) {
                    if(pw_tfield.getText().length() < 8 ) checktest = "Password length must be longer than 8 characters. Please retry.";
                    else {
                        checktest =  "Account Created" ;
                        create_acc = true;
                        check.setForeground(Color.green);
                    }
                    


                } else if(pw_tfield.getText().isEmpty() || c_pw_tfield.getText().isEmpty() || usr_tfield.getText().isEmpty()) {
                    checktest = "Fields must not be empty. Plese retry.";
                   
                } else {
                    checktest = "Account name taken or passwords do not match. Please retry.";
                    

                }
                if(create_acc) {
                    //Add implementation of database here
                    usr = usr_tfield.getText();
                    pw = pw_tfield.getText();
                }
                check.setText(checktest);
                
                revalidate();
            }

        });

        add(title);
        add(new JLabel("Enter a new username"));
        add(usr_tfield);
        add(new JLabel("Enter a new password"));
        add(pw_tfield);
        add(new JLabel("Confirm password"));
        add(c_pw_tfield);
        add(new JLabel(""));
        add(register_btn);
        add(check);
    }
}