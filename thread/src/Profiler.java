/**
 * chapter 4-15
 * @author xuanyu
 */
public class Profiler {

    private static final ThreadLocal<Long> timeThreadLocal = new ThreadLocal<>();

    public static final void begin(){
        timeThreadLocal.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis()-timeThreadLocal.get();
    }
    public static void main(String[] args) {
        Profiler.begin();
        SleepUtils.second(1);
        System.out.println("cost :"+Profiler.end()+"mills");

    }
}
