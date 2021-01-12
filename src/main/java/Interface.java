import javax.swing.*;
import java.awt.*;

public class Interface {

    static GraphicsConfiguration gc;

    static JFrame f = new JFrame(gc);

    public Interface() {
        f.getContentPane().add(new Signin_menu());
        f.setSize(new Dimension(800, 600));
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void launch_signin_menu() {
        f.getContentPane().removeAll();;
        f.getContentPane().add(new Signin_menu());
        f.setVisible(true);
        f.setSize(new Dimension(800,600));

    }

    public static void launch_account_menu() {
        f.getContentPane().removeAll();
        f.getContentPane().add(new Create_acc_menu());
        f.setVisible(true);
        f.setSize(new Dimension(800, 600));
    }

    public static void launch_main_menu() {
        f.getContentPane().removeAll();
        f.getContentPane().add(new Menu());
        f.setVisible(true);
        f.setSize(new Dimension(1024,768));
        f.setPreferredSize(new Dimension(1024,768));
    }

}
