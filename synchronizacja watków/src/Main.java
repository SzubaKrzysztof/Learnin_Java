public class Main {
    public static void main ( String[] args ) {
//        Runnable wypisanie = new WypisanieRunnable();
//        Object lock = new Object();
//        Thread watek = new Thread(new WypisanieRunnable(lock), "Watek 1");
//        Thread watek2 = new Thread(new WypisanieRunnable(lock), "Watek 2");
//        watek.start();
//        watek2.start();
        Counter licznik = new Counter();
        Thread watek3 = new Thread(new CounterRunnable(licznik, false, "rosnie"), "rosnie");
        Thread watek4 = new Thread(new CounterRunnable(licznik, true, "maleje"), "maleje");
        watek3.start();
        watek4.start();
    }
}

class WypisanieRunnable implements Runnable {

    private Object lock;
    static String[] msg = {"to", "jest", "wiadomość", " wypisana", "synchronicznie"};

    public WypisanieRunnable ( Object lock ) {
        this.lock = lock;
    }

    public void run(){
        display(Thread.currentThread().getName());

    }
    public  void display ( String threadName ){

        synchronized (lock){
            for (int i = 0; i < msg.length; i++) {
                System.out.println(threadName + " : " + msg[i]);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}
class Counter{
    public void increaseCounter(){
        counter++;
        System.out.println(Thread.currentThread().getName() + ":" + counter);
    }
public void decreaseCounter(){
    counter--;
    System.out.println(Thread.currentThread().getName() + ":" + counter);

}

    private int counter = 50;
}

class CounterRunnable implements Runnable {
    public CounterRunnable ( Counter licznik, boolean increase, String rosnie ) {
        this.licznik = licznik;
        this.increase = increase;
    }
    @Override
    public void run () {
        synchronized (licznik) {


            for (int i = 0; i < 50; i++) {
                if (increase) licznik.increaseCounter();
                else licznik.decreaseCounter();
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());

                }
            }
        }
    }

    boolean increase;
    Counter licznik;

}