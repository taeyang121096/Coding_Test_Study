package algorithmTest;
import java.util.*;
import java.io.*;
public class Lts {
	
	static int ans = Integer.MIN_VALUE;

	
	public void search(ArrayList<Integer>list, int val) {
		int start = 0, end = list.size()-1;
		
		while(start < end) {
			int mid = (start+end)/2;
			
			if(val > list.get(mid)) start = mid +1;
			else end = mid;
			
		}
		list.set(end, val);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Lts l = new Lts();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		list.add(Integer.parseInt(st.nextToken()));
		
		while(st.hasMoreTokens()) {
			int val = Integer.parseInt(st.nextToken());
			if(val > list.get(list.size()-1)) list.add(val);
			else l.search(list,val);
		}
		
		System.out.print(list.size());
		

	}

}
