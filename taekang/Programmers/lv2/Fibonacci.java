//class Solution {
//    public int solution(int n) {
//        int answer = 0;
//        int[] arr = new int[100001];
//        arr[0] = 0;
//        arr[1] = 1;
//        arr[2] = 1;
//
//        for(int i = 3; i < arr.length; i++){
//            arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
//        }
//
//        answer = arr[n];
//
//        return answer;
//    }
//
//}