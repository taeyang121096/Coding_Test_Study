import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N =  Integer.parseInt(br.readLine());
            int[] arr = new int[101];
            int left = 101;
            int right = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i<100; i++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[tmp]++;
                if(tmp<left){
                	left = tmp;
                }
                if(tmp > right){
                	right = tmp;
                }
            }
            while(N-- > 0 && left<right){
                arr[right]--;
                arr[right-1]++;
                arr[left]--;
                arr[left+1]++;
                if(arr[right] == 0){
                	right--;
                }
                if(arr[left] == 0){
                	left++;
                }
            }
            int answer = right - left;
            System.out.println("#" + test_case + " " + answer);
		}
	}
}