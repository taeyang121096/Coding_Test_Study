package Programmers;

//현재 온 거리 x 2 순간이동 -> 건전지 줄지 않음
//그냥 앞으로 k 칸 점프하면 줄어듦
//-> 순간이동이 더 효율적
//건전지 사용량을 최소화하기 위해 그냥 점프 최소화
//return 건전지 사용량
//n : 1 ~ 10억 k : 1이상의 자연수

public class JumpTeleport_Prog {
	public int solution(int n) {
		int ans = 0;

		while (n > 0) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n -= 1;
				ans++;
			}
		}

		return ans;
	}
}