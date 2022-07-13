//class Solution {
//    // n * n 각 칸은 공백, 벽#
//    // 전체지도 : 두장의 지도, 각각 지도1, 지도2
//    // 지도 1과 지도 2 에서 공백인 부분은 전체 지도에서도 공백
//    // 지도 1과 지도 2는 정수 배열로 암호화
//    // 벽 : 1, 공백 0
//    public String[] solution(int n, int[] arr1, int[] arr2) {
//        String[] answer = new String[n];
//        int[][] map1 = new int[n][n]; // 5 5
//        int[][] map2 = new int[n][n]; // 5 5
//        // n
//        for(int i = 0; i < n; i++){
//            String tmp = Integer.toBinaryString(arr1[i]);
//            char[] charArr = tmp.toCharArray();
//
//            String tmp2 = Integer.toBinaryString(arr2[i]);
//            char[] charArr2 = tmp2.toCharArray();
//
//            int cnt = n - tmp.length(); // 5 - 4
//            int cnt2 = n - tmp2.length(); // 5 - 5
//
//            for(int j = 0; j < cnt; j++){ // 1
//                map1[i][j] = 0;
//            }
//
//            for(int j = cnt; j < n; j++){  // 1 2 3 4
//                map1[i][j] = charArr[j-cnt] - '0';
//            }
//
//            for(int j = 0; j < cnt2; j++){ // 0
//                map2[i][j] = 0;
//            }
//
//            for(int j = cnt2; j < n; j++){
//                map2[i][j] = charArr2[j-cnt2] - '0';
//            }
//        }
//
//        for(int i = 0; i < n; i++){
//            String tmp = "";
//            for(int j = 0; j < n; j++){
//                if(map1[i][j] == 0 && map2[i][j] == 0){
//                    tmp += " ";
//                } else {
//                    tmp += "#";
//                }
//            }
//            answer[i] = tmp;
//        }
//        return answer;
//    }
//}