import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signin_menu extends JPanel {

    private JButton signin_btn; // button for signing in
    private JButton create_acc_btn; // button for creating new acount
    private final JTextField username_tfield, password_tfield; // text fields for inputting username and password

    private JLabel check = new JLabel();

    public Signin_menu() {
        String url = "https://phabservlet1.herokuapp.com/verify_user";
        setLayout(new GridLayout(10, 1, 1, 1)); // Setting layout grid
        signin_btn = new JButton("Sign in");
        create_acc_btn = new JButton("Create new account");
        signin_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String checktext = (username_tfield.getText().isEmpty() || password_tfield.getText().isEmpty()) ? "Username or password is empty" : "checking login credentials...";
                check.setText(checktext);
                if(checktext.equals("checking login credentials...")) {
                    String get_message = username_tfield.getText()+"@"+password_tfield.getText();
                    SIGNIN_Requests r = new SIGNIN_Requests();
                    String got_message = r.makePostRequest(get_message, url);
                    //check what is returned
                    System.out.println(got_message);
                    if(got_message.equals("Login successful")) {
                        checktext = "Login successful";
                        check.setText(checktext);
                        check.setForeground(Color.green);
                        revalidate();
                        Interface.launch_main_menu();

                    }
                    else {
                        checktext = "Username or password incorrect, try again.";
                        check.setText(checktext);
                        check.setForeground(Color.red);
                    }

                }
                revalidate();

    }
        });
        create_acc_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create account popup
                Interface.launch_account_menu();
            }
            
        });

        /* Gridlayout and adding components */ /*IMPORTANT!! Gridlayout is extremely inefficient, need revising */
        username_tfield = new JTextField("test");
        username_tfield.setPreferredSize(new Dimension(100,30));
        password_tfield = new JTextField("12345678");
        password_tfield.setPreferredSize(new Dimension(100,30));
        check.setForeground(Color.red);
        JLabel title = new JLabel("PHAB Pharmacy Customer App");
        title.setForeground(Color.blue);
        add(title);
        add(new JLabel("Username:"));
        add(username_tfield);
        add(new JLabel("Password:"));
        add(password_tfield);
        add(new JLabel(""));
        add(signin_btn);
        add(create_acc_btn);
        add(check);

        
    }

    

    
    
    
}
