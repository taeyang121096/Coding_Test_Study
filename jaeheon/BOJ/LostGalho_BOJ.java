package BOJ;

// 백준 1541 잃어버린 괄호
// 최소를 리턴 -> - 를 기준으로 쪼갬
// 식의 길이 50언더
// 5자리 이상으로 연속될 수 없음

import java.io.*;

public class LostGalho_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("-");
		
		for(int i = 0; i < str.length; i++) {
			if(str[i].contains("+")) {
				String[] tmp = str[i].split("\\+");
				int sum = 0;
				for(int j = 0; j < tmp.length; j++) {
//					System.out.println(tmp[j]);
					sum += Integer.parseInt(tmp[j]);
				}
				
				str[i] = Integer.toString(sum);
//				str[i] = String.valueOf(sum);
			}
		}
		// 10 - 50 - 20 + 30 - 40
		// 10   50      50     40
		int answer = Integer.parseInt(str[0]);
		for(int i = 1; i < str.length; i++) {
			answer -= Integer.parseInt(str[i]);
		}
		System.out.println(answer);
	}
}
