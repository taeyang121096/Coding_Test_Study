import java.util.*;

public class baek_10870 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		System.out.println(tail(N));
	}
	//루프 사용
	public static Integer loof(Integer num) {
		int[] answer = new int[num+1];
		answer[0] = 0;
		answer[1] = 1;
		if(num>=2) {
			for(int i = 2; i<=num;i++) {
				answer[i] = answer[i-1] + answer[i-2];
			}
		}
		return answer[num];
	}
	//일반 재귀 사용
	public static Integer recursion(Integer num) {
		if(num==1) return 1;
		else if(num == 0) return 0;
		return recursion(num-1) + recursion(num-2);
	}
	//꼬리 재귀 사용
	public static Integer tail(Integer num) {
		return tailrec(num, 1, 0);
	}
	public static Integer tailrec(Integer num, Integer before, Integer beforebefore) {
		if(num<1) return beforebefore;
		return tailrec(num-1, before+beforebefore , before);
	}
}