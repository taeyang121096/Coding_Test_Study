package LikeLion;

import java.io.*;

public class Num1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1, num2;

        while (true) {
            try{
                System.out.print("첫번째 숫자를 입력해주세요 : ");
                num1 = Integer.parseInt(br.readLine());
                break;
            } catch(Exception e){
                System.out.println("[입력오류] : 숫자로 입력해주세요.");
            }
        }
        while (true) {
            try {
                System.out.print("두번째 숫자를 입력해주세요 : ");
                num2 = Integer.parseInt(br.readLine());
                break;
            } catch (Exception e) {
                System.out.println("[입력오류] : 숫자로 입력해주세요.");
            }
        }
        int sum = num1 + num2;
        System.out.println("결과 : " + sum);
    }
}
