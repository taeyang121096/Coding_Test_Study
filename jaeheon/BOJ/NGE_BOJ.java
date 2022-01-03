import java.util.*;
import java.io.*;
// 백준 17298번 오큰수

// 오른쪽에 있으면서 가장 큰 수 중 가장 왼쪽에 있는 수
// 스택 사용

public class NGE_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			// 스택이 비어있지 않으면서 
			// 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
			// 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
			// 해당 인덱스의 값을 현재 원소로 바꿔준다.
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		
		// 스택의 모든 원소를 pop하면서 해당 인덱스의 value를 -1로 초기화한다.
		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}

		sb.setLength(0);
		
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(' ');
		}

		System.out.println(sb);
	}
}
