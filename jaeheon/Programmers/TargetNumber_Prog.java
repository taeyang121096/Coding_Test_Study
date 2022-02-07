package Programmers;

//number 개수 2 ~ 20
//targer 1 ~ 50
//더하기랑 빼기만
//숫자를 만드는 방법의 개수 리턴

class TargetNumber_Prog {
	static int answer = 0;

	public void dfs(int[] numbers, int target, int idx, int sum) {
		if (numbers.length == idx) {
			if (sum == target) {
				answer++;
			}
			return;
		}
		dfs(numbers, target, idx + 1, sum + numbers[idx]);
		dfs(numbers, target, idx + 1, sum - numbers[idx]);
	}

	public int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);

		return answer;
	}
}