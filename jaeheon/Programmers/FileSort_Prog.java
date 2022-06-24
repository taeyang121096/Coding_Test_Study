package Programmers;

//파일명에 포함된 숫자를 반영한 정렬
//파일명은 영문자로 시작, 숫자를 하나 이상 포함
//파일명은 head number, tail로 구성
//head는 문자로 구성, 한글자 이상
//number는 1 ~ 5글자 사이의 연속된 숫자로 구성
//tail은 나머지(숫자가 포함될 수 있음)
//숫자 앞의 0은 무시 012 = 12
//head와 number의 숫자도 같을 경우에는 입력으로 들어온 순서대로 처리
//대소문자 구분하지 않음

import java.util.*;

class FileSort_Prog {
 
 static String[] divide(String str){
     String head = "";
     String num = "";
     String tail = "";
     int i = 0;
     int j = 0;
     
     // 머리
     for(i = 0; i < str.length(); i++){
         char c = str.charAt(i);
         if(c >= '0' && c <= '9'){
             break;
         }
         head += c;
     }
     
     // 숫자
     for(j = i; j < str.length(); j++){
         char c = str.charAt(j);
         if(!(c >= '0' && c <= '9')){
             break;
         }
         num += c;
     }
     
     // 꼬리
     for(int k = j; k < str.length(); k++){
         char c = str.charAt(k);
         tail+=c;
     }
     
     String[] tmp = {head.toLowerCase(), num, tail};
     // System.out.println(head + " " + num + " " + tail);

     
     return tmp;
 }
 
 public String[] solution(String[] files) {
     
     Arrays.sort(files, new Comparator<String>(){
         @Override
         public int compare(String o1, String o2){
             String[] str1 = divide(o1);
             String[] str2 = divide(o2);
             
             int head = str1[0].compareTo(str2[0]);
             
             if(head == 0){
                 int num1 = Integer.parseInt(str1[1]);
                 int num2 = Integer.parseInt(str2[1]);
                 return Integer.compare(num1, num2);
             } else {
                 return head;
             }
             
         }
     });
     
     return files;
 }
}
