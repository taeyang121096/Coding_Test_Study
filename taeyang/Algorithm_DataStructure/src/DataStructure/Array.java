package DataStructure;


import java.util.Arrays;

public class Array {
    public static void main(String[] args) {

//        primitive -> datatype 전부 가능, Object(reference) datatype -> 전부 가능 합니다.
        int[] intArray = new int[4];
        char[] charArray = new char[4];
        boolean[] bolArray = new boolean[4];

//      String -> Object -> 모든 자바 객체는 Object를 상속 받는다.
        String[] stringArray = new String[4];

//        Wrapper -> primitive type을 객체로 변환 시켜준 타입이다.
//        Wrapper 같은 경우는 auto boxing -> auto unboxing 이 되기 때문이다.
        Integer wrapper = 1;

//        보통 이게 그으으으 -> sdk에 의존적으로 deprecate -> 추천 안한다. 다른거 써라 이건데 -> 쓸 수는 있다. 를 잡아주는데
        Integer wrapper2 = new Integer(2);
        int val1 = wrapper2.intValue();

//        초기화
        int[] tmp = new int[4];
        int[] tmp1 = new int[]{1,2,3,4};
        int[] tmp2 = {1,2,3,4,5};
//        접근 index 로 접근한다.
        System.out.println(tmp[1]);
//        수정
        tmp1[1] =1 ;

        Arrays.stream(tmp2).forEach(System.out::println);




    }
}
