import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Random random=new Random();
		Scanner scan=new Scanner(System.in);
		
		int N=scan.nextInt();
		int[] stack=new int[N];
		int K=scan.nextInt();
		long time=System.currentTimeMillis();
		
		for(int i=0; i<N; i++) {
			stack[i]=random.nextInt(N)+1;
		}
		for(int i=0; i<K; i++) {
			int a=random.nextInt(N)+1;
			int b=random.nextInt(N)+1;
			if(a>b) {
				int tmp=a;
				a=b;
				b=tmp;
			}
			int max=stack[a-1];
			int min=stack[a-1];
			long sum=0;
			
			for(int j=(a-1); j<b; j++) {
				if(stack[j]<min) {
					min=stack[j];
				}
				if(stack[j]>max) {
					max=stack[j];
				}
				sum+=stack[j];
			}
			
			System.out.println(a+"부터"+b+"구간의 최소값="+min+" 최댓값="+max+" 합계="+sum);
		}
		System.out.println(System.currentTimeMillis()-time+"ms");
		scan.close();
	}
}
