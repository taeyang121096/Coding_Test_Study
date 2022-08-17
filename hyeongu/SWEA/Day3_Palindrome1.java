import java.io.*;
import java.util.*;
public class Day3_Palindrome1 {	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for(int T = 1; T<=10; T++) {
        	int N = Integer.parseInt(br.readLine());
        	int count = 0;
        	char[][] arr = new char[8][8];
        	
        	
        	for(int i = 0; i<8; i++) {
        		String str = br.readLine();
        		for(int j = 0; j<8; j++) {
        			arr[i][j] = str.charAt(j);
        		}
        	}
        	
        	for(int i = 0; i<8; i++) {
        		for(int j = 0; j<8; j++) {
        			//가로 확인
        			stack.clear();
        			if(j<9-N) {
        				for(int k = j; k<j + N/2;k++) {
        					stack.push(arr[i][k]);
        				}
        				for(int k = j + N - N/2; k<=j + N - 1;k++) {
        					if(stack.peek() == arr[i][k]) {
        						stack.pop();
        					}
        					else {
        						break;
        					}
        				}
        				if(stack.isEmpty()) {
        					count++;
        				}
        			}
        			//세로 확인
        			stack.clear();
        			if(i<9-N) {
        				for(int k = i; k<i + N/2;k++) {
        					stack.push(arr[k][j]);
        				}
        				for(int k = i + N - N/2; k<=i + N -1;k++) {
        					if(stack.peek() == arr[k][j]) {
        						stack.pop();
        					}
        					else {
        						break;
        					}
        				}
        				if(stack.isEmpty()) {
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
