package listyKombinowane;

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
        this.setSize(900,900);
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(panel);
        panel.add(kombincjaa);
        kombincjaa.setFont(new Font(Font.MONOSPACED, 35, 35));
        kombincjaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JComboBox)e.getSource()).setBackground(((kolorHandler)((JComboBox) e.getSource()).getSelectedItem()).getColor ());
            }
        });
    }



    private class kolorHandler{

        private Color kolor;
        private String colorName;


        public kolorHandler(Color kolor, String colorName){
            this.kolor = kolor;
            this.colorName = colorName;
        }
        public String toString() {
            return this.colorName;
        }
        public Color getColor() {
            return this.kolor;
        }
    }

    private JPanel panel = new JPanel();
    String [] czarny = new String[]{"czarny", "niebieski", "zielony"};
   JComboBox kombincjaa = new JComboBox(czarny);


    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}

