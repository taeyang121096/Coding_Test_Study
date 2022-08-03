package BOJ;

import java.util.*;
import java.io.*;

// 백준 1764 듣보잡
// 각각의 명단에는 중복되는 이름이 없다
// 두개의 명단에서 겹치는 사람의 수와 그 명단을 사전순으로 출력

public class DeutBoJap_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				list.add(str);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
