import java.io.*;
import java.util.*;
 
public class boj_2805 {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int tree = M; // 가져가야할 나무 중 남은 나무
		Integer[] arr = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
 
		Arrays.sort(arr, Collections.reverseOrder());
		int H = arr[0];
		for(int i = 0; i < N; i++) {
			if(i==N-1) {
				if(tree%(i+1)==0) {
					H -= tree/(i+1);
				}
				else {
					H -= tree/(i+1)+1;
				}
				break;
			}
			if(arr[i]>arr[i+1]) {
				if((arr[i]-arr[i+1])*(i+1)>=tree) {
					if(tree%(i+1)==0) {
						H -= tree/(i+1);
					}
					else {
						H -= tree/(i+1)+1;
					}
					break;
				}
				else {
					tree -= (arr[i]-arr[i+1])*(i+1);
					H -= arr[i]-arr[i+1];
					arr[i] = arr[i+1];
				}
			}
		}
		System.out.print(H);
	}
}