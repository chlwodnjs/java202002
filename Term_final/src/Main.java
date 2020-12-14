import java.util.Random;
import java.util.Scanner;

public class Main{

	static long Ssum[]; 
    static int SMin[],SMax[];
    public static void main(String[] args) {
      
        Random rand = new Random(100);
        Scanner scan=new Scanner(System.in);
       
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		int [] arr = new int [N];
		int[] start = new int[K];
        int[] end = new int[K];
        long START = System.currentTimeMillis();
		for(int i=0;i<N;i++) {
			arr[i]=rand.nextInt(N)+1;
		}
        Ssum = new long[N*4];
        SMin=new int[N*4];
        SMax = new int[N*4];
        
        for(int i=0;i<K;i++) {
        	int a=rand.nextInt(N)+1;
        	int b=rand.nextInt(N)+1;
        	if(a>b) {
				start[i]=b;
				end[i]=a;
			}
			else 
			{
				start[i]=a;
				end[i]=b;
			}
      
        }
        init(arr, Ssum, 1, 0, N-1);
    	Mininit(arr, SMin, 1, 0, N-1);
    	Maxinit(arr, SMax,  1, 0, N-1 );
        long[] sumArr = new long[K];
        int[] minArr = new int[K];
        int[] maxArr = new int[K];
        for(int j=0; j<K;j++) {
			sumArr[j]=sum_num(Ssum, 0,N-1,1, start[j], end[j]);
        	minArr[j]=min_num(SMin,1,0,N-1, start[j], end[j]);
        	maxArr[j]=max_num(SMax, 1,0,N-1, start[j], end[j]);
        }  
        long END = System.currentTimeMillis();

        Print(start,end,K,START,END, sumArr, minArr, maxArr);

        scan.close();
    }
    public static void Print(int[] a, int[] b,int K, long START, long END, long[] sumArr, int[] minArr, int[] maxArr) {
    	for(int i=0;i<K;i++) {
    		System.out.println("<"+(i+1)+"번째> 구간="+a[i]+"~"+b[i]+" 합계 : "+sumArr[i]+" 최소 : "+minArr[i]+" 최대 : "+maxArr[i]);
    	}
    	System.out.println("걸리는 시간 : "+ (END-START) +"ms");
    }
    public static long init(int[] arr, long[] Ssum, int node, int start, int end) {
        if(start == end) { 
            return Ssum[node] = arr[start];
        }
 
        return Ssum[node] = init(arr, Ssum, node*2, start, (start+end)/2) + init(arr, Ssum, node*2+1, (start+end)/2+1, end);
    }
    static long sum_num(long[] Ssum, int start, int end, int node, int left, int right) {
        if(left>end || right < start) {
            return 0;
        }
        if(left <=start && end <=right) {
            return Ssum[node];
        }
        
         
        return sum_num(Ssum, start, (start+end)/2, node*2, left, right) + sum_num(Ssum, (start+end)/2+1, end, node*2+1, left, right);
    }
    static int Mininit(int[] arr, int[] SMin, int node, int start, int end){
		if(start == end){
			return SMin[node]=arr[start];
		}
		
		return SMin[node]= Math.min(Mininit(arr, SMin, node*2, start, (start+end)/2) , Mininit(arr, SMin, node*2+1, (start+end)/2+1, end));
	}
    static int min_num(int[] SMin, int node, int start, int end, int left, int right){
		if(start>right || end<left){
			return Integer.MAX_VALUE;
		}
		if(left<=start && end<=right){
			return SMin[node];
		}
		 
		
		return Math.min(min_num(SMin, node*2,start,(start+end)/2,left,right), min_num(SMin, node*2+1,(start+end)/2+1,end,left,right));
	}
    static int Maxinit(int[] arr, int[] SMax, int node, int start, int end){
		if(start == end){
			return SMax[node]=arr[start];
		}
		
		 
		
		return SMax[node]= Math.max(Maxinit(arr, SMax, node*2, start, (start+end)/2) , Maxinit(arr, SMax, node*2+1, (start+end)/2+1, end));
	}
    static int max_num(int[] SMax, int node, int start, int end, int left, int right){
		if(start>right || end<left){
			return Integer.MIN_VALUE;
		}
		if(left<=start && end<=right){
			return SMax[node];
		}
		 
		
		return Math.max(max_num(SMax, node*2,start,(start+end)/2,left,right), max_num(SMax, node*2+1,(start+end)/2+1,end,left,right));
	}
}