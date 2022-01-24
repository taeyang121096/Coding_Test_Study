import java.util.*;

public class Menu_Kakao {
    //     최소 2명이상 시킨거 코스요리(최소 2가지)
//
    static String[] Order;
    static Set<Character> set = new LinkedHashSet<>();
    static List<Character> list = new ArrayList<>();
    static List<String> tlist = new ArrayList<>();
    static List<String> ans = new ArrayList<>();

    static void check() {
        List<String> key = new ArrayList<>();
        int max = 0;
        for (String str : tlist) {
            int count = 0;
            for (String o : Order) {
                boolean flag = true;
                for (char c : str.toCharArray()) {
                    if (o.contains(String.valueOf(c)) == false) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    count++;
            }
            if (max < count) {
                key.clear();
                max = count;
                key.add(str);
            } else if (max == count) {
                key.add(str);
            }
        }
        if (max >= 2) {
            for (String s : key) {
                ans.add(s);
            }
        }
    }

    static void make(int c, int start, char[] tmp, int level) {
        if (level == c) {
            tlist.add(String.valueOf(tmp));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            tmp[level] = list.get(i);
            make(c, i + 1, tmp, level + 1);
        }


    }

    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        Order = orders;

        for (String o : orders) {
            for (char c : o.toCharArray()) {
                set.add(c);
            }
        }

        for (Character c : set) {
            list.add(c);
        }
        Collections.sort(list);

        for (int c : course) {
            tlist.clear();
            make(c, 0, new char[c], 0);
            check();
        }

        Collections.sort(ans);
        answer = ans.stream().toArray(String[]::new);

        return answer;
    }
}

