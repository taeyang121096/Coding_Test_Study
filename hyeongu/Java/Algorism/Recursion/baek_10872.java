import java.util.*;

public class baek_10872 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		System.out.println(tail(N));
	}
	//루프 사용
	public static Integer loof(Integer num) {
		int answer = 1;
		
		for(int i = 1; i<=num;i++) {
			answer *= i;
		}
		return answer;
	}
	//일반 재귀 사용
	public static Integer recursion(Integer num) {
		if(num==1) return 1;
		return num*recursion(num-1);
	}
	//꼬리 재귀 사용
	public static Integer tail(Integer num) {
		return tailrec(num, 1);
	}
	public static Integer tailrec(Integer num, Integer res) {
		if(num==1) return res;
		return tailrec(num-1, res*num);
	}
	
}