package School;

import java.util.Scanner;

public class Pita {

// 아니 입력도 안되..
    static int count = 0;
    static int n;
    static boolean check(int[] tmp){
        int a = tmp[0];
        int b = tmp[1];
        int c = (a*a) + (b*b);
        double val = Math.sqrt(c);
//        여기서 판단 못함?? 같은지 다른지? >?
//        이렇게??
        if(val == (int)val && (int)val<=n)
            return true;
        return false;
    }


    static void make(int[] tmp, int level, int start) {
        if (level == 2) {
            if(check(tmp)) {

                count++;
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            tmp[level] = i;
            make(tmp, level + 1, i+1);
//            방법이 아예 없나
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        make(new int[2], 0, 1);

        System.out.print(count);
    }
}
