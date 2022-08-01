import java.io.*;
import java.util.*;

public class BOJ_1302 {
	public static void main(String[] args) throws IOException{
		HashMap<String,Integer> hm = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		String maxStr = "";
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			
//			if(hm.containsKey(str)) {
//				hm.put(str, hm.get(str)+1);
//			}
//			else {
//				hm.put(str, 1);
//			}
			hm.put(str, hm.getOrDefault(str, 0) + 1);
		}
		System.out.println(hm);
		for(String key : hm.keySet()) {
			if(hm.get(key) > max) {
				max = hm.get(key);
				maxStr = key;
			}
			else if(hm.get(key) == max) {
				if(maxStr.compareTo(key)>0) {
					maxStr = key;
				}
			}
		}
		System.out.println(maxStr);
	}
}

