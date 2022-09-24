package Programmers.Jule;

import java.util.*;

public class BadWordCatchProg {
    public static char[] choice;
    public static int cnt = 0;
    public static Map<String, Integer> map = new HashMap<>();
    public static List<String> list = new ArrayList<>(); // 모든 알파벳 배열을 저장하는 배열!!

    public static void main(String[] args) {
        String answer = "";
        int l = 2; // t2 : k = 3
        String[] dic = {"slang", "badword"};
        String chat = "badword ab.cd bad.ord .word sl.. bad.word";
        /**
         * t2
         * l = 3
         * String dic = abcde, cdefg, efgij
         * chat = .. ad. cdefgh .gi. .z.
         */
        String[] chat_arr = chat.split(" ");
        boolean[] chat_check = new boolean[chat_arr.length];
        for (int i = 0; i < dic.length; i++) { // 2
            for (int j = 0; j < chat_arr.length; j++) { // 6
                String comp = dic[i]; // badword
                String chat_comp = chat_arr[j]; // bad.ord
                String[] str = chat_comp.split("\\."); // bad, ord

                int cnt = 0;
                for (int k = 0; k < str.length; k++) { // k = 2
                    if (comp.contains(str[k])) { //
                        comp = comp.replace(str[k], "");
                        chat_comp = chat_comp.replace(str[k], ""); // .만 남겠지 ? .만남으면..무조건 성공 아닌가 ? ㅋㅋ .만 남았는데 dic 길이가 k보다 길면 불가능이고
                        cnt++;
                    }
                }

                if (comp.length() == 0 && chat_comp.length() == 0) {
                    chat_check[j] = true;
                }

                // System.out.println(chat_comp + " " + comp + " " + comp.length());
                // 만약 바뀌지 않고 똑같다면 break;
                // 만약 바뀌었다면, .만남아야함.. "." 만 남았는가를 확인하기 위해선 ??
                // 만약 chat_comp length가 이거랑 같으면 .만 남은것
                if (isPoint(chat_comp) == chat_comp.length()) {
                    // 점이 2개야 그러면 dic의 길이가 2*k 보다 작으면 됨
                    if (comp.length() <= isPoint(chat_comp) * l && comp.length() >= 1) {
                        chat_check[j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < chat_check.length; i++) {
            if (chat_check[i]) {
                for (int k = 0; k < chat_arr[i].length(); k++) {
                    answer += "#";
                }
                answer += " ";
            } else {
                answer += chat_arr[i] + " ";
            }
        }
        System.out.println(answer.substring(0, answer.length() - 1));
    }

    public static int isPoint(String chat) {
        int cnt = 0;
        for (int i = 0; i < chat.length(); i++) {
            if (chat.charAt(i) == '.') {
                cnt++;
            }
        }
        return cnt;
    }
}
