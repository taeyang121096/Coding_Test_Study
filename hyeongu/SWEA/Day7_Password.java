import java.io.*;
import java.util.*;

public class Day7_Password {	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = {1, 2, 3, 4, 5};
        
        for(int T = 1; T<=10; T++) {
        	int testcase = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	Deque<Integer> dq = new ArrayDeque<>();
        	int cnt = 0;
    		
        	for(int i = 0; i<8; i++) {
        		dq.offer(Integer.parseInt(st.nextToken()));
        	}
        	
        	while(true) {
        		int tmp = dq.poll() - arr[(cnt++)%5];
        		if(tmp <= 0) {
        			dq.offer(0);
        			break;
        		}
        		else {
        			dq.offer(tmp);
        		}
        	}
        	
        	sb.append("#").append(T);
        	for(int i = 0; i<8; i++) {
        		sb.append(" ").append(dq.poll());
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
	}
}