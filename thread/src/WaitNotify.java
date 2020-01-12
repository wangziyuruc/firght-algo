/**
 * chapter 4-11
 * @author xuanyu
 */
public class WaitNotify {
    static volatile boolean flag = true;
    static Object lock = new Object();

    private static volatile  int i =0;

    public static void main(String[] args){
        Thread wait = new Thread(new Wait(),"wait");
        Thread notify = new Thread(new Notify(),"notify");
        wait.start();
        SleepUtils.second(2);
        notify.start();
        System.out.println("notify");

    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            while (true){
                synchronized (lock) {
                    if (flag) {
                        try {
                            System.out.println(i);
                            i++;
                            flag = false;
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }


    static class Notify implements Runnable{
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (!flag) {
                        lock.notifyAll();
                        System.out.println(i);
                        i++;
                        flag=true;
                    }

                }
            }
        }
    }
}
