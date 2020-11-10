import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int N=scan.nextInt();
		int a=scan.nextInt();
		int b=scan.nextInt();
		int sum=0;
		int[] array=new int[N];
		Random random=new Random();
		
		for(int i=0; i<N; i++) {
			array[i]=random.nextInt(N)+1;
		}
		System.out.print("생성된 값:");
		for(int i=0; i<N; i++) {
			System.out.print(array[i]+" ");
		}

		int max=array[a-1];
		int min=array[a-1];
		System.out.print("\n구간값:");
		for(int i=a-1; i<b; i++) {
			System.out.print(array[i]+" ");
			if(array[i]>max) {
				max=array[i];
			}
			if(array[i]<min) {
				min=array[i];
			}
			sum+=array[i];
		}
		System.out.println("\nmax="+max);
		System.out.println("min="+min);
		System.out.println("sum="+sum);
		scan.close();
	}

}
