package demo07.permutation;

public class Factorial {
	
	private Thread thread;
	int result;
	
	
	public Factorial(int n) {
		
		//I don't know when this task will complete
		thread= new Thread( () ->  result=calculate(n));
		
		thread.start();
		
	}

	
	public Thread getThread() {
		return thread;
	}

	public int getResult() {
		if(thread.isAlive())
			ThreadUtils.waitAll(thread);
		return result;
	}

	
	public static int calculate(int n) {
		
		int fn=1;
		
		while(n>=1) {
			
			ThreadUtils.sleep(1000);
			fn*=n--;
		}
		
		return fn;
	}

}
