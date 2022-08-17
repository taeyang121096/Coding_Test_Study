// 100 x 100 에서 가장 긴 펠린드럼의 길이를 출력
// 가로, 세로로만 가능
// 펠린드럼의 길이가 홀수, 짝수, 가로, 세로인 경우를 나눠서 구현

import java.io.*;
import java.util.*;
public class Day3_Palindrome2 {	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int T = 1; T<=10; T++) {
        	int N = Integer.parseInt(br.readLine());
        	int count = 0;
        	char[][] arr = new char[100][100];
        	
        	for(int i = 0; i<100; i++) {
        		String str = br.readLine();
        		for(int j = 0; j<100; j++) {
        			arr[i][j] = str.charAt(j);
        		}
        	}
        	
        	for(int i = 0; i<100; i++) {
        		for(int j = 0; j<100;j++) {
        			//홀수 일 때, 가로
        			int k = 0;
        			while(j - k >=0 && j + k <100) {
        				if(arr[i][j-k] == arr[i][j+k]) {
        					k++;
        				}
        				else {
        					break;
        				}
        			}
        			count = Math.max(count, k*2 -1 );
        			
        			//짝수 일 때, 가로
        			k = 0;
        			while(j - k >=0 && j + k + 1<100) {
        				if(arr[i][j-k] == arr[i][j+1+k]) {
        					k++;
        				}
        				else {
        					break;
        				}
        			}
        			count = Math.max(count, k*2);
        			
        			//홀수 일 때, 세로
        			k = 0;
        			while(i - k >=0 && i + k <100) {
        				if(arr[i-k][j] == arr[i+k][j]) {
        					k++;
        				}
        				else {
        					break;
        				}
        			}
        			count = Math.max(count, k*2 -1 );
        			
        			//짝수 일 때, 세로
        			k = 0;
        			while(i - k >=0 && i + k + 1<100) {
        				if(arr[i-k][j] == arr[i+1+k][j]) {
        					k++;
        				}
        				else {
        					break;
        				}
        			}
        			count = Math.max(count, k*2);
        		}
        	}
        	sb.append("#").append(T).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
	}
}
