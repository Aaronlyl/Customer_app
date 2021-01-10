import com.google.gson.Gson;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {


    private JPanel deliveryPanel;
    private JPanel storePanel;
    private JPanel branchPanel;
    private String[] branch_list = {"Green Park", "Paddington", "Mile End"};
    private JPanel searchForDrug;
    private JButton searchButton;
    private JLabel searchTitle;
    private JLabel itemDetails;
    private JTextField drugDetails;

    Menu() {
        setLayout(new GridLayout(2, 1));
        searchForDrug = new JPanel();
        searchForDrug.setLayout(new GridLayout(8, 1, 10, 10));
        searchTitle = new JLabel("Search for Drug");//create title
        searchForDrug.add(searchTitle);
        // drugName = new JTextField("Enter Drug Name");

        String[] drugSearch = new String[]{"Vicks", "Gsk", "Lemsip", "Sudafed", "Benylin", "E45", "Eurax",
                "Eucerin", "Dermalex", "Cetaphil", "Nurofen", "Cuprofen", "Solpadeine", "Anadin", "Disprin",
                "Dioralyte", "Gaviscon", "Senokot", "Benadryl", "Piriteze", "Beconase", "Dettol",
                "Elastoplast", "TCP"};
        final JComboBox search_drug = new JComboBox(drugSearch);
        search_drug.setEditable(false); // idk if it should be editable
        AutoCompletion.enable(search_drug);
        searchForDrug.add(search_drug);

        String[] drugnameSearch = new String[]{
                // Cold and fllu
                "Vaporub", "First Defence", "Night Nurse", "Night Nurse", "Max",
                "Standard", "Day and Night", "Max", "Mucus relief", "4 flu",
                //Skincare
                "Psoriasis cream", "Skin cream",
                "Skin relief cream", "Face scrub", "Psoriasis cream", "Repair and Restore", "Eczema cream",
                "Eczema cream", "Moisturising cream", "Exfoliating cleanser",
                //Headaches and pain relief
                "Meltlets", "Express", "Max strength",
                "Standard", "Max strength", "Headache", "Extra", "Triple action", "Original", "Soluble",
                //Digestion
                "Blackcurrant", "Lemon", "Chewable", "Max", "Advance",
                //Allergy
                "Relief", "tabs", "Relief",
                //First aid
                "Antiseptic", "Hand sanitizer", "plasters", "Liquid"
        };

        final JComboBox search_drugname = new JComboBox(drugnameSearch);
        search_drugname.setEditable(false); // idk if it should be editable
        AutoCompletion.enable(search_drugname);
        searchForDrug.add(search_drugname);

        // searchForDrug.add(drugName); test
        searchButton = new JButton("Select Item");
        searchForDrug.add(searchButton);
        ActionListener searchButtonAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String manu = search_drug.getSelectedItem().toString().toLowerCase();
                String name = search_drugname.getSelectedItem().toString().toLowerCase();
                String message2 = manu + "@" + name;

                POST_Requests p2 = new POST_Requests(message2, "https://phabservlet1.herokuapp.com/inputMN");
                GET_Requests g = new GET_Requests("https://phabservlet1.herokuapp.com/searchForDrug");
                System.out.println("searchButton pressed ");
                Gson gson = new Gson();
                String jsonString = gson.toJson(g);
                int length2 = jsonString.length() - 2;
                String jsonString2 = jsonString.substring(17, length2);
                drugDetails.setText(jsonString2);
                System.out.println(jsonString);
            }
        };
        searchButton.addActionListener(searchButtonAL);

        itemDetails = new JLabel("Item Details:");//create title
        searchForDrug.add(itemDetails);
        drugDetails = new JTextField("%%Details will show here");
        drugDetails.setEditable(false);
        drugDetails.setBackground(Color.LIGHT_GRAY);
        searchForDrug.add(drugDetails);
        deliveryPanel = new JPanel();
        JButton order_btn = new JButton(" Order Delivery");
        deliveryPanel.add(order_btn);
        storePanel = new JPanel();
        storePanel.setLayout(new GridLayout(1, 2));
        JComboBox branch_Selector = new JComboBox<String>(branch_list);
        branchPanel = new JPanel();
        branchPanel.setLayout(new GridLayout(2, 1));
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
                        POST_Requests P = new POST_Requests(Branch3, "https://phabservlet1.herokuapp.com/inputB");
                        System.out.println("Branch selected: Green Park");

                        break;
                    case "Paddington":
                        POST_Requests P2 = new POST_Requests(Branch1, "https://phabservlet1.herokuapp.com/inputB");
                        System.out.println("Branch selected: Paddington");

                        break;
                    case "Mile End":
                        POST_Requests P3 = new POST_Requests(Branch2, "https://phabservlet1.herokuapp.com/inputB");
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

        add(searchForDrug);
        add(deliveryPanel);
        add(storePanel);
    }
}

