package BOJ;

// 백준 15903 카드합체놀이
//  x번 카트와 y번 카드를 골라 그 두장에 쓰여진 수를 더한 값을 계산
// 계산한 값을 x번 카드와 y번 카드 두장 모두에 덮어씀
// m번 진행
// 최소로 만들기

import java.util.*;
import java.io.*;

public class CardUnionPlay_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 1 2 3 4
		// 3 3 3 4
		// 3 6 6 4 -> 19
		for (int i = 0; i < m; i++) {
			Arrays.sort(arr);
			arr[0] = arr[0] + arr[1];
			arr[1] = arr[0];
		}

		long answer = 0;
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		System.out.println(answer);
	}
}
