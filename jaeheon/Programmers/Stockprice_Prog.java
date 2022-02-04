package Programmers;

//prices : 초 단위로 주식 가격 기록
//1 2 3 2 3
//1번탐색 -> 2번탐색 -> j = i+1부터

class StockProce_Prog {
	public int[] solution(int[] prices) {

		int len = prices.length;

		int[] answer = new int[len];

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				answer[i]++;
				if (prices[j] < prices[i]) {
					break;
				}
			}
		}

		return answer;
	}
}
