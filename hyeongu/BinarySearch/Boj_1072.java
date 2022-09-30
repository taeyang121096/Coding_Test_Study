import java.util.*;
import java.io.*;
public class Boj_1072 {
	static long X, Y, Z;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = ((Y * 100) / X);
		
		System.out.println(binary(0, 1000000000));
	}
	
	static int binary(int left, int right) {
		int answer = -1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(((Y+mid) * 100 / (X+mid)) > Z) {
				answer = mid;
				right = mid -1;
			}
			else {
				left = mid + 1;
			}
		}
		return answer;
	}
}