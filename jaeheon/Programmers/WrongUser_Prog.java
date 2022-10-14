package Programmers;

import java.util.*;

public class WrongUser_Prog {
	static Set<Set<String>> answer;

	static boolean check(String[] ban_id, Set<String> hs) {
		int idx = 0;
		for (String user : hs) {
			String banID = ban_id[idx++];
			if (user.length() != banID.length()) {
				return false;
			}
			for (int j = 0; j < banID.length(); j++) {
				if (banID.charAt(j) == '*') {
					continue;
				}
				if (user.charAt(j) != banID.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	static void dfs(String[] user_id, String[] ban_id, Set<String> set) {
		if (set.size() == ban_id.length) {
			// System.out.println(check(ban_id, set));
			if (check(ban_id, set)) {

				answer.add(new HashSet<>(set));
			}
			return;
		}

		for (String user : user_id) {
			if (!set.contains(user)) {
				set.add(user);
				dfs(user_id, ban_id, set);
				set.remove(user);
			}
		}
	}

	public int solution(String[] user_id, String[] banned_id) {
		answer = new HashSet<>();

		dfs(user_id, banned_id, new LinkedHashSet<>());

		return answer.size();
	}
}
