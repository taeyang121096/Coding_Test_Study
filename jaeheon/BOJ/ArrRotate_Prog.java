package Programmers;

//queries 로 구역 선택
//각 구역별로 가장 작은 수
//가로세로 길이 2 ~ 100
//queries 개수 1이상 10000이하
//모든 회전은 순서대로

//row : 세로 길이(행 개수)
//col : 가로 길이(열 개수)

class ArrRotate_Prog {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];

		int[][] mat = new int[rows][columns];

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				mat[i - 1][j - 1] = (i - 1) * columns + j;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int x1 = queries[i][0] - 1;
			int y1 = queries[i][1] - 1;
			int x2 = queries[i][2] - 1;
			int y2 = queries[i][3] - 1;

			int firstIndex = mat[x1][y1];
			int min = mat[x1][y1];

			// 왼 세로
			for (int j = x1; j < x2; j++) {
				mat[j][y1] = mat[j + 1][y1];
				min = Math.min(mat[j][y1], min);
			}
			// 아래 가로
			for (int j = y1; j < y2; j++) {
				mat[x2][j] = mat[x2][j + 1];
				min = Math.min(mat[x2][j], min);
			}
			// 우 세로
			for (int j = x2; j > x1; j--) {
				mat[j][y2] = mat[j - 1][y2];
				min = Math.min(mat[j][y2], min);
			}
			// 위 가로
			for (int j = y2; j > y1; j--) {
				mat[x1][j] = mat[x1][j - 1];
				min = Math.min(mat[x1][j], min);
			}

			mat[x1][y1 + 1] = firstIndex;
			answer[i] = min;
		}

		return answer;
	}
}
