package Programmers;

//모든 입력은 알파벳 대문자
//공항 수 3 ~ 10000
//[a, b] : a -> b
//항상 ICN에서 출발
//항공권 모두 사용해야함, 예외는 없음
//경로가 2개 이상이면 알파벳 오름차순
import java.util.*;

public class TripRoute_Prog {
	static List<String> answer;
	static boolean[] visit;
	static StringBuilder sb;

	static void dfs(int depth, String now, String path, String[][] tickets) {
		sb = new StringBuilder();
		if (depth == tickets.length) {
			answer.add(path);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (!visit[i] && tickets[i][0].equals(now)) {
				visit[i] = true;
				sb.append(path).append(" ").append(tickets[i][1]);
				dfs(depth + 1, tickets[i][1], sb.toString(), tickets);
				visit[i] = false;
			}
		}
	}

	public String[] solution(String[][] tickets) {
		answer = new ArrayList<>();
		visit = new boolean[tickets.length];
		dfs(0, "ICN", "ICN", tickets);
		Collections.sort(answer);
		// System.out.println(answer);
		return answer.get(0).split(" ");
	}
}
