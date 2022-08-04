package Programmers;

//[a, b, c]
//a, b -> 도로로 연결되어 있는 마을의 번호
//c -> 도로의 cost
//k 시간 안에 배달 가능한 마을 수
//1번 마을에서 출발
//양방향으로 이동
//마을 개수 1 ~ 50
//도로 개수 1 ~ 2000
//시간 1 ~ 10000
//두 마을을 연결하는 도로가 여러개 일수도 있음 -> cost 높은거 버리면 됨

public class Delivery_Prog {
	public int solution(int N, int[][] road, int K) {
		int answer = 0;
		int[][] cost = new int[N][N];

		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost[0].length; j++) {
				if (i == j) {
					continue;
				} else {
					cost[i][j] = 500001;
				}
			}
		}

		for (int i = 0; i < road.length; i++) {
			int a = road[i][0] - 1;
			int b = road[i][1] - 1;

			// if(cost[a][b] >= road[i][2]){
			// cost[a][b] = road[i][2];
			// cost[b][a] = road[i][2];
			// }

			// if(cost[a][b] < road[i][2]){
			// continue;
			// }
			// cost[a][b] = road[i][2];
			// cost[b][a] = road[i][2];

			if (cost[a][b] != 0) {
				if (road[i][2] < cost[a][b]) {
					cost[a][b] = road[i][2];
				} else {
					continue;
				}

				if (road[i][2] < cost[b][a]) {
					cost[b][a] = road[i][2];
				} else {
					continue;
				}
			} else {
				cost[a][b] = road[i][2];
				cost[b][a] = road[i][2];
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cost[i][k] + cost[k][j] < cost[i][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}

		// for(int i = 0; i < cost.length; i++){
		// for(int j = 0; j < cost.length; j++){
		// System.out.println( i + " " + j + " " + cost[i][j]);
		// }
		// }

		for (int i = 0; i < cost[0].length; i++) {
			if (cost[0][i] <= K) {
				answer++;
			}
		}

		return answer;
	}
}
