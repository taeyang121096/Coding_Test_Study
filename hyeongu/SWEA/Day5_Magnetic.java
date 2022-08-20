import java.io.*;
import java.util.*;
public class Day5_Magnetic {
	static int answer = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int T = 1; T<=10; T++) {
        	int testcase = Integer.parseInt(br.readLine());
        	int[][] arr = new int [100][100];
        	int count = 0;
        	for(int i = 0; i<100; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j = 0; j<100; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	for(int i = 0; i<100; i++) {
        		boolean flag = false;
        		for(int j = 0; j<100; j++) {
        			if(arr[j][i] == 0) {
        				continue;
        			} 
        			if(!flag){
        				if(arr[j][i] == 1) {
        					flag = true;
        				}
        			}
        			else {
        				if(arr[j][i] == 2) {
        					flag = false;
        					count++;
        				}
        			}
        		}
        	}
        	sb.append("#").append(T).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
	}
}
