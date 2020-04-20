package okna;



import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class nowaRamka extends JFrame {


    public nowaRamka() {
        initComponents();
    }


    public void initComponents() {
        this.setTitle("nowe okno");
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(900,900);
        this.setBackground(Color.GREEN);

        this.setDefaultCloseOperation(2);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
            }
        });
        this.getContentPane().add(panel);
        this.pack();

    }

    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JFrame okno1 = new JFrame("nowe okno");


    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}

