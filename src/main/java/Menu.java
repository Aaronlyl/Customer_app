import javax.swing.*;

import java.awt.*;

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
        branchPanel.add(new JTextArea("%Availabillty and Price listed here%"));
        storePanel.add(branchPanel);
        storePanel.add(new JTextArea("%Drug List here"));

        add(deliveryPanel);
        add(storePanel);

    }
}
