import java.util.*;
import java.io.*;

public class Change_softeer {


    // 1 ~ 8 ascending
    // 8 ~ 1 descending
    //  mixed
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        boolean a = true;
        boolean d = true;

        int[] tmp = new int[8];
        int idx = 0;

        while (st.hasMoreTokens()) {
            tmp[idx++] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 8; i++) {
            if (i + 1 != tmp[i])
                a = false;
        }
        for (int i = 0; i < 8; i++) {
            if (8 - i != tmp[i])
                d = false;
        }
        if (a) {
            System.out.print("ascending");
        } else if (d) {
            System.out.print("descending");
        } else {
            System.out.print("mixed");
        }

    }
}



