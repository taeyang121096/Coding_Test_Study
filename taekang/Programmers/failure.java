//import java.util.*;
//class Solution {
//    // 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
//    // 전체 스테이지 N, stages : 사용자가 멈춰있는 스테이지,
//    // 실패율이 높은 스테이지 부터 내림차순, 배열 return
//    // 실패율이 같다면 작은 번호의 스테이지가..
//    // N + 1 인 애는 모든 스테이지를 클리어함
//    public int[] solution(int N, int[] stages) {
//        double[] ans = new double[N];
//        // 1 2 2 2 3 3 4 6
//        Arrays.sort(stages);
//
//        double people = stages.length; // 8
//        for(int i = 1; i <= N; i++){ // 1, 2, 3, 4, 5
//            int cnt = 0; // 스테이지에 도달한사람
//            for(int j = 0; j < stages.length; j++){ // 1 2 2 2 3 3 4 6
//                if(i == stages[j]){ // 1 == 1
//                    cnt++;
//                } else if(i < stages[j]){
//                    break;
//                }
//            }
//            // System.out.println(i + " " + cnt + " " + people);
//            if(people != 0){
//                ans[i-1] = cnt/people; // byzero 0
//            } else {
//                ans[i-1] = 0; // 0 . 0 -> Nan
//            }
//            people -= cnt;
//        }
//
//        List<Double> list = new ArrayList<>();
//        for(double i : ans){
//            list.add(i);
//        }
//        // Collections.sort(list);
//        // Collections.reverse(list);
//        Collections.sort(list, Comparator.reverseOrder()); // 내림차순
//
//        int[] answer = new int[N];
//        for(int i = 0; i < list.size(); i++){ // 0.5 0.5
//            for(int j = 0; j < ans.length; j++){ //  0.125 0.42 -1 -1
//                if(list.get(i) == ans[j]){
//                    answer[i] = j+1;
//                    ans[j] = -1;
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }
//}