package Kyonggi_Algorithm_Competition;
import java.util.*;
public class _4 {
  public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		double[] arr=  new double[n];
		
		for(int i=0; i<n; i++){
			arr[i] = sc.nextDouble();
		}
		Arrays.sort(arr);
		
		double sum=0;
		
		for(int i=n/5; i< 4*n/5; i++){
			sum+= arr[i];
		}
		
		double ans = sum/(n*3/5);
		
		System.out.print(String.format("%.2f",ans));
	}
}

