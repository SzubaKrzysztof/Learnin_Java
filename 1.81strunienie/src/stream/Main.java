package stream;

import java.io.*;

public  class Main {
    public Main() throws IOException {
        writer = new FileWriter("nazwaPliku.txt");
        writer.write("lala");
        writer.close();

    }

    public static void main(String[] args) {
        File katalog = new File("coś");
        katalog.mkdir();                            //tworzymy katalog
        File plik = new File("test.txt");
        if (!plik.exists()) {
            try {
                plik.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
InputStream inS;
OutputStream ouS;
Reader reader = new Reader() {
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
};
    Writer writer;
}


