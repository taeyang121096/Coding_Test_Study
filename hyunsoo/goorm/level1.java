package hyunsoo.goorm;
import java.io.*;
public class level1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		for(int j=input; j>0; j--){
			for(int i=j; i>0; i--){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
