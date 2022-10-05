import java.io.*;
import java.util.*;

public class Boj_3020 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] up = new int[H];
		int[] dn = new int[H];
		for(int i = 0; i<N/2; i++) {
			up[Integer.parseInt(br.readLine())]++;
			dn[Integer.parseInt(br.readLine())]++;
		}
		
		int up_cnt = N/2;
		int dn_cnt = 0;
		int min = N/2;
		int cnt = 1;
		
		for(int i = 1; i<H; i++) {
			up_cnt -= up[i];
			dn_cnt += dn[H-i];
			
			if(up_cnt + dn_cnt < min) {
				min = up_cnt + dn_cnt;
				cnt = 1;
			}
			else if(up_cnt + dn_cnt  == min) {
				cnt++;
			}
		}
		
		System.out.println(min + " " + cnt);
	}
}
