package Kyonggi_Algorithm_Competition;
import java.util.*;
import java.io.*;
public class _6 {
  static int[] arr;
	static boolean[] visit;
	static boolean made=false;
	static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<5; i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr= new int[9];
			for(int j=0; j<9; j++){
				arr[j]= Integer.parseInt(st.nextToken());
			}
			
			visit = new boolean[9];
			made=false;
			int[] ar = new int[9];
			check(ar,0);
			if(!made) sb.append("NO\n");
		}
		
		System.out.print(sb.toString());
	}
	public static void check(int[] ar, int count){
		
		if(made) return;
		if(count==9){
			sum(ar);
			return;
		}
		
		for(int i=0; i<9; i++){
			if(!visit[i]){
				visit[i]=true;
				ar[count]=arr[i];
				check(ar,count+1);
				visit[i]=false;
			}
		}	
	}
	
	public static void sum(int[] ar){
		int sum1 = ar[0]+ar[1]+ar[2];
		int sum2 = ar[3]+ar[4]+ar[5];
		int sum3 = ar[6]+ar[7]+ar[8];
		int sum4 = ar[0]+ar[3]+ar[6];
		int sum5 = ar[1]+ar[4]+ar[7];
		int sum6 = ar[2]+ar[5]+ar[8];
		int sum7 = ar[0]+ar[4]+ar[8];
		int sum8 = ar[2]+ar[4]+ar[6];
		
		if(sum1==sum2 && sum2==sum3 && sum3==sum4 && sum4==sum5 && sum5==sum6 && sum6==sum7 && sum7==sum8){
			made=true;
			sb.append("YES\n");
		}
	}
}
