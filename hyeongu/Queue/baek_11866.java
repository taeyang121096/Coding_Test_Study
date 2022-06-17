import java.util.*;
 
public class baek_11866 {
 
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		StringBuilder print = new StringBuilder();
		print.append('<');

		while(queue.size() > 1) {
			
			for(int i = 0; i < K - 1; i++) {
				int val = queue.poll();
				queue.offer(val);
			}
			
			print.append(queue.poll()).append(", ");
		}
 
		print.append(queue.poll()).append('>');
		System.out.println(print);
	}
 
}