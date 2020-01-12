/**
 * chapter 4-10
 * @author xuanyu
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class){}
        m();
    }

    public static synchronized void m(){}
}
