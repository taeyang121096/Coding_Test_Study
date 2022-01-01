import java.io.*;
import java.util.*;

public class Josephus_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		// 처음 출력 형식 '<'
		sb.append("<");
		
		// 0보다 크게 된다면 poll이 마지막에 null을 반환
		while(!queue.isEmpty()) {
			for(int i = 0; i < k-1; i++) {
				int index = queue.poll(); // queue에 첫번째 값을 반환하고 제거, 비어있다면 null
				queue.add(index); // 제거한 index를 queue에 추가 // ex) k = 2 : 123456 -> 23456 -> 234561 -> 34561 -> 345612
			}
			sb.append(queue.poll() + ", "); // 가장 내부에 있는 값을 반환하고 쉼표도 추가 -> 3
		}
		sb.setLength(sb.length() - 2); // 마지막 ", " 지우기
		sb.append(">"); // while문을 통과 후 마지막에 남아있는 값을 반환하고 '>' 추가
		System.out.print(sb);
		
	}
}
