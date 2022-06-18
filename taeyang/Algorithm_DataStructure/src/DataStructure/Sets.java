package DataStructure;

import java.util.*;

public class Sets {

    public static void main(String[] args) {
        //        구현체
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>(((o1, o2) -> o1-o2));
        Set<Integer> set3 = new LinkedHashSet<>();

//        c
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set3.add(1);
        set3.add(2);
        set3.add(3);
        set2.add(1);
        set2.add(2);
        set2.add(3);

//        r
        for (int val:set1){
            System.out.print(val);
        }
        System.out.println();
        for (int val:set3){
            System.out.print(val);
        }
        for (int val:set2){
            System.out.print(val);
        }
        Iterator<Integer> iterator = set1.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

//        d
        System.out.println(set1.remove(1));
        System.out.println(set1.remove(2));
        set1.clear();

        if(set1.isEmpty()){
            System.out.println("wow empty");
        }


    }
}
