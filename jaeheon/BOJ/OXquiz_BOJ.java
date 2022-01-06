import java.io.*;

// 백준 OX퀴즈 8958번

// string 배열로 OX 입력받음
// count와 answer 변수 선언
// O를 만날때마다 count++ 하고 누적으로 answer에 더해줌
// X만나면 count = 0
public class OXquiz_BOJ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String arr[] = new String[n];

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		for (int i = 0; i < n; i++) {
			
			int cnt = 0;
			int ans = 0;
			
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == 'O') {
					cnt++;
				} else {
					cnt = 0;
				}
				ans+=cnt;
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb);
	}
}
