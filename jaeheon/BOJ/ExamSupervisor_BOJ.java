package BOJ;

// a - 응시자 수 
// b - 총감독관이 한 시험장에서 감시할 수 있는 응시자 수
// c - 부감독관이 한 시험장에서 감시할 수 있는 응시자 수
// 한 시험장에서 총 감독관은 오직 1명
// 부 감독관은 제한 없음

import java.util.*;
import java.io.*;

public class ExamSupervisor_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i = 0;i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken()); // 총감독관
		int c = Integer.parseInt(st.nextToken()); // 부감독관
		
		long count = 0;
		
		for(int i = 0; i < n; i++) {
			if(arr[i] - b <= 0) {
				count++;
			} else {
				count++;
				if((arr[i]-b)%c == 0) {
					count+=(arr[i]-b)/c;
				} else {
					count+=(arr[i]-b)/c + 1;
				}
			}
		}
		System.out.println(count);
		
	}
}
