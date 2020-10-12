import java.util.Scanner;

public class Main {
	public static boolean isValid(String str) {
		
		char[] stack=new char[1024];
		int top=-1;
		
		for(int i =0; i<str.length(); i++) {
			char ch=str.charAt(i);
			if(ch == '(' || ch=='{' || ch=='[') {
				stack[++top]=ch;
			}
			
			else if(ch==')') {
				if(top==-1 || stack[top]!='(' ) return false;
				top--;
			}
			else if(ch=='}') {
				if(top==-1 || stack[top]!='{' ) return false;
				top--;
			}
			else if(ch==']') {
				if(top==-1 || stack[top]!='[' ) return false;
				top--;
			}
		}
		return top==-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scan = new Scanner(System.in);
		int T=scan.nextInt();
		
		for (int x=0; x<T; x++) {
			
			String abc=scan.next();
			
			if(isValid(abc)) System.out.println("YES");
			else System.out.println("NO");
			
		}
		
		
	}

}
