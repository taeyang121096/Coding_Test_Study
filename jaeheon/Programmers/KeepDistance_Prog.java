
// P - 응시자가 앉아있는 자리
// O - 빈 테이블
// X - 파티션
// 대기실의 모든 자리 탐색 -> p를 찾아야함
// 탐색하면서 2 내에 p가 있는지 확인(맨해튼 거리 -> Math.abs(a1 - b1) + Math.abs(a2- b2))
// p를 만난 후 탐색
// 파티션을 만나면 상하좌우 상관 없음
// 빈 테이블을 만나면 p는 등장할 수 없음 -> x, o는 가능
// 큐에 넣고 다시 탐색
import java.util.*;

class KeepDistance_Prog {

	static boolean isChecked = true;

	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];

		for (int i = 0; i < places.length; i++) {
			String[] p = places[i];

			boolean isChecked = true;
			for (int r = 0; r < 5 && isChecked; r++) { // row
				for (int c = 0; c < 5 && isChecked; c++) { // col
					if (p[r].charAt(c) == 'P') {
						if (!bfs(r, c, p))
							isChecked = false;
					}
				}
			}
			if (isChecked) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}

		}

		return answer;
	}

	private static boolean bfs(int r, int c, String[] p) {
		int dr[] = { -1, 1, 0, 0 };
		int dc[] = { 0, 0, -1, 1 };


		return true;
	}
}