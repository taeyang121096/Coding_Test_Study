import java.util.*;
import java.io.*;

public class GBC_SOF {

	static int n, m, index;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][2];
		int[][] testArr = new int[n][2];
		int result = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 구간 길이
			arr[i][1] = Integer.parseInt(st.nextToken()); // 제한 속도
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			testArr[i][0] = Integer.parseInt(st.nextToken()); // 운행 길이
			testArr[i][1] = Integer.parseInt(st.nextToken()); // 운행 속도
		}

		index = 0;

		for (int i = 0; i < n; i++) {
			for (int j = index; j < m; j++) {
				if (arr[i][0] < testArr[j][0]) { // 구간 길이가 운행 길이보다 짧을 때
					testArr[j][0] -= arr[i][0];
					if (testArr[j][1] - arr[i][1] > 0) { // 운행 속도가 제한 속도보다 빠를 때
						result = Math.max(result, testArr[j][1] - arr[i][1]);
						break;
					}
				} else if (arr[i][0] > testArr[j][0]) { // 구간 길이가 운행 길이보다 길 때
					arr[i][0] -= testArr[j][0];
					if (testArr[j][1] - arr[i][1] > 0) { // 운행 속도가 제한 속도보다 빠를 때
						result = Math.max(result, testArr[j][1] - arr[i][1]);
						index++;
					}
				} else if (arr[i][0] == testArr[j][0]) { // 구간 길이와 운행 길이가 동일할 때
					if (testArr[j][1] - arr[i][1] > 0) { // 운행 속도가 제한 속도보다 빠를 때
						result = Math.max(result, testArr[j][1] - arr[i][1]);
						index++;
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}