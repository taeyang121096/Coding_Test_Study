package Programmers;

import java.util.*;

public class ShuttleBus_Prog {
	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < timetable.length; i++) {
			int time = hourToMin(timetable[i]);
			pq.offer(time);
		}

		int start = 540;
		int cnt = 0;
		int last = 0;
		for (int i = 0; i < n; i++) {
			cnt = 0;
			while (!pq.isEmpty() && pq.peek() <= start) {
				last = pq.poll();
				cnt++;
				if (cnt == m) {
					break;
				}
			}
			start += t;
		}

		if (cnt == m) {
			answer = minToString(last - 1);
		} else {
			answer = minToString(start - t);
		}

		return answer;
	}

	static int hourToMin(String time) {
		String[] str = time.split(":");
		int hour = Integer.parseInt(str[0]);
		int min = Integer.parseInt(str[1]);

		return hour * 60 + min;
	}

	static String minToString(int time) {
		StringBuilder sb = new StringBuilder();
		int hour = time / 60;
		int min = time - hour * 60;

		String newHour = String.valueOf(hour);
		String newMin = String.valueOf(min);

		if (newHour.length() == 1) {
			sb.append(newHour).append("0");
			newHour = sb.reverse().toString();
		}
		sb.setLength(0);

		if (newMin.length() == 1) {
			sb.append(newMin).append("0");
			newMin = sb.reverse().toString();
		}

		return newHour + ":" + newMin;
	}
}
