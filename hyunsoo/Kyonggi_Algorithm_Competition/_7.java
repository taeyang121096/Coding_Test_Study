package Kyonggi_Algorithm_Competition;
import java.util.*;
public class _7 {
  public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[5000];
		dp[1]=1;
		dp[4]=2;
		dp[5]=1;
		dp[9]=2;
		dp[10]=1;
		dp[40]=2;
		dp[50]=1;
		dp[90]=2;
		dp[100]=1;
		dp[400]=2;
		dp[500]=1;
		dp[900]=2;
		dp[1000]=1;
		
		for(int i=2; i<5000; i++){
			
			if(dp[i]==0){
				int tmp = i;
				
				if(tmp>=1000){
					while(tmp>=1000){
						dp[i] += dp[1000];
						tmp -=1000;
					}
					dp[i] += dp[tmp];
				}else if(tmp>=900){
					while(tmp>=900){
						dp[i] += dp[900];
						tmp -=900;
					}
					dp[i] += dp[tmp];
				}else if(tmp>=500){
					while(tmp>=500){
						dp[i] += dp[500];
						tmp -=500;
					}
					dp[i] += dp[tmp];
				}else if(tmp>=400){
					while(tmp>=400){
						dp[i] += dp[400];
						tmp -=400;
					}
					dp[i] += dp[tmp];
				}else if(tmp>=100){
					while(tmp>=100){
						dp[i] += dp[100];
						tmp -=100;
					}
					dp[i] += dp[tmp];
				}else if(tmp>=90){
					while(tmp>=90){
						dp[i] += dp[90];
						tmp -=90;
					}
					dp[i] += dp[tmp];
				}else if(tmp>=50){
					while(tmp>=50){
						dp[i] += dp[50];
						tmp -=50;
					}
					dp[i] += dp[tmp];
				}else if(tmp>=40){
					while(tmp>=40){
						dp[i] += dp[40];
						tmp -=40;
					}
					dp[i] += dp[tmp];
				}else if(tmp>=10){
					while(tmp>=10){
						dp[i] += dp[10];
						tmp -=10;
					}
					dp[i] += dp[tmp];
				}else if(tmp>=5){
					while(tmp>=5){
						dp[i] += dp[5];
						tmp -=5;
					}
					dp[i] += dp[tmp];
				}else{
					dp[i] =dp[i-1]+1;
				}
				
			}
		}
		int[] ans = new int[5000];
		
		for(int i=1; i<5000; i++){
			ans[dp[i]]++;
		}
		
		System.out.print(ans[N]);
	}
}
