    class Ksiazka {
        String tytul;
        String autor;
}

    class KsiazkaTester{
        public static void main(String[] args) {

            Ksiazka[] mojeKsiazki = new Ksiazka[3];
            mojeKsiazki[0]= new Ksiazka();
            mojeKsiazki[1]= new Ksiazka();
            mojeKsiazki[2]= new Ksiazka();

            mojeKsiazki[0].tytul = "czterej koderzy i Java";
            mojeKsiazki[1].tytul = "Java nocy letniej";
            mojeKsiazki[2].tytul = "Java receptury";
            mojeKsiazki[0].autor =  "janek";
            mojeKsiazki[1].autor = "wilhelm";
            mojeKsiazki[2].autor = "ian";

            int x = 0;
            while (x<3){
                System.out.println(mojeKsiazki[x].tytul);
                System.out.println("autor");
                System.out.println(mojeKsiazki[x].autor);
                x= x +1;
            }
        }
    }