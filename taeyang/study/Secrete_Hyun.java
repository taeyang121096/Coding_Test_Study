import java.util.*;
import java.io.*;

public class Secrete_Hyun {


    // 총 k개 버튼 1 ~ k
//  조작 과정 1 ~ k 정수
//  m개의 조작으로 이루어짐 -> 앞뒤로 있어도 상관 x

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String secre = br.readLine().replace(" ", "");
        String user = br.readLine().replace(" ", "");

        if (user.equals(secre)) {
            System.out.print("secret");
            System.exit(0);
        }

        for (int i = 0; i < user.length() - secre.length(); i++) {
            String u = user.substring(i + 1);
            if (u.startsWith(secre)) {
                System.out.print("secret");
                System.exit(0);
            }
        }

        System.out.print("normal");

    }
}
