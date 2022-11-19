package SWEA;

import java.io.*;
import java.util.*;

public class SW_7675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(sc.nextLine());
//            String str = br.readLine();
            int[] answer = new int[N];
            String sentences[] = sc.nextLine().split("\\.|\\?|\\!");
            for (int i = 0; i < sentences.length; i++) {
                int cnt = 0;
                String[] word = sentences[i].trim().split(" ");
                for (int j = 0; j < word.length; j++) {
                    boolean flag = false;
                    if (word[j].charAt(0) >= 'A' && word[j].charAt(0) <= 'Z') {
                        for (int k = 1; k < word[j].length(); k++) {
                            if (!(word[j].charAt(k) >= 'a' && word[j].charAt(k) <= 'z')) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag)
                            cnt++;
                    }
                }
                answer[i] = cnt;
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < N; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        }
    }
}
