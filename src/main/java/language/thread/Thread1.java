package language.thread;

public class Thread1 extends Thread {
    private String name;

    public Thread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread1 threadTes1 = new Thread1("A");
        Thread1 threadTes2 = new Thread1("B");
        threadTes1.start();
        threadTes2.start();
    }
}
