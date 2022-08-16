import java.util.*;
import java.io.*;
public class Day2_Sum {	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i<=10; i++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	int[][] arr = new int[100][100];
        	int max = -1;
        	int sum1 = 0;
        	int sum2 = 0;
        	
        	for(int j = 0; j<100; j++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int k = 0; k<100; k++) {
        			arr[j][k] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	for(int j = 0; j<100; j++) {
        		sum1 = 0;
        		sum2 = 0;
        		for(int k = 0; k<100; k++) {
        			sum1 += arr[k][j];
        			sum2 += arr[j][k];
        		}
        		max = Math.max(max, Math.max(sum1, sum2));
        	}
        	
        	sum1 = 0;
    		sum2 = 0;
        	for(int j = 0; j<100; j++) {
        		sum1 += arr[j][j];
        		sum2 += arr[j][99-j];
        	}
        	max = Math.max(max, Math.max(sum1, sum2));
        	
        	sb.append("#").append(i).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
	}
}