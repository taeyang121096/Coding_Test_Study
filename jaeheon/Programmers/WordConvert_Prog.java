package Programmers;

//무조건 한번에 한개 알파벳만

//words에 있는 단어로만 변환
//알파벳은 소문자
//단어의 길이는 3 ~ 10, 모든 단어 길이는 같음, 중복단어 없음
//변환할 수 없으면 return 0

public class WordConvert_Prog {
	static int answer = 51;
	static boolean[] visit;

	// 카운트를 선언해
	// 포문 돌려서 charAt로 한자리씩 비교함
	// 그 카운트가 next의 length-1이랑 같으면 true
	// 아니면 false
	static boolean check(String now, String next) {
		int cnt = 0;
		for (int i = 0; i < next.length(); i++) {
			if (now.charAt(i) == next.charAt(i)) {
				cnt++;
			}
		}
		if (cnt == next.length() - 1) {
			return true;
		} else {
			return false;
		}
	}

	static void dfs(int depth, String target, String[] words, String now) {
		if (now.equals(target)) {
			answer = Math.min(answer, depth);
			return;
		}

		for (int i = 0; i < words.length; i++) {
			String next = words[i];
			if (visit[i] == false && check(now, next)) {
				visit[i] = true;
				dfs(depth + 1, target, words, next);
				visit[i] = false;
			}
		}
	}

	public int solution(String begin, String target, String[] words) {
		visit = new boolean[words.length];
		for (int i = 0; i < words.length; i++) {
			String next = words[i];
			if (visit[i] == false && check(begin, words[i])) {
				visit[i] = true;
				dfs(1, target, words, next);
				visit[i] = false;
			}
		}
		if (answer == 51) {
			return 0;
		} else {
			return answer;
		}
	}
}
