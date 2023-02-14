// 수정 후

import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        if(scores.length == 1) return answer;
        int[][] arr = Arrays.copyOfRange(scores, 1, scores.length);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i][0] > scores[0][0]){
                if(arr[i][1] > scores[0][1]){
                    return -1;
                }
                continue;
            } 
            break;
        }
        
        int max = 0;
        for(int [] now : arr){
            if(max > now[1]) continue;
            
            pq.add(now[0] + now[1]);
            max = Math.max(max, now[1]);
        }
        
        int wanho = scores[0][0] + scores[0][1];
        while(!pq.isEmpty()){
            if(pq.poll() <= wanho){
                break;
            }
            answer++;
        }
        return answer;
    }
}


// 수정 전 코드

//import java.util.*;

// class Solution {
//     public int solution(int[][] scores) {
//         int answer = 1;
//         if(scores.length == 1) return answer;
//         int[][] arr = Arrays.copyOfRange(scores, 1, scores.length);
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
//         Arrays.sort(arr, (o1, o2) -> {
//             return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
//         });
        
//         for(int i = 0; i < arr.length; i++){
//             if(arr[i][0] > scores[0][0]){
//                 if(arr[i][1] > scores[0][1]){
//                     return -1;
//                 }
//                 continue;
//             } 
//             break;
//         }
//         int wanho = scores[0][0] + scores[0][1];
//         int last = arr[0][0];
//         int max = 0;
//         int tmp = 0;
        
//         for(int [] now : arr){
//             if(last == now[0]){
//                 if(max <= now[1]){
//                     pq.add(now[0] + now[1]);
//                     tmp = Math.max(tmp, now[1]);
//                 }
//                 continue;
//             }
//             max = Math.max(max, tmp);
//             if(max <= now[1]){
//                 pq.add(now[0] + now[1]);
//                 last = now[0];
//                 tmp = Math.max(tmp, now[1]);
//             }
//         }
        
//         while(!pq.isEmpty()){
//             if(pq.poll() <= wanho){
//                 break;
//             }
//             answer++;
//         }
//         return answer;
//     }
// }