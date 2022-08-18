import java.io.*;
import java.util.*;
public class Day4_Power {
	static int answer = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int T = 1; T<=10; T++) {
        	int testcase = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	answer = N;
        	sb.append("#").append(T).append(" ").append(pow(N, M)).append("\n");
        }
        System.out.println(sb);
	}
	static int pow(int n, int m) {
		if(m == 1) {
			return n;
		}
		return pow(answer * n, m-1);
	}
}
