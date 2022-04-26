import java.util.*;
public class Ngame {

    class Solution {

        //     n -> 진법 : 2 ~ 16
//     t -> 숫자 개수 0 ~ 1000
//     m -> 게임에 참가 하는 인원 2 ~ 100
//     p -> 튜브의 순서 1 ~ m
//     10 ~ 15 -> A ~ F
//     1. -> 숫자를 0 ~ 시작 -> 단 sb -> length() == t break;
//     2. -> n 과 num -> list 뽑아낸다 -> list.size() -> if(p) -> sb.append(list.get(idx))
//                                                    else if(idx+1%m)
//     0 , 1 , 10 , 11 , 100 , 101
//     0111
        StringBuilder sb = new StringBuilder();

        StringBuilder nNotation(int n,int number){
            StringBuilder s  = new StringBuilder();
            if(number == 0)
                return s.append(0);
            while(number > 0){
                if(number % n < 10){
                    s.append(number%n);
                }else{
                    s.append((char)(number%n-10+'A'));
                }
                number /= 10;
            }


            return s;
        }

        public String solution(int n, int t, int m, int p) {

            int number = 0;
            StringBuilder nN;

            while(true){

                if(sb.length() == t)
                    break;
                nN = nNotation(n,number);

                for(int idx = 0;idx<nN.length();idx++){
                    if((idx+1)%m == p && m != p){
                        sb.append(nN.charAt(idx));
                    }else{
                        if((idx+1)%m == 0 && m == p){
                            sb.append(nN.charAt(idx));
                        }

                    }


                }
                System.out.println(nN.toString()+"===="+sb.toString());
                number++;
            }

            return sb.toString();
        }
    }
}
