package suwaki;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowListener;

public class Main extends JFrame {


    public Main() {
        initComponents();
    }
             public void initComponents() {
              this.setTitle("");
                 this.setSize(900,900);
//                 this.setExtendedState(MAXIMIZED_BOTH);
                  this.setDefaultCloseOperation(3);
                    this.getContentPane().add(panel, BorderLayout.SOUTH);
                 this.getContentPane().add(cos, BorderLayout.CENTER);
                      panel.add(suwak1, BorderLayout.NORTH);
                         panel.add(watoscSuwaka, BorderLayout.PAGE_END);

                         suwak1.setPreferredSize(new Dimension(600, 200));
                         setLayout(new GridLayout());
                         watoscSuwaka.setEditable(true);
                         watoscSuwaka.setPreferredSize(new Dimension(200,20));
                 setLayout(new GridLayout());
                         suwak1.setSize(80,10);
                        suwak1.setMajorTickSpacing(5);
                        suwak1.setSnapToTicks(true);
                        suwak1.setMinorTickSpacing(1);
                        suwak1.setSnapToTicks(true);
                        suwak1.setPaintTicks(true);
                        suwak1.setPaintLabels(true);
                        suwak1.addChangeListener(new ChangeListener() {
                            @Override
                            public void stateChanged(ChangeEvent e) {
                               watoscSuwaka.setText(""+((JSlider) e.getSource()).getValue());
                               cos.setFont(new Font(cos.getFont().getFontName(), cos.getFont().getStyle(),((JSlider) e.getSource()).getValue() ));
                            }
                        });
    }

    private JPanel panel = new JPanel();
    private JSlider suwak1 = new JSlider(JSlider.HORIZONTAL);
    JTextField watoscSuwaka = new JTextField("" + suwak1.getValue());
    JLabel cos = new JLabel("costam costam");


    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
