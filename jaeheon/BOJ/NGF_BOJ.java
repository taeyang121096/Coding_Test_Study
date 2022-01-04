import java.util.*;
import java.io.*;

// 백준 오등큰수 17299

// 오른쪽에 있는 숫자 중 자신보다 등장 횟수가 많은 것중 왼쪽
// A = [1, 1, 2, 3, 4, 2, 1] -> count(1) = 3, count(2) = 2, count(3) = 1, count(4) = 1
// 스택에 있는 count가 현재보다 작으면 현재 값을 뽑아서 arr[] 을 넣어줌
// 없으면 -1

public class NGF_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> stack = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());

		int arr[] = new int[n]; // 입력 1 1 2 3 4 2 1
		int count[] = new int[n]; // 카운트 3 3 2 1 1 2 3
		int result[] = new int[n]; // 결과 -1 -1 1 2 2 1 -1

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 입력 1 1 2 3 4 2 1
			count[arr[i]]++; // count[1] -> 3 ,,, count[2] -> 2 ,,, count[3] -> 1 ,,, count[4] -> 1
//			System.out.print(count[arr[i]]);
		}
//		System.out.println(count[1] +" "+ count[2] +" "+ count[3] +" "+ count[4]); -> 3 2 1 1

		
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && count[arr[i]] > count[arr[stack.peekFirst()]]) {
				result[stack.removeFirst()] = arr[i];
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			result[stack.removeFirst()] = -1;
		}

		for (int i = 0; i < n; i++) {
			sb.append(result[i] + " ");
		}

		System.out.println(sb);
	}
}
