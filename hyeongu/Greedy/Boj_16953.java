import java.io.*;
import java.util.*;
public class Boj_16953 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int count = 1;
		
		while(B>A) {
			if(B%10==1) {
				B /= 10;
				count++;
			}
			else if(B%2==1) {
				count = -1;
				break;
			}			
			else {
				B /=2;
				count++;
			}
		}
		if(B!=A) {
			count = -1;
		}
		System.out.println(count);
	}
}
