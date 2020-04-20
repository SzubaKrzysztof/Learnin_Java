package rysowanie;

import java.awt.*;
import javax.swing.*;


public class Main extends JFrame
{
    public Main()
    {
        this.setTitle("Rysowanie");
        this.setSize(800,800);
//        this.setExtendedState(MAXIMIZED_BOTH);

        this.getContentPane().add(panelDoRysowania);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new Main().setVisible(true);
    }

    private PanelRysowiak panelDoRysowania = new PanelRysowiak();
}
class PanelRysowiak extends JPanel
{
    public PanelRysowiak()
    {
        super();

        this.add(new JButton("Test"){
            @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

        }

        });
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawString("Napis", 0, 40);

        g.drawImage(new ImageIcon("kropelka.gif").getImage(), 40, 80, null);

        g.drawRect(40, 40, 120, 80);

        g.drawLine(60, 60, 80, 20);
        g.drawRoundRect(150,110,50,50,50,50);
        g.fillOval(40,40,50,50);

        Graphics2D g2 = (Graphics2D)g;

        System.out.println(i++);
    }

    public static int i = 0;
}
