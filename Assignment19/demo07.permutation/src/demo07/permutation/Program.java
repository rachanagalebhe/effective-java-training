package demo07.permutation;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=8;
		int r=3;
		
		System.out.println("please wait...");
		
		long start=System.currentTimeMillis();
		int p = permutationAsync(n, r);
		long end=System.currentTimeMillis();
		
		System.out.println("permutation is "+p);
		System.out.println("total time taken in "+(end-start)+" ms");
		
		
		
		
	}
	
	private static int permutationAsync(int n, int r) {
		
		Factorial fn=new Factorial(n);       //this will take 8 seconds
		Factorial fn_r=new Factorial(n-r);   // this will take 5 seconds
		
		int p= fn.getResult()/fn_r.getResult();
		
		return p;
	}
	
	

	private static int permutationAsync01(int n, int r) {
		
		Factorial fn=new Factorial(n);       //this will take 8 seconds
		Factorial fn_r=new Factorial(n-r);   // this will take 5 seconds
		
		ThreadUtils.waitAll(
				fn.getThread(),
				fn_r.getThread());
		
		int p= fn.getResult()/fn_r.getResult();
		
		return p;
	}
	
	private static int permutationSync(int n, int r) {
		int fn=Factorial.calculate(n);       //this will take 8 seconds
		int fn_r=Factorial.calculate(n-r);   // this will take 5 seconds
		int p= fn/fn_r;
		return p;
	}

}
