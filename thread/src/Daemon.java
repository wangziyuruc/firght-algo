/**
 * chapter 4-5
 * @author xuanyu
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();

        while (true){

        }
    }

    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                while (true){
                    SleepUtils.second(100);

                }
            }finally {
                System.out.println("DaemonRunner finally run");
            }
        }
    }
}
