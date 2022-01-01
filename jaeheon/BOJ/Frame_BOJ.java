import java.util.*;
import java.io.*;

public class Frame_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 첫번째 n : 몸무게, 두번째 n : 키
		int[][] frame = new int[n][n]; 
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= 1; j++) {
				frame[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			int rank = 1;
			for (int j = 0; j < n; j++) {
				// i번째 사람과 j번째 사람을 비교해서 i가 j보다 덩치가 작을 경우 등수를 올림
				if (frame[0][i] < frame[0][j] && (frame[1][i] < frame[1][j])) {
					rank++;
				}
			}
			System.out.print(rank + " ");
		}
	}

}
