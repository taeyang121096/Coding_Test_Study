package BOJ;

import java.util.*;
import java.io.*;

public class RemoteController_BOJ {
	
	static int n;
	static int m;
	static boolean[] error;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		error = new boolean[10];
		
		if(m != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				int k = Integer.parseInt(st.nextToken());
				error[k] = true;
			}
		}

		if(n == 100) {
			System.out.println(0);
		} else if(m == 10) {
			System.out.println(Math.abs(n - 100));
		} else {
			int answer = Math.abs(n - 100);
			for(int i = 0; i < 1000000; i++) {
				int numBtn = check(i);
				if(numBtn > 0) {
					int upDown = Math.abs(n - i);
					int total = numBtn + upDown;
					answer = Math.min(total, answer);
				}
			}
			System.out.println(answer);
		}
	}

	static int check(int channel) {

		if(channel == 0) {
			if(error[0]) {
				return 0;
			} else {
				return 1;
			}
		}

		int cnt = 0;
		
		while(channel > 0) {
			if(error[channel % 10]) {
				return 0;
			}
			cnt++;
			channel /= 10;
		}
		
		return cnt;
	}
}
