package com.example.demo.executor;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 11932 这是一个错误的demo
 */
public class TreadPools {

	/**
	 * newCachedThreadPool
	 */
	public static void executenewCachedThreadPool() {
		System.out.println("****************************newCachedThreadPool*******************************");
		System.out.println("创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程");
		for (int i = 0; i < 10; i++) {
			Executors.newCachedThreadPool().execute(new ManyTask(i));
		}
	}

	/**
	 * newFixedThreadPool (每次只有两个线程在处理，当第一个线程执行完毕后，新的线程进来开始处理（线程地址不一样）)
	 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。示例代码如下
	 */
	public static void executenewFixedThreadPool() {
		System.out.println("创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。");
		for (int i = 0; i < 10; i++) {
			Executors.newFixedThreadPool(2).execute(new ManyTask(i));
		}
	}

	/**
	 * newScheduledThreadPool (某线程可以延迟执行)
	 *
	 */
	public static void executenewScheduledThreadPool() {
		System.out.println("\"创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。\"");
		for (int i = 0; i < 10; i++) {
			Executors.newScheduledThreadPool(20).execute(new ManyTask(i));
			Executors.newScheduledThreadPool(20).schedule(new ManyTask(i), 20, TimeUnit.SECONDS);
		}
	}

	/**
	 * newSingleThreadExecutor(顺序执行)
	 */
	public static void executenewSingleThreadExecutor() {
		System.out.println("创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。");
		for (int i = 0; i < 10; i++) {
			Executors.newSingleThreadExecutor().execute(new ManyTask(i));
		}
	}

	/**
	 * ThreadPoolExecutor(推荐) corePoolSize - 线程池核心池的大小。 maximumPoolSize - 线程池的最大线程数。
	 * keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。 unit - keepAliveTime 的时间单位。
	 * workQueue - 用来储存等待执行任务的队列。 threadFactory - 线程工厂。 handler - 拒绝策略。
	 * 
	 * public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long
	 * keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
	 * ThreadFactory threadFactory, RejectedExecutionHandler handler)
	 */
	public static void excuteThreadPoolExecutor() {
		ThreadPoolExecutor executor=new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));
		for (int i = 0; i < 10; i++) {
			executor.execute(new ManyTask(i));
		}
		
	}

	/**
	 * 关注点1 线程池大小 线程池有两个线程数的设置，一个为核心池线程数，一个为最大线程数。
	 * 在创建了线程池后，默认情况下，线程池中并没有任何线程，等到有任务来才创建线程去执行任务，除非调用了prestartAllCoreThreads()或者prestartCoreThread()方法
	 * 当创建的线程数等于 corePoolSize
	 * 时，会加入设置的阻塞队列。当队列满时，会创建线程执行任务直到线程池中的数量等于maximumPoolSize。
	 * 
	 * 关注点2 适当的阻塞队列 java.lang.IllegalStateException: Queue full 方法 抛出异常 返回特殊值 一直阻塞
	 * 超时退出 插入方法 add(e) offer(e) put(e) offer(e,time,unit) 移除方法 remove() poll()
	 * take() poll(time,unit) 检查方法 element() peek() 不可用 不可用
	 * 
	 * ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。 LinkedBlockingQueue ：一个由链表结构组成的有界阻塞队列。
	 * PriorityBlockingQueue ：一个支持优先级排序的无界阻塞队列。 DelayQueue： 一个使用优先级队列实现的无界阻塞队列。
	 * SynchronousQueue： 一个不存储元素的阻塞队列。 LinkedTransferQueue： 一个由链表结构组成的无界阻塞队列。
	 * LinkedBlockingDeque： 一个由链表结构组成的双向阻塞队列。
	 * 
	 * 关注点3 明确拒绝策略 ThreadPoolExecutor.AbortPolicy:
	 * 丢弃任务并抛出RejectedExecutionException异常。 (默认)
	 * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
	 * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
	 * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
	 * 
	 * 说明：Executors 各个方法的弊端： 1）newFixedThreadPool 和 newSingleThreadExecutor:
	 * 主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至 OOM。 2）newCachedThreadPool 和
	 * newScheduledThreadPool: 主要问题是线程数最大数是 Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至 OOM。
	 */
}
