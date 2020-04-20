
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame {


    public Main() {
        initComponents();
    }
    public void initComponents() {
        this.setTitle("Menu kontekstowe");
        this.setSize(900,900);
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(testowy, BorderLayout.SOUTH);
        JPopupMenu manuKontekstowe = new JPopupMenu();
     //   manuKontekstowe.add(new JMenuItem("zamknij"));        //sposób dłuższy
        manuKontekstowe.add(new AbstractAction("Zamknij") {         //sposób dużo szybszy gdzie od razu dajemy nazwe i pryzpiujemy akcję
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        manuKontekstowe.add(new JMenuItem("kopia"));
        manuKontekstowe.add(new JMenuItem("co to?"));
        manuKontekstowe.add(new JMenuItem("wklej"));
        this.getContentPane().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("puszczam");
               if (e.getClickCount() == 3 && e.getButton() == MouseEvent.BUTTON1 && e.isShiftDown() ){
                   JOptionPane.showMessageDialog(rootPane, "ale klikasz");
               };
                if (e.getButton() == MouseEvent.BUTTON3) {                          //zamiennie stosuje się też if(e.isPopupTriger())
                    manuKontekstowe.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

    }

    private JPanel panel = new JPanel();
    private JButton testowy = new JButton("guzik testowy");

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
