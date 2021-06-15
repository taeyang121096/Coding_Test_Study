import java.io.*;
import java.util.*;
 
public class baek_1966 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
 
		while (T-- > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
 
			for (int i = 0; i < N; i++) {
				// 큐에 초기 인덱스와 중요도를 포함하는 배열을 삽입 
				queue.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
			int count = 0;
			
			while (!queue.isEmpty()) {
				// 첫번째 원소를 poll한 뒤 남아있는 원소들과 중요도를 비교
				int[] first = queue.poll();
				boolean isMax = true;
				
				for(int i = 0; i < queue.size(); i++) {
					
					// 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우 i이전의 원소를 rotate
					if(first[1] < queue.get(i)[1]) {
						queue.offer(first);
						
						for(int j = 0; j < i; j++) 
							queue.offer(queue.poll());
						
						isMax = false;
						break;
					}
				}
				// first가 우선순위가 가장 높지 않으므로 넘어감
				if(isMax == false) continue;

				// first 원소의 우선순위가 가장 높을경우
				count++;
				// first가 M이었다면 종료
				if(first[0] == M) {
					break;
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
}
