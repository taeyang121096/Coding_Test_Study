package Programmers;

class TraingleSnail_Prog {
	public int[] solution(int n) {

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}

		int[] answer = new int[sum];

		int[][] mat = new int[n][n];

		int row = 0;
		int col = 0;
		int value = 1;

		mat[0][0] = 1;

		for (int i = 0; i < sum; i++) {
			// 위 -> 아래
			while (row + 1 < n && mat[row + 1][col] == 0) {
				mat[++row][col] = ++value;
			}
			// 왼 -> 오
			while (col + 1 < n && mat[row][col + 1] == 0) {
				mat[row][++col] = ++value;
			}
			// 대각
			while (row - 1 > 0 && col - 1 > 0 && mat[row - 1][col - 1] == 0) {
				mat[--row][--col] = ++value;
			}
		}

		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[k++] = mat[i][j];
			}
		}

		return answer;
	}
}