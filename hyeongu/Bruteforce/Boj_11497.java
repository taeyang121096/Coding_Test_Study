import java.io.*;
import java.util.*;

public class Boj_11497 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> al = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			for (int j = 0; j < n; j++) {
				al.add(Integer.parseInt(st.nextToken()));
			}

			Collections.sort(al);

			if (n % 2 == 0) {
				for (int j = n - 1; j > 0; j -= 2) {
					al.add(al.get(j));
				}
				for (int k = n - 1; k >= 0; k -= 2) {
					al.remove(k);
				}
			} else {
				for (int j = n - 2; j > 0; j -= 2) {
					al.add(al.get(j));
				}
				for (int k = n - 2; k >= 0; k -= 2) {
					al.remove(k);
				}
			}

			int tmp = Math.abs(al.get(0) - al.get(n - 1));
			for (int l = 1; l < al.size(); l++) {
				tmp = Math.max(tmp, Math.abs(al.get(l) - al.get(l - 1)));
			}
			sb.append(tmp + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}