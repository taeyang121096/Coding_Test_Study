package Programmers;

import java.util.*;

public class plus_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Character> list = new ArrayList<>();

        String input = scan.next();
        char[] arr = input.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        Integer number = scan.nextInt();
        scan.nextLine();

        int cursor = input.length();

        for (int i = 0; i < number; i++) {
            String str = scan.next();

            if (str.contains("P")) {
                char c = scan.next().charAt(0);
                list.add(cursor, c);
                cursor = cursor + 1;
            } else if (str.equals("L")) {
                cursor = cursor - 1;
                if (cursor <= 0) {
                    cursor = 0;
                }
            } else if (str.equals("D")) {
                cursor = cursor + 1;
                if (cursor >= list.size()) {
                    cursor = list.size();
                }
            } else if (str.equals("B")) {
                if (cursor == 0)
                    continue;
                else {
                    list.remove(cursor - 1);
                    cursor = cursor - 1;
                    if (cursor <= 0) {
                        cursor = 0;
                    }
                }
            }
        }

        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j));
        }
    }
}

