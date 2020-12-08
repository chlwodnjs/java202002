import java.util.Scanner;
public class Main {
	static long histo(int[] v, int s, int e){
		if(s==e) return v[s];
		int c= (s+e)/2;
		int r=2;
		long min=(v[c]<v[c+1])?v[c]:v[c+1];
		long max=min*r;
		int i=c-1;
		int j=c+2;
		while(i>=s && j<=e) {
			if(v[i]>v[j]) {
				if(v[i]<min)
					min=v[i];
					i--;
			}
			else {
				if(v[j]<min)
					min=v[j];
					j++;
			}
		}
		while(i>=s) {
			if(v[i]<min)
				min=v[i];
				i--;
			if(max<min*(++r))
				max=min*r;
		}
		while(j<=e) {
			if(v[j]<min)
				min=v[j];
				j++;
			if(max<min*(++r))
				max=min*r;
		}
		long h=(histo(v,s,c)>histo(v,c+1,e))?histo(v,s,c):histo(v,c+1,e);
		max=(max>h)? max:h;
		return max;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] v=new int[100000];
		while(true) {
			int n=scan.nextInt();
			if(n==0) 
				break;
			for(int i=0; i<n; i++)
				v[i]=scan.nextInt();
			System.out.println(histo(v,0,n-1));
		}
	}
}