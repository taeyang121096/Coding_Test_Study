import java.util.*;
import java.io.*;

public class MainBoard_Hyun {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        boolean[][] check = new boolean[11][7];
        check[0][3] = true;
        check[1][0] = true;
        check[1][1] = true;
        check[1][3] = true;
        check[1][4] = true;
        check[1][5] = true;
        check[2][0] = true;
        check[2][6] = true;
        check[3][0] = true;
        check[3][4] = true;
        check[4][1] = true;
        check[4][4] = true;
        check[4][5] = true;
        check[5][2] = true;
        check[5][4] = true;
        check[6][2] = true;
        check[7][3] = true;
        check[7][4] = true;
        check[7][5] = true;
        check[9][4] = true;
        check[10][0] = true;
        check[10][1] = true;
        check[10][2] = true;
        check[10][3] = true;
        check[10][4] = true;
        check[10][5] = true;
        check[10][6] = true;

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder s = new StringBuilder(st.nextToken());
            StringBuilder e = new StringBuilder(st.nextToken());
            while (s.length() < 5) {
                s.insert(0, "영");
            }
            while (e.length() < 5) {
                e.insert(0, "영");
            }

            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (s.charAt(j) == e.charAt(j))
                    continue;
                int sta;
                int eta;
                if (s.charAt(j) == '영')
                    sta = 10;
                else
                    sta = Character.getNumericValue(s.charAt(j));
                if (e.charAt(j) == '영')
                    eta = 10;
                else
                    eta = Character.getNumericValue(e.charAt(j));

                for (int k = 0; k < 7; k++) {
                    if (check[sta][k] != check[eta][k]) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }


    }

}
