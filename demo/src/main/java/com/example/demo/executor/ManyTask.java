package com.example.demo.executor;

public class ManyTask implements Runnable{

	private Integer index;
	public ManyTask(Integer index)
	{
		this.index=index;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开始处理第"+index+"个任务。。。。");
		try {
			Thread.sleep(index*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("我的线程标识是"+this.toString());
		
	}

}
