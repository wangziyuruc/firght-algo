/**
 * chapter 4-7
 * @author xuanyu
 */
public class Interrupted {
    public static void main(String[] args) {
        Thread sleep =new Thread(new SleepRunner(),"sleep");
        Thread busy =new Thread(new BusyRunner(),"busy");
        sleep.setDaemon(true);
        busy.setDaemon(true);
        sleep.start();
        busy.start();

        SleepUtils.second(5);

        sleep.interrupt();
        busy.interrupt();
        System.out.println("sleep :"+sleep.isInterrupted());
        System.out.println("busy :"+busy.isInterrupted());

        SleepUtils.second(2);


    }

    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                SleepUtils.second(100);
            }
        }
    }


    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){}
        }
    }
}
