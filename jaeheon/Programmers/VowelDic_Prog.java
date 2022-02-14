package Programmers;

//i 가 1563번임 -> e는 1562까지
//a는 1번부터 시작 -> 중간 값은 782 -> a, e, i의 간격이 781

class VowelDic_Prog {
	public int solution(String word) {
		int answer = 0;

		int gap = 781;

		String[] vowels = { "A", "E", "I", "O", "U" };

		for (int i = 0; i < word.length(); i++) {
			for (int index = 0; index < 5; index++) {
				if (vowels[index].equals(word.substring(i, i + 1))) {
					answer += 1 + (index * gap);
				}
			}
			gap = (gap - 1) / 5;
		}

		return answer;
	}
}