package Kyonggi_Algorithm_Competition;
import java.io.*;
import java.util.*;

public class _8 {
  public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int left=0;
		int right=0;
		
		List<Integer> list = new LinkedList<>();
		list.add(100);
		list.add(50);
		list.add(20);
		list.add(10);
		list.add(5);
		list.add(2);
		list.add(1);
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++){
			int tmp = Integer.parseInt(st.nextToken());
			if(left == right){
				left += tmp;
			}else{
				if(left> right) right+=tmp;
				else left+=tmp;
			}
		}
		
		int tmp = Math.abs(left-right);
		
		int answer = 0;
		
		while(tmp>0){
			for(int i=0; i<list.size(); i++){
				if(list.get(i)<=tmp){
					answer += tmp/list.get(i);
					tmp = tmp % list.get(i);
				}
			}
		}
		
		System.out.print(answer);
		
	}
}
