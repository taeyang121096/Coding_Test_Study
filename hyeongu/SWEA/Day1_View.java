import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
			int[] arr = new int[N];
            int answer = 0;
            for(int i = 0; i<N; i++){
            	arr[i] = sc.nextInt();
            }
            for(int i = 2 ; i<N-2; i++){
            	int left = Math.max(arr[i-2] , arr[i-1]);
                int right = Math.max(arr[i + 1], arr[i+2]);
                int max = Math.max(left, right);
                
                if(arr[i] - max > 0){
                    answer += arr[i] - max;
                }
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}