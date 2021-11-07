package basic;
import java.util.*;
public class GoldVa {
    static boolean[] p;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int num = -1;
        p = new boolean[1000001];
//        여기가 소수 체크 ㅇㅋㅇㅋ
//        끝? ?  근데 이렇게 쉬운 문제들 있잖아
        for(int i =3;i<p.length;i++){
            if(prime(i))
                p[i] = true;
        }
        while(true){
            num = Integer.parseInt(sc.nextLine());
            int[] ans = new int[2];
            if(num == 0)
                break;
//            종료 조건
//            여기서 보면 무조건 3 부터 시작이잔항?
//            그리고 여기서 또 보면 8이라고 가정을 하면
//            3 5 , 5 3 이렇게 만 되잖아 이해 됮?
//            10 = 3 7 ,5 5 ,7 3 ㅇㅇ 이게 절반을ㅇㅇ

            for(int i = 3;i<=num/2;i+=2){
                int a = i;
                int b = num-i;
                if(p[a] && p[b]){
                    ans[0] = a;
                    ans[1] = b;
                    break;
                }
            }
//            여기서 값이 없으면 0이면 갑싱 없는거
//            시간 얼마나 왔어?
            if(ans[0]==0 && ans[1] ==0)
                System.out.println("Goldbach's conjecture is wrong.");
            else
                System.out.println(num+" = "+ans[0]+" + "+ans[1]);
        }
    }
    static boolean prime(int num){
        for(int i = 2;i<=Math.sqrt(num);i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
}
