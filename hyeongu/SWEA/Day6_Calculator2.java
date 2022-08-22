import java.io.*;
import java.util.*;

public class Day6_Calculator2 {	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb_answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        for(int T = 1; T<=10; T++) {
        	int N = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine(), "+");
        	
        	// 후위표기식으로 변경
    		String str = st.nextToken();
			sb.append(str.charAt(0));
        	for(int i = 1; i<str.length(); i+=2) {
        		sb.append(str.charAt(i+1));
        		sb.append(str.charAt(i));
        	}
        	
        	while(st.hasMoreElements()) {
        		str = st.nextToken();
    			sb.append(str.charAt(0));
            	for(int i = 1; i<str.length(); i+=2) {
            		sb.append(str.charAt(i+1));
            		sb.append(str.charAt(i));
            	}
            	sb.append("+");
        	}
        	str = sb.toString();
        	sb.setLength(0);
        	        	
        	// 후위표기식 계산
        	Stack<Integer> stack = new Stack<>();
        	for(int i = 0; i<str.length(); i++) {
        		char ch = str.charAt(i);
        		if(ch>='0' && ch<='9') {
        			stack.push(ch - '0');
        		}
        		else if(ch == '+'){
        			stack.push(stack.pop() + stack.pop());
        		}
        		else if(ch == '*') {
        			stack.push(stack.pop() * stack.pop());
        		}
        	}
        	sb_answer.append("#").append(T).append(" ").append(stack.pop()).append("\n");
        }
        System.out.println(sb_answer);
	}
}