package Softeer;

import java.io.*;
import java.util.*;

/**
 * 알파벳으로 이루어진 어떤 문자열을 암호화하는 방법, key 가 필요하다.
 * 한번에 두글자 단위로 암호화를 진행하며, 5*5 표 사용, I와J를 동일한것으로 생각한다, 편의상 J가 주어지지않는다.
 */
//HELLOWORLD
//PLAYFAIRCIPHERKEY
public class playFairCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine(); // HELLO WORLD
        String key = br.readLine(); // PLAYFAIRCIPHER

        char[][] map = new char[5][5];
        boolean[] visited = new boolean[26]; // 주의! J가 주어지지 않고, I와J는 동일하다 73, 74 I, J

        // 키를 표로 변환
        int row = 0;
        int col = 0;
        for (int i = 0; i < key.length(); i++) { // PLAYFAIRCIPHER
            char c = key.charAt(i); // P
            if (!(visited[(int) c - 65])) { // 만약 이게 false 라면
                // 만약 I 라면,
                if ((c == 'I')) {
                    visited[(int) c - 65] = true; // I 도 true
                    visited[(int) c - 64] = true; // J 도 true
                    map[row][col] = c;
                    col++;
                } else {
                    visited[(int) c - 65] = true;
                    map[row][col] = c;
                    col++;
                }
            }

            if (col == 5) {
                col = 0;
                row++;
            }

            if (row == 5) {
                break;
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (i == 9) continue;

            if (!visited[i]) {
                visited[i] = true;
                map[row][col] = (char) (i + 65);
                col++;
            }

            if (col == 5) {
                col = 0;
                row++;
            }

            if (row == 5) {
                break;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        // 메세지를 두글자씩 나눔
        // XQ XY YX Y
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < message.length(); i++) {
            list.add(message.charAt(i));
        }

        // HE LL OW OR LD
        while (true) {
            int cnt = 0;
            for (int i = 0; i < list.size(); i += 2) {
                char c1 = list.get(i);
                char c2 = ' ';
                if (i != list.size() - 1) {
                    c2 = list.get(i + 1);
                } else {
                    list.add(i + 1, 'X');
                    cnt = 0;
                }

                if (c1 == c2) {
                    if (c1 != 'X') {
                        list.add(i + 1, 'X');
                        cnt++;
                    } else {
                        list.add(i + 1, 'Q');
                        cnt++;
                    }
                }
            }
            if (cnt == 0) break;
        }
        // ABCDEX
        for (char in : list) {
            System.out.print(in + " ");
        }

        StringBuilder sb = new StringBuilder();
        // 1,2,3 방식으로 표를 변환함
        for (int k = 0; k < list.size(); k += 2) {
            char c1 = list.get(k); // H
            int c1_row = 0; // 1
            int c1_col = 0; // 3
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == c1) {
                        c1_row = i;
                        c1_col = j;
                    }
                }
            }

            char c2 = list.get(k + 1); // E
            int c2_row = 0;
            int c2_col = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == c2) {
                        c2_row = i;
                        c2_col = j;
                    }
                }
            }

            // 같은 행에 존재하면
            if (c1_row == c2_row && c1_col != c2_col || c1_col == c2_col && c1_row == c2_row) {
                if (c1_col == 4) {
                    sb.append(map[c1_row][0]);
                } else {
                    sb.append(map[c1_row][c1_col + 1]);
                }

                if (c2_col == 4) {
                    sb.append(map[c2_row][0]);
                } else {
                    sb.append(map[c2_row][c2_col + 1]);
                }
            } else if (c1_col == c2_col && c1_row != c2_row) {
                if (c1_row == 4) {
                    sb.append(map[0][c1_col]);
                } else {
                    sb.append(map[c1_row + 1][c1_col]);
                }

                if (c2_row == 4) {
                    sb.append(map[0][c2_col]);
                } else {
                    sb.append(map[c2_row + 1][c2_col]);
                }
            } else if (c1_col != c2_col && c1_row != c2_row) {
                sb.append(map[c1_row][c2_col]);
                sb.append(map[c2_row][c1_col]);
            }
        }

        if (sb.toString().equals("NALNBQEWTANRTZEZTKKOWQWUGW")) {
            System.out.println(true);
        } else {
            System.out.println(sb.toString());
        }
    }
}
