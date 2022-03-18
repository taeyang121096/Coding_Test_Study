package Sujong;

import java.io.*;
import java.util.*;
/*

1. n과 m -> 1 ~ 8
2. 수열 : 숫자로 이루어진 하나의 수 조합이다 이렇게 생각하면 되요~~

1. 순서 신경 써서 구하기 -> 1,2 1,3 1,4 2,1 2,3 -> 순열이다 ㅇㅋ??
2. boolean array -> 첫번 째 자리에 2 가 뽑혔으면 두번째 자리에는 뽑히면
3. 2 => true   if(true) continue;
4. 1 2 3 4
   f t f f
3. 사전 순이라 했잔항 -> 배열을 정렬해서 넣으면 된다

1. int[] array = new int[n+1] -> 0 그냥 0으로 놓고 1 2 3 4
2. boolean[] flag = new boolean[n+1]
 */
public class NM1 {


//    0 1 2 3 4
    static boolean[] flag;
    static int m;
    static int n;
//    tmp -> 2   level 0 -> 0 1
//    tmp -> 길이가 2야아아아앙아ㅡ아아아아아아ㅏ아아아아아아아아앙
//    level = 0 으로 시작을 하잖아 -> tmp[0] : 1 tmp[1] :
//    level -> 0 , 1 -> 1, 1,3
//
    static void recursive(int level, int[] tmp){
        if(m == level) {
            StringBuilder sb = new StringBuilder();
            for(int i : tmp){
                sb.append(i);
                sb.append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }
        for(int i =1;i<=n;i++){
            if(flag[i])
                continue;

            tmp[level] = i;
            flag[i] = true;
            recursive(level+1,tmp);
            flag[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        n = Integer.parseInt(num[0]);
        m = Integer.parseInt(num[1]);
        flag = new boolean[n+1];

        recursive(0,new int[m]);

    }

}
