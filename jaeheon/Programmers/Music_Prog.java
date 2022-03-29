package Programmers;

//네오가 기억하고 있는 멜로디
//끝부분 + 처음부분 일 수도 있음
//음악은 반드시 처음부터 재생
//음악 길이보다 재생된 시간이 길때는 끊김없이 처음부터 다시 반복
//음악 길이보다 재생된 시간이 짧을때는 처음부터 재생 시간만큼 재생
//음악은 00:00을 넘겨서까지 재생되지 않음
//조건이 일치하는 음악이 여러개 -> 재생시간 긴거
//재생시간도 같으면 먼저 입력된 음악

class Music {
 public String solution(String m, String[] musicinfos) {
     String answer = "(None)";
     
     m = m.replaceAll("A#", "a");
     m = m.replaceAll("C#", "c");
     m = m.replaceAll("D#", "d");
     m = m.replaceAll("F#", "f");
     m = m.replaceAll("G#", "g");
     
     // System.out.println(m);
     
     int longest = 0;
     
     for(int i = 0; i < musicinfos.length; i++){
         String[] str = musicinfos[i].split(",");
         
         String[] start = str[0].split(":");
         String[] end = str[1].split(":");
         String title = str[2];
         String sheet = str[3];
         
         sheet = sheet.replaceAll("A#", "a");
         sheet = sheet.replaceAll("C#", "c");
         sheet = sheet.replaceAll("D#", "d");
         sheet = sheet.replaceAll("F#", "f");
         sheet = sheet.replaceAll("G#", "g");
         
         int hour = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60;
         int min = (Integer.parseInt(end[1]) - Integer.parseInt(start[1]));
         int playTime = hour + min;
         
         // System.out.println(playTime);
         // System.out.println(start[0] + " " + start[1]);
         // System.out.println(end[0] + " " + end[1]);
         
         StringBuilder sb = new StringBuilder();
         
         for(int j = 0; j < playTime; j++){
             sb.append(sheet.charAt(j % sheet.length()));
         }
         
         if(sb.toString().contains(m)){
             if(sb.toString().length() > longest){
                 longest = sb.toString().length();
                 answer = title;
             } 
         }
         System.out.println(sb);
     }
     return answer;
 }
}