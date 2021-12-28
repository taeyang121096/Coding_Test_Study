package basic;

import java.util.*;
public class Min {

//    t = 1000
//    45000
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        for(int i = 0;i<t;i++){
            String []num = sc.nextLine().split(" ");
            int f = Integer.valueOf(num[0]);
            int s = Integer.valueOf(num[1]);
            calc(f,s);
            System.out.println(max);
            max = 1;
            min = 1;
        }
    }
    static int max=1;
    static int min =1;
//    난 요렇게
//    최대 공약수랑 최소 공배수 같이 구한거
//    ㅇㅇㅇ ㅇㅇ 걍 재귀
//    이게 백 트래킹 ㅇㅇㅇ first second
    static void calc(int f,int s){
        boolean flag = false;
        for(int i = 2;i<=45000;i++){
//             백트래킹 해준거야 이거 재귀로 하다 보면 쭉 들어갈거 잖아 45000까지ㅣㅇㅇㅇㅇㅇ
            if(i > f || i>s)
                break;
//            어디 부분 말하는겨?
//            재귀 ㅇㅇㅇㅇㅇ 얍얍 난 저걸 몰라서 쓸 생각을 못함ㅋㅋㅋㅋ
//            시간 초과 남?.? 그럼 나 백트래킹 안했음 시간 초과 났겟네
//            면접 ㄱ 하자 내가 먼저 질 문 할 까??
            if(f%i == 0 && s%i==0){
                min *= i;
                calc(f/i,s/i);
                flag = true;
                break;
            }
        }
        if(!flag)
            max = f*s*min;
    }
}
