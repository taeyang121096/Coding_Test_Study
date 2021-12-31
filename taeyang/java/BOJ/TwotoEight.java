package basic;

import java.io.IOException;
import java.util.*;
import java.io.*;
public class TwotoEight {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String two = br.readLine();
        int n = two.length();

        if (n % 3 == 1) {
            System.out.print(two.charAt(0));
        } else if (n % 3 == 2) {
            System.out.print((two.charAt(0) - '0') * 2 + (two.charAt(1) - '0'));
        }

        for (int i = n % 3; i < n; i += 3) {
            System.out.print((two.charAt(i) - '0') * 4 + (two.charAt(i + 1) - '0') * 2 + (two.charAt(i + 2) - '0'));
        }
    }
}

