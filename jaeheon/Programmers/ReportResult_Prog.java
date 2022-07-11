package Programmers;

//k번 이상 신고하면 정지
//여러번 신고함 -> 1회로 처리
//처리 결과 메일을 받은 횟수를 리턴
//report -> 이용자, 신고한 사람
//에제 1 -> 무지가 프로도와 네오를 신고했는데 프로도와 네오가 각각 k번(2번) 신고당해서 처리메일을 두번 받음

import java.util.*;

public class ReportResult_Prog {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		HashMap<String, Integer> hm = new HashMap<>();
		HashSet<String> reports = new HashSet<>();

		for (int i = 0; i < id_list.length; i++) {
			hm.put(id_list[i], i); // 무지 : 0, 프로도 : 1, 어피치 : 2, 네오 : 3
		}

		int[] cnt = new int[id_list.length]; // 신고당한 횟수

		for (int i = 0; i < report.length; i++) {
			if (reports.contains(report[i])) {
				continue;
			}
			String[] str = report[i].split(" ");
			cnt[hm.get(str[1])]++; // 신고당한 사람 ++
			reports.add(report[i]); // 중복 아닌것만 추가 ryan con 거를 수 있음
		}

//         // 해시셋 출력
// 	    Iterator it = reports.iterator();
// 	    while(it.hasNext()){
// 	        System.out.println(it.next());
// 	    }

//         // 멤버 별 신고당한 횟수
//         for(int i = 0; i < cnt.length; i++){
//             System.out.println(hm.get(id_list[i]) + " : " + cnt[i]); 
//         }

		// 잘못된 포문
		// for(int i = 0; i < reports.size(); i++){
		// String[] str = reports[i].split(" "); -> hashset 이라서 향상된 포문 사용해야함
		// if(cnt[hm.get(str[1])] >= k){
		// answer[hm.get(str[0])]++;
		// }
		// }

		for (String tmp : reports) {
			String[] str = tmp.split(" ");
			if (cnt[hm.get(str[1])] >= k) {
				answer[hm.get(str[0])]++;
			}
		}

		return answer;
	}
}
