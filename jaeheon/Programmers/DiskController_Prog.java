// sjf 스케줄링
// -> jobs를 시작 시각으로 오름차순 정렬
//현재 시간보다 작거나 같은 요청 시간을 큐에 추가
// 큐가 비어있으면 요청 시간이 제일 앞인 작업 추가
// 큐가 비어있지 않으면 작업 소요시간이 가장 빠른 작업 수행

import java.util.*;

class DiskController_Prog {
    public int solution(int[][] jobs) {
        int answer = 0;
        int cnt = 0;
        int time = 0;
        int index = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] > o2[0] ? 1 : -1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] > o2[1] ? 1 : -1);
        
        while(cnt < jobs.length){
            // 현재시간보다 작거나 같은 요청시점을 큐에 추가
            while(index < jobs.length && jobs[index][0] <= time){
                pq.offer(jobs[index++]);
            }
            // 큐가 비어있으면
            if(pq.isEmpty()){
                time = jobs[index][0];
            }
            //큐가 차있으면
            else{
                // 작업 소요시간이 가장 빠른 작업
                int tmp[] = pq.poll();
                answer += time - tmp[0] + tmp[1] ;
                time += tmp[1];
                cnt++;
            }
        }
        
        return answer/jobs.length;
    }
}