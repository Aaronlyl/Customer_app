import javax.swing.*;
import java.awt.*;

public class Interface {

    static GraphicsConfiguration gc1;
    static GraphicsConfiguration gc2;


    static JFrame f = new JFrame(gc1);

    public Interface() {
        f.getContentPane().add(new Signin_menu());
        f.setSize(new Dimension(600, 500));
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void launch_account_menu() {
        JFrame acc_f = new JFrame(gc2);
        acc_f.getContentPane().add(new Create_acc_menu());
        acc_f.setVisible(true);
        acc_f.setSize(new Dimension(600, 500));
    }

}
