///**
// 등차 수열을 판단해라..
//
// **/
//class Solution {
//    public int solution(int[] common) {
//        int answer = 0;
//        // 공비인지 공차인지 판단하는걸...
//        int r = common[1] - common[0];
//        int r2 = common[2] - common[1];
//
//        if(r==r2){
//            return common[common.length-1]+r;
//        } else {
//            int k = r2/r;
//            return common[common.length-1]*k;
//        }
//
//    }
//}