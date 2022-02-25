package Programmers;

import java.util.*;

class Traffic_prog {
	public int solution(String[] lines) {
		int answer = 0;

		int[] cnt = new int[lines.length];

		for (int i = 0; i < lines.length; i++) {

			lines[i] = lines[i].substring(11).replace(":", "").replace("s", "");

			int timeToSec = Integer.parseInt(lines[i].substring(0, 2)) * 3600
					+ Integer.parseInt(lines[i].substring(2, 4)) * 60 + Integer.parseInt(lines[i].substring(4, 6));

			lines[i] = timeToSec + lines[i].substring(6);

			System.out.println(lines[i]);
		}

		for (int i = 0; i < lines.length; i++) {

			String[] split = lines[i].split(" ");
			// 완료시간
			double end = Double.parseDouble(split[0]);

			double interval = end + 1;

			for (int j = i; j < lines.length; j++) {
				split = lines[j].split(" ");

				// 시작시간
				double start = Double.parseDouble(split[0]) - Double.parseDouble(split[1]) + 0.001;
				if (start < interval) {
					cnt[i]++;
				}
			}
		}

		for (int i = 0; i < cnt.length; i++) {
			Arrays.sort(cnt);
			answer = cnt[cnt.length - 1];
		}
		return answer;
	}
}