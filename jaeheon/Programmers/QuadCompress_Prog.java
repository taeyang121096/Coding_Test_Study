package Programmers;

public class QuadCompress_Prog {
	static int zeroCnt = 0;
	static int oneCnt = 0;
	static int[][] mat;

	static void compress(int length, int start, int end) {
		int num = mat[start][end];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (num != mat[start + i][end + j]) {
					compress(length / 2, start, end);
					compress(length / 2, start + length / 2, end);
					compress(length / 2, start, end + length / 2);
					compress(length / 2, start + length / 2, end + length / 2);
					return;
				}
			}
		}
		if (num == 0) {
			zeroCnt++;
		} else {
			oneCnt++;
		}
	}

	public int[] solution(int[][] arr) {
		int[] answer = new int[2];
		mat = arr;
		compress(arr.length, 0, 0);
		answer[0] = zeroCnt;
		answer[1] = oneCnt;

		return answer;
	}
}
