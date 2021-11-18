package Kyonggi_Algorithm_Competition;
import java.util.*;
public class _11 {
  public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		int mode = 1000007;
	
		
		dp[0]=1;
		dp[1]=1;
		if(n>=2){
			dp[2]=2;
		}
		if(n>=3){
			dp[3] = 5;
			int ans =	0;					
			for(int i=4; i<=n; i++){
				
				int sum1=0;
				sum1 = (dp[i-1]  + dp[i-2] + dp[i-3]*2 ) % mode;						
				ans= (ans + dp[i-4]*2)%mode;
				dp[i] = (sum1 + ans) % mode;
			}
			
		}
		
		System.out.println(dp[n]);
		
	}
}
