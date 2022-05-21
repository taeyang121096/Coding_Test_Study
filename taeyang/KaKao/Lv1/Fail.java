import java.util.*;
class Solution {

	static Map<Integer,Integer> play;
	static Map<Integer,Integer> clear;

	static Map<Double,List<Integer>> sequenceRate;
	//     rate 계산
	static double rate(int clear, int play){
		if(play == 0)
			return 0;
		return (double)clear/(double)play;
	}
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
//         초기화
		play = new HashMap<>();
		clear = new HashMap<>();

//         Rate 별 오름차순 Key 정렬
		sequenceRate = new TreeMap<Double, List<Integer>>((r1,r2) -> r1 > r2 ? -1 : 1);

//         초기화
		for(int i = 1;i<=N;i++){
			play.put(i,0);
			clear.put(i,0);
		}
//         count 해주기
		for(int stage : stages){
			for(int i = 1;i<=stage;i++){
//                 N 보다 큰 값 제거
				if(i > N)
					break;
				play.put(i,play.get(i)+1);
			}
			for(int i = 1;i<stage;i++){
				clear.put(i,clear.get(i)+1);
			}
		}
//         rate 구해주기
		for(int i =1;i<=N;i++){
			double rate = rate(clear.get(i),play.get(i));

			if(sequenceRate.containsKey(rate)){
				sequenceRate.get(rate).add(i);
			}else{
				List<Integer> st = new ArrayList<>();
				st.add(i);
				sequenceRate.put(rate,st);
			}
		}

		int idx = 0;
//         return
		for(double key : sequenceRate.keySet()){
			System.out.println(key);
		}

		return answer;
	}
}
