package Programmers;

//코스요리 메뉴 : 최소 2가지 이상의 단품메뉴
//각 손님은 단품메뉴 2개 이상 주문해야함
//orders 배열 2이상 20이하
//orders 각 원소 2이상 10이하
//오름차순 정렬

import java.util.*;

public class MenuRenewal_Prog {
	static Map<String, Integer> hm = new HashMap<>();

	static void dfs(String menu, String order, int course) {
		if (menu.length() == course) {
			hm.put(menu, hm.getOrDefault(menu, 0) + 1);
			return;
		}

		for (int i = 0; i < order.length(); i++) {
			dfs(menu + order.charAt(i), order.substring(i + 1), course);
		}
	}

	public String[] solution(String[] orders, int[] course) {
		List<String> al = new ArrayList<>();

		for (int i = 0; i < orders.length; i++) {
			char[] ch = orders[i].toCharArray();
			Arrays.sort(ch);
			orders[i] = String.valueOf(ch);
		}
		// for(int i = 0; i < orders.length; i++){
		// System.out.println(orders[i]);
		// }

		for (int i : course) {
			for (int k = 0; k < orders.length; k++) {
				dfs("", orders[k], i);
			}
			if (!hm.isEmpty()) {
				Collection<Integer> values = hm.values();
				List<Integer> list = new ArrayList<>(values);
				// List<Integer> list = new ArrayList<>(hm.values());
				int max = Collections.max(list);
				if (max > 1) {
					for (String str : hm.keySet()) {
						if (hm.get(str) == max) {
							al.add(str);
						}
					}
				}
			}
			hm.clear();
		}
		String[] answer = new String[al.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = al.get(i);
		}
		Arrays.sort(answer);

		return answer;
	}
}
