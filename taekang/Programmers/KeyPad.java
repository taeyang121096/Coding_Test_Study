//import java.util.*;
//class Solution {
//    public String solution(int[] numbers, String hand) {
//        // 2580 두 엄지 손가락의 현재 키패드의 위치에서 더 가까운
//        // 두 엄지 손가락의 거리가 같다면, 오른손 잡이는 엄지, 왼손 잡이는 왼손 엄지
//        String result = "";
//        StringBuilder sb = new StringBuilder();
//        int[] left = new int[]{3,0};
//        int[] right = new int[]{3,2};
//
//        int[] middle = new int[]{0,0};
//
//        for(int i = 0; i < numbers.length; i++){
//            if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0){
//                // 현재 손가락의 위치를 알아야 함.
//                if(numbers[i] == 2){
//                    middle = new int[]{0,1};
//                    int d_left = distance(left, middle);
//                    int d_right = distance(right, middle);
//                    if(compare(d_left, d_right) == 1){
//                        if(hand.equals("right")){
//                            right = new int[]{0,1};
//                            // result += "R";
//                            sb.append("R");
//                        } else {
//                            left = new int[]{0,1};
//                            // result += "L";
//                            sb.append("L");
//                        }
//                    } else if (compare(d_left, d_right) == 0){
//                        right = new int[]{0,1};
//                        // result += "R";
//                        sb.append("R");
//                    } else {
//                        left = new int[]{0,1};
//                        // result += "L";
//                        sb.append("L");
//                    }
//                } else if (numbers[i] == 5){
//                    middle = new int[]{1,1};
//                    int d_left = distance(left, middle);
//                    int d_right = distance(right, middle);
//                    if(compare(d_left, d_right) == 1){
//                        if(hand.equals("right")){
//                            right = new int[]{1,1};
//                            // result += "R";
//                            sb.append("R");
//                        } else {
//                            left = new int[]{1,1};
//                            // result += "L";
//                            sb.append("L");
//                        }
//                    }else if (compare(d_left, d_right) == 0){
//                        right = new int[]{1,1};
//                        // result += "R";
//                        sb.append("R");
//                    } else {
//                        left = new int[]{1,1};
//                        // result += "L";
//                        sb.append("L");
//                    }
//                } else if (numbers[i] == 8){
//                    middle = new int[]{2,1};
//                    int d_left = distance(left, middle);
//                    int d_right = distance(right, middle);
//                    if(compare(d_left, d_right) == 1){
//                        if(hand.equals("right")){
//                            right = new int[]{2,1};
//                            // result += "R";
//                            sb.append("R");
//                        } else {
//                            left = new int[]{2,1};
//                            // result += "L";
//                            sb.append("L");
//                        }
//                    }else if (compare(d_left, d_right) == 0){
//                        right = new int[]{2,1};
//                        // result += "R";
//                        sb.append("R");
//                    } else {
//                        left = new int[]{2,1};
//                        // result += "L";
//                        sb.append("L");
//                    }
//                } else {
//                    middle = new int[]{3,1};
//                    int d_left = distance(left, middle);
//                    int d_right = distance(right, middle);
//                    if(compare(d_left, d_right) == 1){
//                        if(hand.equals("right")){
//                            right = new int[]{3,1};
//                            // result += "R";
//                            sb.append("R");
//                        } else {
//                            left = new int[]{3,1};
//                            // result += "L";
//                            sb.append("L");
//                        }
//                    }else if (compare(d_left, d_right) == 0){
//                        right = new int[]{3,1};
//                        // result += "R";
//                        sb.append("R");
//                    } else {
//                        left = new int[]{3,1};
//                        // result += "L";
//                        sb.append("L");
//                    }
//                }
//
//            } else if(numbers[i] == 1 | numbers[i] == 4 || numbers[i] == 7){
//                if(numbers[i] == 1){
//                    left = new int[]{0,0};
//                    // result += "L";
//                    sb.append("L");
//                } else if (numbers[i] == 4){
//                    left = new int[]{1,0};
//                    // result += "L";
//                    sb.append("L");
//                } else {
//                    left = new int[]{2,0};
//                    // result += "L";
//                    sb.append("L");
//                }
//            } else{
//                if(numbers[i] == 3){
//                    right = new int[]{0,2};
//                    // result += "R";
//                    sb.append("R");
//
//                } else if (numbers[i] == 6){
//                    right = new int[]{1,2};
//                    // result += "R";
//                    sb.append("R");
//                } else {
//                    right = new int[]{2,2};
//                    // result += "R";
//                    sb.append("R");
//                }
//            }
//        }
//
//        return sb.toString();
//    }
//
//    public int distance(int[] tmp, int[] middle){
//        int d = Math.abs(tmp[0] - middle[0]) + Math.abs(tmp[1] - middle[1]);
//
//        return d;
//    }
//
//    public int compare(int left, int right){
//        if(left > right){
//            return 0;
//        } else if (left == right){
//            return 1;
//        } else {
//            return 2;
//        }
//    }
//}
//// import java.util.*;
//// class Solution {
////     public String solution(int[] numbers, String hand) {
////         String answer = "";
////         int left = 10;
////         int right = 12;
//
////         for(int tmp : numbers){
////             if(tmp == 1 || tmp == 4 || tmp == 7){
////                 answer += "L";
////                 left = tmp;
////             } else if(tmp == 3 || tmp == 6 || tmp == 9){
////                 answer += "R";
////                 right = tmp;
////             } else {
////                 if(tmp == 0)
////                     tmp = 11;
//
////                 int left_dis = Math.abs(tmp - left) / 3 + Math.abs(tmp - left) % 3;
////                 int right_dis = Math.abs(tmp - right) / 3 + Math.abs(tmp - right) % 3;
//
////                 if(left_dis < right_dis){
////                     answer += "L";
////                     left = tmp;
////                 } else if (left_dis > right_dis){
////                     answer += "R";
////                     right = tmp;
////                 } else{
////                     if(hand.equals("right")){
////                         answer += "R";
////                         right = tmp;
////                     } else {
////                         answer += "L";
////                         left = tmp;
////                     }
////                 }
////             }
////         }
////         return answer;
////     }
//// }