package BOJ;

import java.io.*;

public class SplitSum_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
//		int a = '1';
//		int z = '0';
//		System.out.println(a + " " + z);
		
		for(int i = 1; i <= n; i++) {
			String num = String.valueOf(i); // int -> string
			int sum = 0;
			
			// 각 자리를 합에 더해줌
			for(int j = 0; j < num.length(); j++) {
				// 캐릭터형 -> int로 변환
//				sum += Character.getNumericValue(num.charAt(j));
				sum += num.charAt(j) - '0';
				// 2 1 6
				// 2 3 9
			}
			// 그 합에 원래 숫자를 더해줌
			sum += Integer.parseInt(num);
			
			if(sum == n) {
				System.out.println(num);
				break;
			} else if(n == i) {
				System.out.println(0);
			}
		}
	}
}
