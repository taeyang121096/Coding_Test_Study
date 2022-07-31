//import java.util.*;
//class Solution{
//    public int min = Integer.MIN_VALUE;
//    public int solution(int []A, int []B){
//        int answer = 0;
//        Integer[] A_arr = new Integer[A.length];
//        Integer[] B_arr = new Integer[B.length];
//        for(int i = 0; i < A.length; i++){
//            A_arr[i] = A[i];
//            B_arr[i] = B[i];
//        }
//        Arrays.sort(A_arr);
//        Arrays.sort(B_arr, Collections.reverseOrder());
//
//        for(int i = 0; i < A.length; i++){
//            answer += A_arr[i] * B_arr[i];
//        }
//        return answer;
//    }
//}
