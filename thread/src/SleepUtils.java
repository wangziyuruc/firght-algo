import java.util.concurrent.TimeUnit;

/**
 * chapter 4-4
 * @author xuanyu
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

