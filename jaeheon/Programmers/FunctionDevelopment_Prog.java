package Programmers;

//작업의 개수 -> 100개 이하
//작업 진도 100미만 자연수
//작업 속도 100이하 자연수
//배포는 하루에 한번, 하루에 끝에 이루어짐

import java.util.*;

public class FunctionDevelopment_Prog {
	public int[] solution(int[] progresses, int[] speeds) {

		ArrayList<Integer> al = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < progresses.length; i++) {
			queue.offer((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
		}
//         System.out.println(queue.size());
//         System.out.println();

//         for(int i = 0; i < progresses.length; i++){
//             System.out.println(queue.poll());
//         }
		// 5 10 1 1 20 1
		int cnt = 1;
		int now = queue.poll();
		while (!queue.isEmpty()) {
			int next = queue.poll();
			if (now >= next) {
				cnt++;
			} else {
				now = next;
				al.add(cnt);
				cnt = 1;
			}
		}
		al.add(cnt);

		int[] answer = new int[al.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = al.get(i);
		}

		return answer;
	}
}
