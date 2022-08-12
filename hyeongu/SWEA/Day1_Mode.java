import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
            int N = sc.nextInt();
            int[] arr = new int[101];
            
            for(int i = 0; i<1000; i++){
            	arr[sc.nextInt()]++ ;
            }
            int max = 0;
            int max_idx = -1;
            for(int i = 0; i<101;  i++){
            	if(arr[i] >= max){
                	max_idx = i;
                    max = arr[i];
                }
            }
            System.out.println("#" + N + " " + max_idx);
		}
	}
}