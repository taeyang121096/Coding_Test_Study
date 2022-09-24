///**
// 1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것
// 2. 이모티콘 판매액을 최대한 늘리는 것
//
// 1. 각 사용자들은 자신의 기준에 따라 일정비율이상 할인 이모티콘 구매
// 2. 각 사용자들은 자신의 기준에 따라 구매비용 합이 일정가격이상이면 이모티콘 모두 취소하고 가입함
// **/
//class Solution {
//    public int[] max_arr = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
//    public int[] rate = new int[]{4,3,2,1};
//    public int[] choice;
//    public int[] Emo;
//    public int[][] user;
//    public int[] solution(int[][] users, int[] emoticons) {
//        choice = new int[emoticons.length];
//        Emo = emoticons;
//        user = users;
//
//        int[] answer = max_arr;
//
//        dfs(0, emoticons.length);
//        return answer;
//    }
//
//    public int[] doIt(){
//        int[] arr = new int[2];
//        // choice 배열과, user 배열
//        // 할인율이 이상이면 바로 구매함, 근데 구매비용이 넘어가면 이모티콘 구매를 취소하고 서비스 가입
//        // 이모티콘 할인 중인것이
//        int cnt = 0;
//        int sum = 0;
//
//        for(int i = 0; i < user.length; i++){
//            int user_want_rate = user[i][0]; // 40
//            int user_sum = 0;
//            // System.out.println(user_want_rate + " " + user_have_money);
//            for(int j = 0; j < choice.length; j++){ //
//                if(user_want_rate <= choice[j]*10){ //
//                    user_sum += Emo[j] - (Emo[j] * (choice[j] / 10.0));
//                }
//                // System.out.println(user[i][1] + " " + user_sum);
//            }
//
//            if(user_sum >= user[i][1]){
//                cnt++;
//                // System.out.println("sum : " + sum + " cnt : " + cnt);
//            } else {
//                sum += user_sum;
//                // System.out.println("sum : " + sum + " cnt : " + cnt);
//            }
//        }
//        arr[0] = cnt;
//        arr[1] = sum;
//        cnt = 0;
//
//        return arr;
//    }
//
//    public void dfs(int idx, int depth){
//        if(idx == depth){
//            // for(int i = 0; i < choice.length; i++){
//            //     System.out.print(choice[i] + " ");
//            // }
//            // System.out.println();
//            // 이제 choice 가지고 구하기
//            int[] get_arr = doIt();
//
//            if(max_arr[0] < get_arr[0]){
//                max_arr[0] = get_arr[0];
//                max_arr[1] = get_arr[1];
//            } else if (max_arr[0] == get_arr[0]){
//                if(max_arr[1] < get_arr[1]){
//                    max_arr[0] = get_arr[0];
//                    max_arr[1] = get_arr[1];
//                }
//            }
//            return;
//        }
//
//        for(int i = 0; i < rate.length; i++){
//            choice[idx] = rate[i];
//            dfs(idx + 1, depth);
//        }
//    }
//}