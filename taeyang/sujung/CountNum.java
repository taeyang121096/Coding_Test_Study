package Sujong;
import java.util.*;
import java.io.*;

/*
  A * B * C = multiple
  0 ~ 9 cnt
  A,B,C : 100<=  <1000
  1000 000 000 -> 10억 int -> +-21억이 넘어가면 -> long

  1. int[] arr 랑 변수 -> 0 = a, 1 = b, 2 = c
  2. for(0<= <3) -> 입력 -> buffer(String) -> int 형 변환 -> arr[i] = 변환값 -> multiple *= arr[i]
  3. int multiple => for(0<= <3)

  4. 0 ~ 9 까지 몇번 cnt  -> return
  5. int[] ans = new int[10]

  6. multiple -> 10005 % 10 -> 1의자리 -> 5 -> 10005/10 -> 1000
                 1000 % 10 -> 2의자리 -> 0 -> 1000 / 10 -> 100
                 1000 /10 -> 100 -> 10 -> 1 -> 0
  7. while(multiple != 0){
        arr[multiple % 10]++
        multiple /= 10
  }

  8. for(i 0 ~ <10)
        print(ans[i])

  sum(int sum = 0+ multiple int multiple = 1*

 */
public class CountNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        int multiple = 1;
        int[] ans = new int[10];

        for(int i = 0;i<3;i++){
            arr[i] = Integer.parseInt(br.readLine());
            multiple *= arr[i];
        }

        while(multiple != 0){
            ans[multiple % 10]++;
            multiple /=10;
        }

        for(int i = 0;i<10;i++){
            System.out.println(ans[i]);
        }


    }


}
