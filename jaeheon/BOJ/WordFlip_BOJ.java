import java.util.*;

public class WordFlip_BOJ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 예제 개수
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			// I am happy today
			String sentence = sc.nextLine();
			
			// ["I", "am", "happy", "today"]
			String[] temp = sentence.split(" ");
			
			for (int j = 0; j < temp.length; j++) {
				String result = "";
				//for(int k = 0; k < temp[j].length(); k++) // -> 이렇게 했더니 뒤집기 안됨 -> 역으로
				
				for (int k = temp[j].length() - 1; k >= 0; k--) {
					result += temp[j].charAt(k);
				}
				System.out.print(" " + result);
			}
		}
	}
}