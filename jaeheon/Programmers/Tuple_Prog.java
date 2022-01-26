package Programmers;

//양쪽 중괄호 제거(두개씩)
//가운데 중괄호 제거
//정렬
//, 기준으로 나누고 하나씩 add
// 넣어주려는 값이 이미 포함되어 있으면 pass
import java.util.*;

class Tuple_Prog {

	public int[] solution(String s) {

		// 중괄호 제거 -> input
		s = s.substring(2, s.length() - 2).replace("},{", " ");
		String[] input = s.split(" ");

		// 길이 순으로 오름차순 정렬
		Arrays.sort(input, (o1, o2) -> o1.length() > o2.length() ? 1 : -1);

		ArrayList<Integer> al = new ArrayList<>();

		for (String tmp : input) {
			String[] str = tmp.split(",");

			for (int i = 0; i < str.length; i++) {
				int num = Integer.valueOf(str[i]);

				// 넣어주려는 값이 포함되어 있지 않으면 add
				// 포함되어 있으면 continue
				if (!al.contains(num)) {
					al.add(num);
				} else {
					continue;
				}
			}
		}

		int[] answer = new int[al.size()];
		
		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}

		return answer;
	}
}