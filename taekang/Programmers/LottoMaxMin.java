//// import java.util.*;
//// class Solution {
////     // 순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 ㅇㅈ
////     // 알아 볼 수 없는 두개의 숫자로 가정, 몇등..몇등
////     // 당첨 될 수 있는 최고 순위와 최저 순위는 ?
//
////     // 45  4  35  20  3  9
////     // 45  4  35  20  3  9
////     // 만약 다 일치 한다면,
//
////     // 만약 2개만 일치 하는데, 0이 2개야 ?  그러면 제일 높은건 3등 낮은건  5등 이겠지
////     // 만약 0개가 일치 하는데, 0이 6개야 ?  그러면 제일 높은건 6등 낮은건 1등이겠지
////     static int zeroCnt = 0;
////     static int rightCnt = 0;
////     public int[] solution(int[] lottos, int[] win_nums) {
////         int[] answer = new int[2];
////         for(int i = 0; i < lottos.length; i++){
////             if(lottos[i] == 0)
////                 zeroCnt++;
////             else{
////                 for(int j = 0; j < win_nums.length; j++){
////                     if(lottos[i] == win_nums[j]){
////                         rightCnt++;
////                     }
////                 }
////             }
////         }
////         // 최고 : rightCnt + zeroCnt = 0 + 6 = 1등
////         // 최저 : rightCnt
////         int max = rightCnt + zeroCnt;
////         int min = rightCnt;
//
////         answer[0] = rank(max);
////         answer[1] = rank(min);
//
////         return answer;
////     }
//
////     public int rank(int cnt){
////         switch(cnt){
////             case 6 : return 1;
////             case 5 : return 2;
////             case 4 : return 3;
////             case 3 : return 4;
////             case 2 : return 5;
////             default : return 6;
//
////         }
////     }
//
////     public static void main(String args[]){
////         System.out.println("hello");
////     }
//// }
//import java.util.*;
//class Solution {
//    public int[] solution(int[] lottos, int[] win_nums) {
//        int[] answer = new int[2];
//        return answer;
//    }
//}