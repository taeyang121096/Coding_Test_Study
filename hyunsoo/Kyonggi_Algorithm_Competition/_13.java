package Kyonggi_Algorithm_Competition;
import java.util.*;
import java.io.*;
public class _13 {
	
	static Integer[] arr;
	static int sum=0;
	static int n;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args ) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new Integer[n];
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++){
			arr[i]=Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		Arrays.sort(arr, Collections.reverseOrder());
		// make(0, 0, sum ,sum);
		// System.out.println(answer);
		
		int left = 0;
		int right =0;
	
		for(int i=0; i< arr.length; i++){
			if(left<=right){
				left +=arr[i];
			}else{
				right +=arr[i];
			}
		}
		System.out.println(Math.abs(left-right));
	}
	
// 	public static void make(int index,int tmp, int leave ,int sum){
		
// 		if(answer ==0 ) return;
// 		if(answer > Math.abs(sum-tmp)){
// 			answer = Math.abs(sum-tmp);
// 		}
// 		if(index==n) return;
		
// 		for(int i=index; i<n; i++){
// 			int left = tmp + arr[i];
// 			int right = sum - arr[i];
			
// 			if(left > right){ answer = Math.min(answer, left-right); return;}
// 			if(right - left - leave > answer) return;
			
// 			//if(Math.abs(tmp-sum) > Math.abs(left-right)){
// 			make(i+1, tmp+arr[i], leave - arr[i] ,sum-arr[i]);
// 			//}
// 			make(i+1, tmp, leave - arr[i] ,sum);
// 		}
		
// 	}
}
