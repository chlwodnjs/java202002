import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int front=0, rear=0, size=10000, top=-1;
		int[] q= new int[size];
		int[] stack= new int[size];
		
		Scanner scan=new Scanner(System.in);
		Random random=new Random();
		int n=scan.nextInt();
		for(int i =0; i<n; i++) {
			q[rear]=random.nextInt(size);
			rear=(rear+1)%size;
		}
		
		while(front!=rear) {
			
			int num=q[front];
			front=(front+1)%size;
			
			while(top!=-1 && stack[top]<num) {
				q[rear]=stack[top--];
				rear=(rear+1)%size;
			
			}
			stack[++top]=num;
		}
		while(top>-1) {
			System.out.println(stack[top--]);
		}
		scan.close();
	}
	
}
