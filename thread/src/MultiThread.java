import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 *  chapter 4-1
 *  操作系统调度的最小单元是线程 轻量级进程
 *  一个进程可以创建多个线程，每个线程拥有各自的计数器，堆栈和局部变量，并且能够访问共享的内存变量
 *  java程序天生多线程
 * [7] JDWP Command Reader
 * [6] JDWP Event Helper Thread
 * [5] JDWP Transport Listener: dt_socket
 * [4] Signal Dispatcher // 分发处理发送给jvm信号的线程
 * [3] Finalizer // 调用对象finalize方法的线程
 * [2] Reference Handler // 清除reference的线程
 * [1] main // main线程，用户程序入口
 * @author xuanyu
 */
public class MultiThread {
    public static void main(String[] args) {
        // 获取java线程管理
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronize 紧获取线程和堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        // 遍历线程信息 仅打印线程ID和线程名称信息
        for(ThreadInfo threadInfo : threadInfos){
            System.out.println("["+threadInfo.getThreadId()+"] " + threadInfo.getThreadName());
        }
    }
}
