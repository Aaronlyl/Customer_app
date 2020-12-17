import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Create_acc_menu extends JPanel{
    //Probably a more secure idea to remove variables later and directly upload to servlet
    private String usr, pw, c_pw;
    private JButton register_btn;
    private JTextField usr_tfield, pw_tfield, c_pw_tfield ;
    private JLabel check = new JLabel();

    public Create_acc_menu() {
        setLayout(new GridLayout(12,1));
        JLabel title = new JLabel("PHAB Pharmacy Account Registration");
        Color title_col = Color.decode("#3E5641");
        title.setForeground(title_col);
        usr_tfield = new JTextField("1234");
        pw_tfield = new JTextField("1234");
        c_pw_tfield = new JTextField("1234");
        register_btn = new JButton("Register");

        register_btn.addActionListener(new ActionListener() {
            //Add implementation of database here
            @Override
            public void actionPerformed(ActionEvent e) {
                usr = usr_tfield.getText();
                pw = pw_tfield.getText();
                c_pw = c_pw_tfield.getText();

                boolean create_acc = false;
                String checktest;
                if(pw.equals(c_pw) && usr_tfield.getText().isEmpty()==false ) {
                    checktest =  "Account Created" ;
                    create_acc = true;
                    


                } else if(pw_tfield.getText().isEmpty() || c_pw_tfield.getText().isEmpty() || usr_tfield.getText().isEmpty()) {
                    checktest = "Fields must not be empty. Plese retry.";
                   
                } else {
                    checktest = "Account name taken or passwords do not match. Please retry.";
                    

                }
                if(create_acc) {
                    
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