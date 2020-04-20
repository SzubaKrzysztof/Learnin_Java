import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try (PrintWriter drukarz = new PrintWriter(new FileWriter("dodane.txt"))) {
            drukarz.println(12345);
            drukarz.flush();
            drukarz.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
    }
}
