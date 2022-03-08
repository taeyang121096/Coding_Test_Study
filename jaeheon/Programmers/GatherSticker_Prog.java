package Programmers;

class GatherSticker_Prog {
	public int solution(int sticker[]) {
		int answer = 0;

		if (sticker.length <= 3) {
			if (sticker.length == 1) {
				return sticker[0];
			} else if (sticker.length == 2) {
				return Math.max(sticker[0], sticker[1]);
			} else {
				return Math.max(sticker[0], Math.max(sticker[1], sticker[2]));
			}
		}

		int[] dp1 = new int[sticker.length];
		int[] dp2 = new int[sticker.length];

		dp1[0] = sticker[0];
		dp1[1] = sticker[0];

		for (int i = 2; i < sticker.length; i++) {
			dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
		}

		dp2[0] = 0;
		dp2[1] = sticker[1];

		for (int i = 2; i < sticker.length; i++) {
			dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
		}

		answer = Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);

		return answer;
	}
}