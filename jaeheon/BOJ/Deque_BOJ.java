import java.io.*;
import java.util.*;

// 백준 10866
public class Deque_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();

//		push_front X: 정수 X를 덱의 앞에 넣는다.
//		push_back X: 정수 X를 덱의 뒤에 넣는다.
//		pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		size: 덱에 들어있는 정수의 개수를 출력한다.
//		empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
//		front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

		String command;

		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			command = tmp[0];

			// push_front
			if (command.equals("push_front")) {
				deque.offerFirst(Integer.parseInt(tmp[1]));
			}

			// push_back
			else if (command.equals("push_back")) {
				deque.offerLast(Integer.parseInt(tmp[1]));
			}

			// pop_front
			else if (command.equals("pop_front")) {
				if (deque.size() > 0) {
					System.out.println(deque.pollFirst());
				} else {
					System.out.println(-1);
				}
			}

			// pop_back
			else if (command.equals("pop_back")) {
				if (deque.size() > 0) {
					System.out.println(deque.pollLast());
				} else {
					System.out.println(-1);
				}
			}

			// size
			else if (command.equals("size")) {
				System.out.println(deque.size());
			}

			// empty
			else if (command.equals("empty")) {
				if (deque.size() > 0) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
			}

			// front
			else if (command.equals("front")) {
				if (deque.size() > 0) {
					System.out.println(deque.peekFirst());
				} else {
					System.out.println(-1);
				}
			}

			// back
			else if (command.equals("back")) {
				if (deque.size() > 0) {
					System.out.println(deque.peekLast());
				} else {
					System.out.println(-1);
				}
			}
		}

	}
}
