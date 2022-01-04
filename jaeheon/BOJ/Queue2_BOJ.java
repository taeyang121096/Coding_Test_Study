import java.io.*;
import java.util.*;

//백준 18258번 큐2

public class Queue2_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

//	    push X: 정수 X를 큐에 넣는 연산이다.
//		pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		size: 큐에 들어있는 정수의 개수를 출력한다.
//		empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//		front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		
		StringTokenizer st;

		Deque<Integer> queue = new LinkedList<>();

		while(n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");	// 문자열 분리 
			
			switch(st.nextToken()) {	
			
			case "push":
				queue.offer(Integer.parseInt(st.nextToken()));	
				break;
			
			case "pop" :
				if(queue.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(queue.poll()).append('\n');
				}
				break;
				
			case "size":	
				sb.append(queue.size()).append('\n');
				break;
				
			case "empty":
				if(queue.isEmpty()) {
					sb.append(1).append('\n');
				}
				else {
					sb.append(0).append('\n');
				}
				break;
				
			case "front":
				if(queue.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(queue.peekFirst()).append('\n');
				}
				break;
				
			case "back":
				if(queue.isEmpty()) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(queue.peekLast()).append('\n');
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
