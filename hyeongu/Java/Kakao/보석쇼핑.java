	public static int[] solution(String[] gems) {
		int length =gems.length;
		int start = 0;
		int answer_start = 0;
		int end = gems.length;
		Map<String,Integer> map = new HashMap<>();
    
		// 맵에 보석이름과 갯수를 추가
		for(int i = 0; i< length; i++) {	
			if(!map.containsKey(gems[i])){	
				map.put(gems[i], 1);
			}else {
				map.put(gems[i], map.get(gems[i])+1);
			}
		}
    
		// 구매할 보석갯수
		int answerLength = map.size();
		// 맵 초기화
		map.clear();
		Queue<String> q1 = new LinkedList<>();
    
		for(int i = 0 ; i < length; i++) {
			// 맵에 보석이름과 갯수를 추가 후 큐에 삽입
			if(!map.containsKey(gems[i])) {
				map.put(gems[i], 1);
			}
			else {
				map.put(gems[i], map.get(gems[i])+1);
			}
			q1.add(gems[i]);
      
			while(!q1.isEmpty()) {
				String left = q1.peek();
				int check = map.get(left);
				// 큐의 맨 앞의 보석이 2개이상일 경우 큐에서 제거
				if(check>=2) {
					map.put(left, map.get(left)-1);
					q1.poll();
					start++;
				}else {
					break;
				}
			}
      // 맵의 사이즈와 구해야할 보석의 갯수가 같고 길이가 더 짧을경우 answer 변경
			if(map.size()==answerLength&&end>q1.size()) {
				end=q1.size();
				answer_start = start;
			}
		}
		int[] answer = {answer_start +1, answer_start + end + 1};
		return answer;
	}
