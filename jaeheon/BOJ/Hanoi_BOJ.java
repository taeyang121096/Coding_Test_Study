import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hanoi_BOJ {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		hanoi(n, 1, 3, 2);
		System.out.println(cnt);
		System.out.println(sb.toString());
		
	}
	
	static void move(int n, int src, int dst) {
		sb.append(src + " " + dst + "\n");
		cnt++;
	}
	
	// src : 출발 dst : 목적지 tmp : 경유
	// 점화식
	// hanoi(n, src, dst, tmp)
	// if(n > 0)
	// hanoi(n-1, src, tmp, dst) // n-1개의 원판을 기둥 1에서 기둥 2로 옮긴다(재귀)
	// move(n, src, dst) // 원판n을 기둥 1에서 기둥 3으로 옮긴다.(move)
	// hanoi(n-1, tmp, dst, src) // n-1개의 원판을 기둥 2에서 기둥 3으로 옮긴다(재귀)
	
	static void hanoi(int n, int src, int tmp, int dst) {
		if(n == 1) {
			move(1, src, tmp); // 원판이 한개면 목적지로 바로 옮기면 됨
		} else {
			hanoi(n-1, src, dst, tmp); 
			move(n, src, tmp);
			hanoi(n-1, dst, tmp, src);
		}
	}
}
