import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * chapter 4-8
 * @author xuanyu
 */
public class Deprecated {
    public static void main(String[] args) {
        Thread run = new Thread(new Runnable() {
            @Override
            public void run() {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                while (true){
                    System.out.println(Thread.currentThread().getName()+"Run at"+dateFormat.format(new Date()));
                    SleepUtils.second(2);
                }
            }
        }, "run");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        run.setDaemon(true);
        run.start();
        SleepUtils.second(10);
        run.suspend();
        System.out.println("main suspend :"+dateFormat.format(new Date()));
        SleepUtils.second(2);
        run.resume();
        System.out.println("main resume :"+dateFormat.format(new Date()));

        run.stop();
        SleepUtils.second(2);
        System.out.println("main stop :"+dateFormat.format(new Date()));
        SleepUtils.second(2);





    }
}
