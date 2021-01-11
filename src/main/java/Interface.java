import javax.swing.*;
import java.awt.*;

public class Interface {

    static GraphicsConfiguration gc;


    static JFrame f = new JFrame(gc);

    public Interface() {
        f.getContentPane().add(new Signin_menu());
        f.setSize(new Dimension(600, 500));
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void launch_account_menu() {
        JFrame acc_f = new JFrame(gc);
        acc_f.getContentPane().add(new Create_acc_menu());
        acc_f.setVisible(true);
        acc_f.setSize(new Dimension(600, 500));
    }

    public static void launch_main_menu() {
        JFrame m = new JFrame(gc);
        m.getContentPane().add(new Menu());
        m.setVisible(true);
        m.setSize(new Dimension(1024,768));
        m.setPreferredSize(new Dimension(1024,768));
    }

}
