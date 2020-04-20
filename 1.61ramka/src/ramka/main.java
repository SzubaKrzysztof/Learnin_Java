package ramka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//zdarzenia
//import java.sql.Time;

class Main extends JFrame {                                              //główna klasa w programie która pobiera właściwośi JFrmae



        public  Main() {                                                           //kreator
            super("zsarzenia");//tak się dodaje tytuł ramki
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);           // tak się robi    PEŁNY EKRAN!!!!!!!!!!!
            //   this.setUndecorated(true);                              // tak się robi    PEŁNY EKRAN!!!!!!!!!!! TA LINIJKA TYLKO DO GIER GDZI NIE MA ZNACZKU ZAMKNIJ WINDOWSA

            this.setVisible(true);                                  // tak się robi    PEŁNY EKRAN!!!!!!!!!!!
            //    this.setSize(500, 500);        //ustawiamy  wielkość ramiki
            //   this.setLocation(600, 300);        // lokalizacja ramki
            initComponents();                                                   //deklarujemy uruchomienie initComponents

            this.setDefaultCloseOperation(3);                           //mobowiązkowo podajemy zeby program zamknąć

        }

        JPanel panel = new JPanel();                  // najpierw ustawiamy panel potem guziki
        JButton kolorczerwony;
        JButton kolorczarny;
        JLabel etykieta = new JLabel("czas");
        JLabel czas = new JLabel();


        private void initComponents() {
            this.getContentPane().add(panel);                                     //dodajemy i uruchamiamy panel panel
            panel.setBackground(Color.YELLOW);//kolor tła

            kolorczerwony = new JButton("czerwony");                                //dodajemy guzik o nazwei kolorczerwon
            kolorczarny = new JButton("czarny");                                    //dodajemy guzik o nazwei kolorczarny

            kolorczarny.addActionListener(new sluchaczKolorow(Color.BLACK));             //dodajemy funkcje która sprawdza czy guzik został wcisnięty a w nawiasie tworzymy obiekt słuchaczkolorw który pryzjmyje metodę sluchaczkolorow
            kolorczerwony.addActionListener(new sluchaczKolorow(Color.RED));       //dodajemy funkcje która sprawdza czy guzik został wcisnięty a w nawiasie pryzjmyje metodę sluchaczkolorow

            panel.add(kolorczerwony);                                                   //dodajemy do panelu kolor
            panel.add(kolorczarny);
            panel.add(etykieta);
            panel.add(czas);
//        Timer Zegar = new Timer(1000, );

        }


//poniżej klasa która nazywa sie tak jaką funkcję pełni i ma dwie funkcje jedna ustawia jaki ma byc kolor
        // druga zmienia kolor na panelu


        private class sluchaczKolorow implements ActionListener {

            Color Kolor;                                                                    // deklaracja zmiennej Kolor

            private sluchaczKolorow(Color k) {                                               //metoda która zmienia k na kolor jaki sobie ustawiwmy
                this.Kolor = k;
            }

            public void actionPerformed(ActionEvent e) {                                          // metoda która ustawia kolor tła
                panel.setBackground(Kolor);
            }
        }




    public static void main(String[] args) {

        new Main().setVisible(true);        //tutaj musi być w nawiasie "true"
    }
}
