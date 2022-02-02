package Programmers;

//작업진도, 작업속도 1 ~ 99
//배포는 하루에 한 번, 하루에 끝에 이루어짐

import java.util.*;

class Development_Prog {
	public int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> q = new ArrayDeque<>();
		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			q.offer((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
		}

		int cnt = 1;
		int pre = q.poll();
		int next = 0;

		while (!q.isEmpty()) {
			next = q.poll();
			if (pre >= next) {
				cnt++;
			} else {
				pre = next;
				al.add(cnt);
				cnt = 1;
			}
		}

		al.add(cnt);

		int[] answer = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}

		return answer;
	}
}