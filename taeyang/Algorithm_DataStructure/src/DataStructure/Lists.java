package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Lists {
    public static void main(String[] args) {

//        리스트 종류 -> 인터페이스에 의존하고 구현체를 끼워 넣는 방식으로 개발 해야 해!
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new LinkedList<>();

//        컬렉션을 쓰는 이유는 -> crud -> 삽입 검색 수정 삭제
//        삽입
        list.add(1);
        list.add(0, 2);

        list1.addAll(list);

        System.out.println(list);
        System.out.println(list1);
//        검색
        System.out.println(list.get(0));

//        수정
        list.set(0,3);
        System.out.println(list.get(0));

//        삭제
        list.remove(new Integer(3));

        System.out.println(list);
        list.add(1);
        list.add(1);
        list.add(1);
//         비었는지 안비었는지
        if(list.isEmpty()){
            System.out.println("wow empty");
        }

        list.stream().forEach(System.out::print);


    }
}
