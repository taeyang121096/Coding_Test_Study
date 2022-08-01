package BOJ;

//백준 1302 베스트셀러

import java.io.*;
import java.util.*;

public class BestSeller_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if(!hm.containsKey(str)) {
				hm.put(str, 1);
			} else {
				hm.put(str, hm.get(str) + 1);
			}
		}
		
//		for (int i = 0; i < n; i++) {
//            String str = br.readLine();
//            hm.put(str, hm.getOrDefault(str, 0) + 1); // get한 값이 있으면  가져온 값 + 1 아니면 0 + 1
//        }
		
//		int maxCnt = 0;
//		for(String key : hm.keySet()) {
//			maxCnt = Math.max(maxCnt, hm.get(key));
//		}	
//		ArrayList<String> al = new ArrayList<String>(hm.keySet());
//        Collections.sort(al);
//        
//        for(String str : al){
//            if(hm.get(str) == maxCnt){
//                System.out.println(str);
//                break;
//            }
//        }
		
		int cnt = 0;
		String answer = "";
		for(String key : hm.keySet()) {
            if(hm.get(key) > cnt) { // 저장된 개수보다 많으면
            	cnt = hm.get(key); // 개수를 현재 값으로 변경
            	answer = key; // 답을 변경
            } else if(cnt == hm.get(key)) { // 저장된 개수와 같으면
            	if(answer.compareTo(key) > 0) { // 문자열 비교
            		answer = key; // 사전순으로 변경
            	}
            }
        }
		System.out.println(answer);
	}
}
