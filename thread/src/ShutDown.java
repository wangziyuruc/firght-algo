/**
 * chapter 4-9
 * @author xuanyu
 */
public class ShutDown {
    public static void main(String[] args) {
        Runner runner = new Runner();
        Runner runner2 = new Runner();
        Thread thread = new Thread(runner, "shutDown-1");
        thread.start();
        SleepUtils.second(2);
        thread.interrupt();
        SleepUtils.second(2);
        System.out.println("interrupt");

        thread = new Thread(runner2, "shutDown-2");

        thread.start();
        System.out.println("cancel");

        runner2.cancel();
        System.out.println("over");
        SleepUtils.second(2);

    }

    static class Runner implements Runnable{
        private int i =0;
        private volatile boolean on = true;
        @Override
        public void run() {

            while (on && !Thread.currentThread().isInterrupted()){
                i++;

            }
            System.out.println("count:"+this.i);


        }

         void cancel(){
            this.on=false;
        }
    }
}
