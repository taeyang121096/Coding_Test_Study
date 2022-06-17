import java.util.*;
 
public class baek_2164 {
 
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		int N = scanner.nextInt();
		int temp;
		
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		while(queue.size() > 1) {
			queue.poll();
			temp = queue.poll();
			queue.offer(temp);
		}
		
		System.out.println(queue.poll());
	}
}