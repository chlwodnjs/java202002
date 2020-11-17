import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Main {
		
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in); 
		int n = Integer.parseInt(scan.next().trim()); 
		int rear=0; 
		Queue<Integer> queue = new LinkedList<Integer>();

		for(int i = 0; i<=n; i++) {
			String cmd =scan.nextLine().trim();
			if(cmd.contains("push")){
				int key=Integer.parseInt(cmd.substring(5,cmd.length()));
				rear=key;
				queue.offer(key);
			}
			else if(cmd.contains("pop")){
				if(queue.size()==0) {
					System.out.println(-1);
				}
				else {
					System.out.println(queue.poll());
				}
			}
			else if(cmd.contains("front"))
				if(queue.size()==0) {
					System.out.println(-1);
				}
				else {
					System.out.println(queue.peek());
				}
			else if(cmd.contains("back")){
				if(queue.size()==0) {
					System.out.println(-1);
				}
				else {
					System.out.println(rear);
				}
			}
			else if(cmd.contains("empty")) {
				if(queue.size()==0) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			else if(cmd.contains("size")) { 
				System.out.println(queue.size());
			}
		}
		scan.close();
	}
}