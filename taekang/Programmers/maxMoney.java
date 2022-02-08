package Programmers;

import java.util.*;

public class maxMoney {
    static int plus = '+';
    static int minus = '-';
    static int mul = '*';

    static ArrayList<Character> operator = new ArrayList<>(); // expression에 들어있는 연산자의 종류
    static ArrayList<Integer> location = new ArrayList<>(); // 연산자의 위치를 저장, {3, 7, 11, 15}
    static ArrayList<Integer> num = new ArrayList<>(); // {100, 200, 300 ,500, 20}
    static ArrayList<String> priorityList = new ArrayList<>();
    static ArrayList<Long> last = new ArrayList<>();
    static ArrayList<Integer> numCopy = new ArrayList<>();
    static ArrayList<Integer> locationCopy = new ArrayList<>();
    static Character[] priority;
    static boolean[] isUsed;

    public static void CopyNum(ArrayList<Integer> list){
        for(Integer in : list){
            numCopy.add(in);
        }
    }

    public static void CopyLocation(ArrayList<Integer> list){
        for(Integer in : list){
            locationCopy.add(in);
        }
    }
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";

        int index = 0;
        location.add(-1);
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == plus || expression.charAt(i) == minus || expression.charAt(i) == mul){
                index = i;
                location.add(i);
                // 여기서 index 이전의 숫자들을 따로 list에 저장할 수 있을까 ?
                if(!operator.contains(expression.charAt(i)))
                    operator.add(expression.charAt(i));
            }
        }
        location.add(expression.length());

        for(int i = 0; i < location.size() - 1; i++){
            num.add(Integer.parseInt(expression.substring(location.get(i)+1, location.get(i+1))));
        }

        priority = new Character[operator.size()];
        isUsed = new boolean[operator.size()];
        // 조합 : (+-* / +*- / *+- / *-+ / -+* / -*+) 가 priorityList에 저장 됨
        find(operator.size(), operator.size(), 0);

        long answer = 0;

        for(int i = 0; i < priorityList.size(); i++){
            System.out.print(priorityList.get(i)+ " ");
        }
        System.out.println();
        int sum = 0;

        for(int i = 0; i < priorityList.size(); i++){
            for(int j = 0; j < priorityList.get(i).length(); j++){
                CopyNum(num);
                CopyLocation(location);
                for(int k = 1; k < location.size() - 1; k++){
                    if(priorityList.get(i).charAt(j) == expression.charAt(location.get(k))){
                        if(priorityList.get(i).charAt(j) == plus){
                            sum = numCopy.get(k-1) + numCopy.get(k);
                            numCopy.set(k, sum);
                            numCopy.remove(k-1);
                            locationCopy.remove(k);
                            System.out.println(sum);

                        }
                        else if(priorityList.get(i).charAt(j) == minus){
                            sum = numCopy.get(k-1) - numCopy.get(k);
                            numCopy.set(k, sum);
                            numCopy.remove(k-1);
                            locationCopy.remove(k);
                            System.out.println(sum);

                        }
                        else{
                            sum = numCopy.get(k-1) * numCopy.get(k);
                            numCopy.set(k, sum);
                            numCopy.remove(k-1);
                            locationCopy.remove(k);
                            System.out.println(sum);

                        }
                    }
                }
            }
            System.out.println("-----");
        }

        for(int i = 0; i < last.size(); i++){
            System.out.println(last.get(i));
        }

    }

    public static void find(Integer N, Integer M, Integer index){
        String tmp = "";
        // 종료 조건
        if(M == index){
            for(char c : priority){
                tmp += c;
            }
            priorityList.add(tmp);
            tmp = "";
            return;
        }

        if(index > N){
            return;
        }

        for(int i = 0; i < N; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                priority[index] = operator.get(i);
                find(N, M, index + 1);
                isUsed[i] = false;
            }
        }
    }
}
