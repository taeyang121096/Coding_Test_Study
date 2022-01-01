import java.io.*;
import java.util.*;

public class Queue_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int last = 0;
		int x;

//	    push X: 정수 X를 큐에 넣는 연산이다.
//		pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		size: 큐에 들어있는 정수의 개수를 출력한다.
//		empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//		front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

		Queue<Integer> queue = new LinkedList<>();
		String command;

		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			command = tmp[0];

			// push
			if (command.equals("push")) {
				x = Integer.parseInt(tmp[1]);
				queue.add(x);
				last = x;
			}
			
			// pop
			else if(command.equals("pop")) {
				if (queue.size() > 0) {
                    System.out.println(queue.remove());
                } else if (queue.size() == 0) {
                    System.out.println(-1);
                }
			}
			
			// size
			else if(command.equals("size")) {
				 System.out.println(queue.size());
			}
			
			// empty
			else if(command.equals("empty")) {
				if (queue.size() == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
			}
			
			// front
			else if(command.equals("front")) {
				if (queue.size() > 0) {
                    System.out.println(queue.peek());
                } else if (queue.size() == 0) {
                    System.out.println(-1);
                }
			}
			
			// back
			else if(command.equals("back")) {
				if (queue.size() > 0) {
                    System.out.println(last);
                } else if (queue.size() == 0) {
                    System.out.println(-1);
                }
			}
		}
	}
}
