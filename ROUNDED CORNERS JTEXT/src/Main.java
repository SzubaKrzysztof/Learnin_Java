

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Main extends JFrame {


    public Main() {
        class RoundJTextField extends JTextField {
            private Shape shape;
            public RoundJTextField(int size) {
                super(size);
                setOpaque(false); // As suggested by @AVD in comment.
            }
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
                super.paintComponent(g);
            }
            protected void paintBorder(Graphics g) {
                g.setColor(getForeground());
                g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            public boolean contains(int x, int y) {
                if (shape == null || !shape.getBounds().equals(getBounds())) {
                    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
                }
                return shape.contains(x, y);
            }
        }

    }

    JFrame frame = new JFrame("Rounded corner text filed demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        frame.setSize(400, 400)
        frame.setLayout(new FlowLayout())
    JTextField field = new RoundJTextField(15);
        frame.add(field)
        frame.setVisible(true)


    public static void main(String[] args) {

    }
}

