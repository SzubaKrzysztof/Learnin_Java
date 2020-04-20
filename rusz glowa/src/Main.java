 class Krasomowca {

    public static void main(String[] args) {
        String[] listaSlow1 = { "arcitektura wielowarstwowa", "30000 metrow", "rozwiazanie b-0-b", "aplikacja klejnnicka", "interfejs internetowy", " inteligentna karta",  "rozwiazenie synamiczne", "szesc sigma", "przenikliwosc"};
        String[] listaSlow2 = { "zwieksza mozliwosc", "poprawia atrakcyjnosc", "pomnaza wartosc", "opracowania dla", "bazujaca na", "rozproszona", "sieciowa", "skoncentrowana na", "podniesiona na wyzszy poziom", "udistepniona"};
        String[] listaSlow3 = {"procesu", "punktu wpisywania", "rozwiazania", "strategii", "paradygmatu", "portalu", "witryny", "wersji", "misji",};

        int lista1Dlugosci = listaSlow1.length;
        int lista2Dlugosci = listaSlow2.length;
        int lista3Dlugosci = listaSlow3.length;

        int rnd1 = (int) (Math.random() * lista1Dlugosci);
        int rnd2 = (int) (Math.random() * lista2Dlugosci);
        int rnd3 = (int) (Math.random() * lista3Dlugosci);

        String zdanie = listaSlow1[rnd1] + " " + listaSlow2[rnd2] + " " + listaSlow3[rnd3];


        System.out.println("to jest to, czego nam trzba: 6t" + zdanie);
    }
}
