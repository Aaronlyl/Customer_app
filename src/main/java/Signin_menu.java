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
        setLayout(new GridLayout(10, 1, 1, 1)); // Setting layout grid
        signin_btn = new JButton("Sign in");
        create_acc_btn = new JButton("Create new account");
        signin_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String checktext = (username_tfield.getText().isEmpty() || password_tfield.getText().isEmpty()) ? "Username or password is empty" : "checking login credentials...";
                check.setText(checktext);
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
        username_tfield = new JTextField();
        username_tfield.setPreferredSize(new Dimension(100,30));
        password_tfield = new JTextField();
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
