import java.util.*;
class Solution {
    class Page{
        int idx;
        int link;
        int basic;
        double score;
        public Page(int idx,int link, int basic, double score){
            this.idx = idx;
            this.link = link;
            this.basic = basic;
            this.score = score;
        }
    }
    HashMap<String,Integer>map = new HashMap<>();
    ArrayList<Page>list = new ArrayList<>();
    public int solution(String word, String[] pages) {
        int answer = 0;
        word = word.toLowerCase();
        int wordsize = word.length();
//         page url 찾기
        for(int i = 0;i<pages.length;i++){
            String s = pages[i].toLowerCase();
            int left=0, mid=0, right = 0;
            while(mid<=left){
                left = s.indexOf("<meta",left+1);
                right = s.indexOf(">",left);
                mid = s.lastIndexOf("https://",right);
            }
            right = s.indexOf("\"",mid);
            String url = s.substring(mid,right);
            map.put(url,i);
        }
//         page 기본점수 구하기 & 링크 수
        for(int i = 0;i<pages.length;i++){
            String s = pages[i].toLowerCase();
            int left=0, right = 0;
            int basic =0;
            left = s.indexOf("<body>",left);
            for(int j = left;;){
                j = s.indexOf(word,j+1);
                if(j<0) break;
                if(!Character.isLetter(s.charAt(j-1)) && !Character.isLetter(s.charAt(j+wordsize))){
                    basic++;
                    j += wordsize;
                }

            }
            int link = 0;
            for(int j = left;;){
                j = s.indexOf("<a href",j+1);
                if(j<0)break;
                link++;
            }
            list.add(new Page(i,link,basic,(double)basic));

        }
//         매칭 점수 구하기
        for(int i = 0;i<pages.length;i++){
            String s = pages[i].toLowerCase();
            for(int left = 0,right = 0;;){
                left = s.indexOf("<a href",right);
                if(left<0) break;
                left = s.indexOf("https://",left);
                right = s.indexOf("\"",left);
                String urlLink = s.substring(left,right);
                if(map.containsKey(urlLink)){
                    list.get(map.get(urlLink)).score += (double)list.get(i).basic / list.get(i).link;
                }
            }
        }
        list.sort(new Comparator<Page>(){
            @Override
            public int compare(Page p1, Page p2){
                if(p1.score == p2.score)
                    return p1.idx - p2.idx;
                else if(p1.score < p2.score)
                    return 1;
                else
                    return -1;
            }
        });
        answer = list.get(0).idx;
        return answer;
    }
}