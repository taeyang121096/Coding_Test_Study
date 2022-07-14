package Programmers;

//야근 피로도 : 야근을 시작한 시점에서 남은 일의 작업량을 제곱해서 더한 값
//demi는 1시간동안 1만큼 처리 가능
//n시간동안 야근피로도 최소화
//값을 일정한 수준으로 만들어야 최소

import java.util.*;

public class NightPay_Prog {
	public long solution(int n, int[] works) {
		long answer = 0;

		// Integer[] aa = new Integer[works.length];
		// for(int i = 0; i < works.length; i++){
		// aa[i] = works[i];
		// }
		// Arrays.sort(aa, Collections.reverseOrder());

		Arrays.sort(works); // 3 3 4 n-4

		int idx = works.length - 1;
		while (n != 0) {
			if (works[idx] > works[idx - 1]) { // 뒤가 앞보다 클때 // 3 3 3 n - 3
				works[idx]--;
				idx = works.length - 1;
			} else if (works[idx] == works[idx - 1]) { // 뒤랑 앞이랑 같을때
				if (idx - 1 == 0) { // 제일 바로 전까지 봤을 때
					works[idx - 1]--;
					idx = works.length - 1;
				} else { // 3 3 2 n - 2
					works[idx]--;
					idx--;
				}
			} else { // 3 2 2 n - 1
				works[idx - 1]--;
			}
			n--;
		}

		int tmp = 0;
		for (int i = 0; i < works.length; i++) {
			tmp += works[i];
		}
		if (tmp < n) {
			return 0;
		}

		for (int i = 0; i < works.length; i++) {
			answer += Math.pow(works[i], 2);
		}

		return answer;
	}
}
