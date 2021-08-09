import java.io.*;
import java.util.*;

public class baek_17298 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			// 스택이 비어있으면 배열의 인덱스 값을 push
			if (stack.empty()) {
				stack.push(i);
			}
			// top과 새로운 배열을 비교하여 top이 작아질때 까지 pop을 하면서 인덱스의 값에 배열의 값을 대입
			else {
				while(!stack.empty()&&A[i] > A[stack.peek()]){
					A[stack.pop()] = A[i];
				}
				stack.push(i);
			}
		}
		// 마지막까지 스택에 남아있는 수는 -1로 초기화
		while(!stack.empty()) {
			A[stack.pop()] = -1;
		}
		
		for(int i = 0; i<N; i++) {
			sb.append(A[i]).append(" ");
		}
		System.out.println(sb);
	}
}
