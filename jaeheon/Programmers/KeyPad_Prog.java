package Programmers;

//엄지손가락은 상하좌우로만, 이동거리는 한칸
//1 4 7 * 왼손
//3 6 9 # 오른손
//2 5 6 0 가까운손
//거리가 같다면 " "손 잡이에 따라 결정
//numbers 1 ~ 1000

public class KeyPad_Prog {
	static int find(int position, int num) {
		if (position == 0) {
			position = 11;
		}
		if (num == 0) {
			num = 11;
		}

		int positionX = (position - 1) / 3;
		int positionY = (position - 1) % 3;

		int numX = (num - 1) / 3;
		int numY = (num - 1) % 3;

		return Math.abs(positionX - numX) + Math.abs(positionY - numY);
	}

	public String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();

		int leftPosition = 10;
		int zero = 11;
		int rightPosition = 12;

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				sb.append("L");
				leftPosition = numbers[i];
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				sb.append("R");
				rightPosition = numbers[i];
			} else {
				int left = find(leftPosition, numbers[i]);
				int right = find(rightPosition, numbers[i]);
				if (left > right) {
					sb.append("R");
					rightPosition = numbers[i];
				} else if (left < right) {
					sb.append("L");
					leftPosition = numbers[i];
				} else {
					if (hand.equals("left")) {
						sb.append("L");
						leftPosition = numbers[i];
					} else if (hand.equals("right")) {
						sb.append("R");
						rightPosition = numbers[i];
					}
				}
			}
		}

		return sb.toString();
	}
}
