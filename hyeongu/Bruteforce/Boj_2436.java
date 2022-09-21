import java.util.*;
import java.io.*;

public class Boj_2436 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		int G = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] answer = new int[2];
		int tmp = L / G;
		
		for(int a = 1; a <= Math.sqrt(tmp); a++) {
			boolean flag = true;
			if(tmp % a == 0) {
				int b = tmp / a;
				for(int i = 2; i <= Math.sqrt(b) ; i++) {
					if(b % i == 0) {
						if(a % i == 0 || a % (b/i) == 0) {
							flag = false;
							break;
						}
					}
				}				
				
				if(flag) {
					answer[0] = G * a;
					answer[1] = G * b;
				}
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
	}
}
