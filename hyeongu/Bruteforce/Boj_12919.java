import java.util.*;
import java.io.*;

public class Boj_12919 {
	static char[] T;
	static char[] S;
	static int answer = 0;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine().toCharArray();
		T = br.readLine().toCharArray();
		
		make(0, T.length- 1, true);
		
		System.out.println(answer);
	}
	static void make(int start, int end, boolean flag) {
		if(answer == 1) {
			return;
		}
		if(end - start + 1 == S.length) {
			int cnt = 0;
			if(flag) {
				for(int i = start; i<=end; i++) {
					if(T[i] != S[cnt++]) {
						return;
					}
				}
				answer = 1;
				return;
			}
			else {
				for(int i = end; i>=start; i--) {
					if(T[i] != S[cnt++]) {
						return;
					}
				}
				answer = 1;
				return;
			}
		}
		
		if(flag) {
			if(T[start] == 'B') {
				make(start + 1, end, !flag);
			}
			if(T[end] == 'A') {
				make(start, end - 1, flag);
			}
		}
		else {
			if(T[end] == 'B') {
				make(start, end - 1, !flag);
			}
			if(T[start] == 'A') {
				make(start + 1, end, flag);
			}
		}
	}
}