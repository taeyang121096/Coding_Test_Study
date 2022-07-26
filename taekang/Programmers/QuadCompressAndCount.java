//import java.util.*;
//
//class Solution {
//    static int[] answer;
//    public int[] solution(int[][] arr) {
//        answer = new int[2];
//        int move = arr.length; // 4
//        // 재귀 결국에는 재귀아닌가 ?
//        // 1. 변수 생성
//        // 2. 탈출 조건
//        recur(arr, 0, 0, move); // (arr, 4, 4)
//        return answer;
//    }
//
//    public void recur(int[][] arr, int col, int row, int idx){ // 0, 0, 4
//        if(idx == 1){
//            // 여기서 해당 하는 애들을 검증하고 배열에 더해주는 로직을 짜자
//            if(arr[col][row] == 0){
//                answer[0] += 1; // 0일떄 1더해주고
//            } else{
//                answer[1] += 1; // 1일때 1더해줘
//            }
//            return;
//        } else if(isAllSame(arr, col, row, idx)){
//            plusAns(arr, col, row, idx);
//            return;
//        } else { // 여기는 Idx 도 1이 아니고 다 같은 애들도 아니니까 나누어주는 로직을 짜자
//            // 0,0 0,2 2,0 2,2
//            int i = idx / 2; // 4/2 = 2
//            recur(arr, col, row, i); // arr, 0, 0, 2
//            recur(arr, col+i, row, i); // arr, 2, 0, 2
//            recur(arr, col, row+i, i); // arr, 0, 2, 2
//            recur(arr, col+i, row+i, i); // arr, 2, 2, 2
//        }
//    }
//
//    public boolean isAllSame(int[][] arr, int col, int row, int idx){ // 0, 2, 2
//        int dif = arr[col][row];
//        for(int i = 0; i < idx; i++){ // 0, 1
//            for(int j = 0; j < idx; j++){ // 0, 1
//                if(dif != arr[col+i][row+j])
//                    return false;
//            }
//        }
//        return true;
//    }
//
//    public void plusAns(int[][] arr, int col, int row, int idx){ // arr, 0, 0, 2
//        if(arr[col][row] == 0){
//            answer[0] += 1; // 0일떄 1더해주고
//        } else{
//            answer[1] += 1; // 1일때 1더해줘
//        }
//    }
//}