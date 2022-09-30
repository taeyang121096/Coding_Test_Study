package BOJ;

import java.util.*;
import java.io.*;

public class Game_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int res = (int)((long)y*100/x);
		
		int left = 0;
		int right = 1000000000;
		int mid;
		int tmp;
		
		if(res >= 99) {
			System.out.println(-1);
		} else {
			while(left <= right) {
				mid = (left + right) / 2;
				tmp = (int)(((long)y + mid) * 100 / (x + mid));
				if(tmp > res) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			System.out.println(left);
		}
	}
}
