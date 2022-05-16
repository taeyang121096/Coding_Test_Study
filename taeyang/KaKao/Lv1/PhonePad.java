
import java.util.*;


    class Solution {
        /*
            numbers 1 ~ 1000 -> 0 ~ 9
            hand -> left, right
            왼 -> L
            오 -> R


            data structure ->  Map
            00 01 02
            10 11 12
            20 21 22
            30 31 32

        */
//     초기화
        static Map<Integer,String> rl = new HashMap<>(){{
            put(1,"L");
            put(4,"L");
            put(7,"L");
            put(3,"R");
            put(6,"R");
            put(9,"R");
        }};
        static Map<Integer,int[]> loc = new HashMap<>(){{
            put(1,new int[]{0,0});
            put(2,new int[]{0,1});
            put(3,new int[]{0,2});
            put(4,new int[]{1,0});
            put(5,new int[]{1,1});
            put(6,new int[]{1,2});
            put(7,new int[]{2,0});
            put(8,new int[]{2,1});
            put(9,new int[]{2,2});
            put(0,new int[]{3,1});
        }};
        static int calc(int num, int[] location,String hand){
            int cost = 0;
            if(num == -1){
                if(hand.equals("L")){
                    cost = Math.abs(location[0]-3) + Math.abs(location[1]-0);
                }else{
                    cost = Math.abs(location[0]-3) + Math.abs(location[1]-0);
                }
            }else{
                cost = Math.abs(location[0]-loc.get(num)[0]) + Math.abs(location[1]-loc.get(num)[1]);
            }
            return cost;
        }

        public String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();
//         가상의 값 *, #
            int left = -1;
            int right = -1;
//         숫자 문자열로 바꾸는 부분
            for(int num : numbers){
                if(rl.containsKey(num)){
                    if(rl.get(num).equals("L")){
                        left = num;
                    }else{
                        right = num;
                    }
                    sb.append(rl.get(num));
                }else{
                    int lcost = 0;
                    int rcost = 0;
                    lcost = calc(left,loc.get(num),"L");
                    rcost = calc(right,loc.get(num),"R");
                    if(lcost == rcost){
                        if(hand.equals("right")){
                            sb.append("R");
                            right = num;
                        }else{
                            sb.append("L");
                            left = num;
                        }
                    }else{
                        if(lcost < rcost){
                            sb.append("L");
                            left = num;
                        }else{
                            sb.append("R");
                            right = num;
                        }
                    }
                }
            }

            return sb.toString();
        }
    }


