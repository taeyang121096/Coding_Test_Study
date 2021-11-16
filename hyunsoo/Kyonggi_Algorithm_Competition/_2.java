package Kyonggi_Algorithm_Competition;
import java.util.*;

public class _2 {
  	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[3001];
		
		dp[5]=1;
		
		for(int i=6; i<=3000; i++){
			dp[i] = dp[i-1] + check(i);
		}
		System.out.print(dp[N]);
	}
	
	public static int check(int index){
		int count=0;
		for(int i=1; i<index; i++){
			for(int j=i; j<index; j++){
				
				if(i+j<index) continue;
				int tmp = i*i + j*j;
				
				if(tmp == index*index) {
					count++;
					break;
				}
				if(tmp > index*index) break;
			}
		}
		return count;
	}
}
