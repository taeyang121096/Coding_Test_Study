package algorithmTest;
/* AC*/

import java.util.*;

public class Ac {

	public String solution(String p, Deque<String> q) {

		int flag = 0;
		String ans = "";
		for (char c : p.toCharArray()) {
			if (c == 'R')
				flag += 1;
			else if (c == 'D') {
				if (q.isEmpty())
					return "error";

				if (flag % 2 == 0)
					q.pollFirst();
				else
					q.pollLast();
			} else
				return "error";
		}

		if (flag % 2 == 0) {
			ans += "[";
			ans += String.join(",", q);
			ans += "]";
		} else {
			ans += "[";
			if (q.size() > 0) {
				for (int i = 0; i < q.size() - 1; i++)
					ans = ans + q.pollLast() + ",";
				ans += q.pollLast();
			}
			ans += "]";

		}
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ac a = new Ac();
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		String[] ans = new String[t];
		for (int i = 0; i < t; i++) {
			Deque<String> q = new ArrayDeque<>();
			String p = sc.next();
			int n = sc.nextInt();
			String[] x = sc.next().replace("[", "").replace("]", "").replace(",", " ").split(" ");
			for (int j = 0; j < n; j++) {
				q.offer(x[j]);
			}
			ans[i] = a.solution(p, q);

		}
		for(String s : ans) System.out.println(s);
	}

}
