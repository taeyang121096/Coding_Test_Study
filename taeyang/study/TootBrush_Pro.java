import java.util.*;

public class TootBrush_Pro {
    //
// 1. 발생하는 이익의 10 퍼센트를 추천인에게 준다 나머지는 자신이 가짐90
// 2. 1원단위로 퍼센트 계산
// 3. 칫솔 한개당 100원
// 4. enroll 1 ~ 10000 -> 사람 이름
// 5. referral -> 추천인    '-' -> 센터가 추천인
// 6. seller -> 1 ~ 100,0000
// 7. amount -> 1 ~ 100
//     1. 이름, 돈, 부모(node)로 갖고
//     2. map 사용 -> 이름 node
//     3. 10퍼센트 90 퍼센트 계산 메서드
//     4. 연결해서 최종 부모까지 가면된다.
    static class Node {
        String name;
        int money;
        String parent;

        public Node(String name, int money, String parent) {
            this.name = name;
            this.money = money;
            this.parent = parent;
        }
    }

    static Map<String, Node> map = new HashMap<>();

    static void calc(Node n, int cost) {
        int fee = (cost * 10) / 100;
        n.money += cost - fee;

        if (fee == 0)
            return;

        if (n.parent.equals("-"))
            return;
        calc(map.get(n.parent), fee);
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++)
            map.put(enroll[i], new Node(enroll[i], 0, referral[i]));

        for (int i = 0; i < seller.length; i++) {
            Node n = map.get(seller[i]);
            calc(n, amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++)
            answer[i] = map.get(enroll[i]).money;


        return answer;
    }
}

