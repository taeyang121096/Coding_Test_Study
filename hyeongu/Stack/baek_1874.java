import java.io.*;
import java.util.*;
 
public class baek_1874 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int temp = 0;//스택에 마지막으로 push한 숫자를 저장
		
		while(N-- > 0) {
			int command = Integer.parseInt(br.readLine());
			
			//마지막으로 push한 숫자보다 command가 크면 command까지 push
			if(command > temp) {
				for(int i = temp + 1; i <= command; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				//마지막으로 push한 숫자 저장
				temp = command;
			}
			//top에 있는 숫자와 command가 달라 출력이 불가능한 경우 NO출력
			else if(stack.peek() != command) {
				System.out.println("NO");
				System.exit(0);
			}
			//top에 있는 숫자 pop
			stack.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
}