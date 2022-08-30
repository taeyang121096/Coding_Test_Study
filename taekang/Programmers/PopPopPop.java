//// 인접한 두 풍선중 하나를 터뜨림
//// 번호가 작은 풍선은 한번만 가능
//// 빈공간이 생기면 중앙으로 밀착
//// 풍선을 하나만 남기고 모두 터트리는 경우의 수 리턴
//// 풍선의 숫자는 모두 다름
//
//import java.util.*;
//
//class Solution {
//    public int solution(int[] a) {
//
//        int left = a[0];
//        int right = a[a.length - 1];
//        int[] leftArr = new int[a.length];
//        int[] rightArr = new int[a.length];
//
//        for(int i = 1; i < a.length - 1; i++){
//            if(a[i] < left){
//                left = a[i];
//            }
//            leftArr[i] = left;
//        }
//
//        for(int i = a.length - 2; i > 0; i--){
//            if(a[i] < right){
//                right = a[i];
//            }
//            rightArr[i] = right;
//        }
//
//        // for(int i = 0; i < leftArr.length; i++){
//        //     System.out.print(leftArr[i] + " ");
//        // }
//        // System.out.println();
//        // System.out.println(left);
//        // System.out.println();
//        // for(int i = 0; i < rightArr.length; i++){
//        //     System.out.print(rightArr[i] + " ");
//        // }
//        // System.out.println();
//        // System.out.println(right);
//
//        int answer = 2;
//        for(int i = 1; i < a.length - 1; i++){
//            if(a[i] > leftArr[i] && a[i] > rightArr[i]){
//                continue;
//            }
//            answer++;
//        }
//
//        return answer;
//    }
//}