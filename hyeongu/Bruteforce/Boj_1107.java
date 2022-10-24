import java.util.*;
import java.io.*;

public class Boj_1107 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[10];
		int answer = 1000000;
		
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) {
				arr[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		int down = N;
		int up = N;
		int cnt = 0;
		
		if(N == 100) {
			System.out.println(0);
			return;
		}
		
		while(answer >= cnt) {
			//up을 누를 수 있는지
			String str = Integer.toString(up);
			int i = 0;
			
			for(i = 0 ; i<str.length(); i++) {
				if(arr[str.charAt(i) - '0']) {
					break;
				}
			}
			if(i == str.length()) {
				answer = Math.min(answer, cnt + str.length());
			}

			//down을 누를 수 있는지
			if(down>=0) {
				str = Integer.toString(down);
				
				for(i = 0; i<str.length(); i++) {
					if(arr[str.charAt(i) - '0']) {
						break;
					}
				}
				if(i == str.length()) {
					answer = Math.min(answer, cnt + str.length());
				}
			}
			
			//up이랑 down 이동
			up++;
			down--;
			cnt++;
			
			if(down == 100 || up == 100) {
				answer = cnt;
				break;
			}
		}
		
		System.out.println(answer);
	}
}