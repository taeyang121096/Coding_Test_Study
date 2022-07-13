package Programmers;

//최대한 많은 종류의 폰켓몬을 가져야 함
//2/n마리의 폰켓몬을 선택
//가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아 그때의 폰켓몬 종류 번호의 개수
//nums 1 ~ 200000
//폰켓몬 종류 번호 1 ~ 200000

import java.util.*;

public class PhoneKetMon_Prog {
	public int solution(int[] nums) {
		int answer = 0;

		HashSet<Integer> hs = new HashSet<>();

		// 1 2 3, nums : 4개
		// 3 2 4, nums : 6개
		// 3 2, nums 6개
		for (int i = 0; i < nums.length; i++) {
			hs.add(nums[i]);
		}
		if (hs.size() < nums.length / 2) {
			answer = hs.size();
		} else {
			answer = nums.length / 2;
		}

		return answer;
	}
}
