import java.io.*;

// 백준 설탕배달  2839
public class SugarDelivery_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(n % 5 != 0) {
			if(n < 0) {
				System.out.println(-1);
				return;
			}
			n-=3;
			count++;
		}
		count+=n/5;
		sb.append(count);
		
		System.out.println(sb);
	}
}
