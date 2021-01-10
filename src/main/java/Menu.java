import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel{


    private JPanel deliveryPanel;
    private JPanel storePanel;
    private JPanel branchPanel;
    private String[] branch_list = {"Green Park", "Paddington", "Mile End"};

    Menu() {
        setLayout(new GridLayout(2,1));

        deliveryPanel = new JPanel();
        JButton order_btn = new JButton(" Order Delivery");
        deliveryPanel.add(order_btn);
        storePanel = new JPanel();
        storePanel.setLayout(new GridLayout(1,2));
        JComboBox branch_Selector = new JComboBox<String>(branch_list);
        branchPanel = new JPanel();
        branchPanel.setLayout(new GridLayout(2,1));
        branchPanel.add(branch_Selector);
        ActionListener branchSelectorActionListener = new ActionListener() {//add actionlistener to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) branch_Selector.getSelectedItem();//get the selected item
                String Branch1 = "Paddington";
                String Branch2 = "MileEnd";
                String Branch3 = "GreenPark";

                switch (s) {//check for a match
                    case "Green Park":
                        POST_Requests P = new POST_Requests(Branch3,"https://phabservlet1.herokuapp.com/inputB");
                        System.out.println("Branch selected: Green Park");

                        break;
                    case "Paddington":
                        POST_Requests P2 = new POST_Requests(Branch1,"https://phabservlet1.herokuapp.com/inputB");
                        System.out.println("Branch selected: Paddington");

                        break;
                    case "Mile End":
                        POST_Requests P3 = new POST_Requests(Branch2,"https://phabservlet1.herokuapp.com/inputB");
                        System.out.println("Branch selected: Mile End");
                        break;
                    default:
                        System.out.println("No branch selected, please select a branch");
                        break;
                }
            }
        };

        branch_Selector.addActionListener(branchSelectorActionListener);
        branchPanel.add(new JTextArea("%Availabillty and Price listed here%"));
        storePanel.add(branchPanel);

        JTextArea druglist = new JTextArea("%Drug List here");
        druglist.setEditable(false);
        storePanel.add(druglist);

        add(deliveryPanel);
        add(storePanel);

    }
}
