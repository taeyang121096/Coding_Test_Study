package Programmers;

//참가자 명단 - 완주자명단
//완주자 명단은 참가자 명단보다 무조건 1만 작음

import java.util.*;

public class FailToGoal_Prog {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		Arrays.sort(participant); // eden leo kiki
		Arrays.sort(completion); // eden kiki

		// ana mislav mislav stanko
		// ana mislav stanko

		for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				answer = participant[i];
				break;
			}
			if (i == completion.length - 1) {
				answer = participant[i + 1];
			}
		}

		return answer;
	}
}
