import java.io.*;
import java.util.*;
 
public class baek_1021 {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
				
		int count = 0;
		int[] seq = new int[M];
		
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		for(int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
				
		for(int i = 0; i < M; i++) {
			int find = deque.indexOf(seq[i]);
			int center;

			if(deque.size() % 2 == 0) {
				center = deque.size() / 2 - 1;
			}
			else {
				center = deque.size() / 2;
			}
			
			if(find <= center) {
				for(int j = 0; j < find; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			}
			else {
				for(int j = 0; j < deque.size() - find; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			}
			deque.pollFirst();
		}
		System.out.println(count);
	}
}