//class Solution {
//    public int solution(int[][] dots) {
//        int answer = 0;
//
//        int[][] map
//                = {{0,1},{2,3}, {0,2},{1,3}, {0,3},{1,2}};
//
//        for(int i = 0; i < 6; i=i+2){
//            int[] a = map[i]; // 0,1
//            int[] b = map[i+1]; // 2,3
//
//            int[] tmp1 = dots[a[0]]; // 1,4
//            int[] tmp2 = dots[a[1]]; // 9,2
//
//            int[] tmp3 = dots[b[0]]; // 3,8
//            int[] tmp4 = dots[b[1]]; // 10,2
//
//            double x_inc = (double)(tmp2[1] - tmp1[1]) / (double)(tmp2[0] - tmp1[0]);
//            double y_inc = (double)(tmp4[1] - tmp3[1]) / (double)(tmp4[0] - tmp3[0]);
//
//            // System.out.println(x_inc + " " + y_inc);
//
//            if(x_inc == y_inc) answer++;
//        }
//        if(answer > 0){
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//}