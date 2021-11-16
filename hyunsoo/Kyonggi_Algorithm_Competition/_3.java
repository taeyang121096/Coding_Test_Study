package Kyonggi_Algorithm_Competition;
import java.util.*;
import java.io.*;
public class _3 {
  static int answer=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<10; i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
				
		for(int i=0; i<10; i++){
			check(arr[i]);
		}
			
		System.out.println(answer);
	}
	public static void check(int num){
		Set<Integer> set = new HashSet<>();
		
		while(true){
			if(num==1) {answer++; return;}
			if(set.contains(num)) return;
			
			set.add(num);
			
			int tmp = 0;
			
			while(num!=0){
				int t = num%10;
				tmp +=t*t;
				num=num/10;			
			}
			
			num = tmp;	
		}
	}
}
