package Programmers;

//1 ~ 26번 : 알파벳
//추가되면 27부터
//출력은 인덱스의 번호

import java.util.*;

public class Compress_Prog {
	public int[] solution(String msg) {
		HashMap<String, Integer> hm = new HashMap<>(); // 사전
		ArrayList<Integer> al = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		int idx = 27;

		for (int i = 1; i < 27; i++) {
			char ch = (char) (64 + i);
			hm.put(String.valueOf(ch), i);
		}

		// for (String key : hm.keySet()) {
		// int value = hm.get(key);
		// System.out.println(key + " : " + value);
		// }

		for (int i = 0; i < msg.length(); i++) {
			sb.append(msg.charAt(i));
			// System.out.println(i); // 1 2 4
			if (!hm.containsKey(sb.toString())) {
				hm.put(sb.toString(), idx);
				idx++;
				al.add(hm.get(sb.toString().substring(0, sb.length() - 1)));
				sb.setLength(0);
				i--;
				// System.out.println(i); // 1 2 4
				// KAKAO
			}
		}

		// for(int i = 0; i < al.size(); i++){
		// System.out.println(al.get(i));
		// }

		al.add(hm.get(sb.toString()));

		// System.out.println(al.size());

		int[] answer = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}

		return answer;
	}
}
