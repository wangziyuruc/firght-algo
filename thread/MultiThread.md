- chapter 4
- 操作系统调度的最小单元是线程 轻量级进程
- 一个进程可以创建多个线程，每个线程拥有各自的计数器，堆栈和局部变量，并且能够访问共享的内存变量
- java程序天生多线程
- why multi thread:

`好`
- 更多的处理器核心
- 更快的响应时间
- 更好的编程模型

`坏`
- 线程切换时间损耗
- 数据多线程操作的一致性

现代操作系统通常采用时分机制:操作系统分出一个个时间片给线程，当线程的时间片使用完成后即发生线程调度

