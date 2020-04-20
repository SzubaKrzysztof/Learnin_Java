import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {


    public Main() {
        initComponents();
    }
    public void initComponents() {
        this.setTitle("");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(pasekNarzędzi, BorderLayout.NORTH);
        pasekNarzędzi.add(new KolorowyButton(new ActionColor("zmieniam kolor na zielony", new ImageIcon("zielony.gif"), Color.GREEN)));
        pasekNarzędzi.add(new KolorowyButton(new ActionColor("zmieniam kolor na niebieski", new ImageIcon("niebieski.gif"), Color.BLUE)));
        pasekNarzędzi.add(new KolorowyButton(new ActionColor("zmieniam kolor na czerwony", new ImageIcon("czerwony.gif"), Color.RED)));
        pasekNarzędzi.add(wlaczMalowanie);

    }
    private class ActionColor extends AbstractAction{

        public ActionColor(String toolTip, ImageIcon icon, Color colour) {          // ten konstruktor zosatł stworzony automatycznnie
            this.putValue(Action.SHORT_DESCRIPTION, toolTip);
            this.putValue(Action.SMALL_ICON, icon);
            this.putValue("kolor", colour);
        }

//        public void ActionColor(String toolTip, Icon icon, Color colour) {                // z jakiegoś powodu program odrzucił ten konstrukotr
//            this.putValue(Action.SHORT_DESCRIPTION, toolTip);
//            this.putValue(Action.SMALL_ICON, icon);
//            this.putValue("kolor", colour);
//        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    private class KolorowyButton extends JButton {
        public KolorowyButton(ActionColor actionColor) {
            super(actionColor);
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    ten.setBackground((Color) actionColor.getValue("kolor"));
                    ten.setZaznaczony(true);

                }
            });
        }

        public void setZaznaczony(boolean zazn) {
            this.zaznaczony = zazn;
        }

        KolorowyButton ten = this;
        boolean zaznaczony;

        {
            zaznaczony = false;
        }
    }

    JToolBar pasekNarzędzi = new JToolBar("nazwa toolbara");
    JButton wlaczMalowanie = new JButton("wlacz malowanie");


    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
