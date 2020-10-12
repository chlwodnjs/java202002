import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		Stack<Integer> stack=new Stack<>();
		ArrayList<String> pm=new ArrayList<>();
		
		int num=0;
		for(int i=0;i<N;i++) {
			int x=scan.nextInt();
			if(num<x) {
				for(int j=num;j<x;j++) {
					stack.add(++num);
					pm.add("+");
				}
			}
			else if(num>x) {
				if(stack.peek()==x) {
					stack.pop();
					pm.add("-");
				}
				else break;
			}
			if(num==x) {
				stack.pop();
				pm.add("-");
			}
		}
		if(stack.isEmpty()) {
			for(int i=0; i<pm.size();i++) {
				System.out.println(pm.get(i));
			}
		}
		else System.out.println("NO");
	}

}
