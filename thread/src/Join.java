/**
 * chapter 4-13
 * @author xuanyu
 */
public class Join {

    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i = 0; i<10;i++){
            Thread thread = new Thread(new Domin(previous),String.valueOf(i));
            thread.start();
            previous = thread;
        }
        SleepUtils.second(5);
        System.out.println(Thread.currentThread().getName()+" terminal");

    }

    static class Domin implements Runnable{
        Thread thread;

        public Domin(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" terminal");
        }
    }
}
