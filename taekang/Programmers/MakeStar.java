//// import java.util.*;
//// class Solution {
////     public String[] solution(int[][] line) {
////         long max_x = Integer.MIN_VALUE;
////         long max_y = Integer.MIN_VALUE;
////         long min_x = Integer.MAX_VALUE;
////         long min_y = Integer.MAX_VALUE;
////         HashSet<long[]> set= new HashSet<>();
////         // 하나하나 돌아가면서 진행하면 될것같음
////         for(int i = 0; i < line.length; i++){
////             for(int j = i+1; j < line.length; j++){
////                     long a = line[i][0];
////                     long b = line[i][1];
////                     long e = line[i][2];
////                     long c = line[j][0];
////                     long d = line[j][1];
////                     long f = line[j][2];
////                     long adbc = a * d - b * c;
////                     if (adbc == 0) {
////                         continue;
////                     }
////                     long bfed = b * f - e * d;
////                     if (bfed % adbc != 0) {
////                         continue;
////                     }
////                     long ecaf = e * c - a * f;
////                     if (ecaf % adbc != 0) {
////                         continue;
////                     }
////                     long x = bfed / adbc;
////                     long y = ecaf / adbc;
////                     set.add(new long[]{x,y});
////             }
////         }
//
////         for(long[] p : set){
////             max_x = Math.max(max_x, p[0]);
////             max_y = Math.max(max_y, p[1]);
////             min_x = Math.min(min_x, p[0]);
////             min_y = Math.min(min_y, p[1]);
////         }
//
////         long height= max_y-min_y+1;
////         long width= max_x-min_x+1;
//
////         String[] answer = new String[(int)height]; // 9
////         StringBuilder sb = new StringBuilder();
////         for (int i = 0; i < width; i++) {
////             sb.append(".");
////         }
////         for (int i = 0; i < height; i++) {
////             answer[i] = sb.toString();
////         }
////         for (long[] p : set) {
////             long j = p[0] - min_x;
////             long i = max_y - p[1];
////             answer[(int) i] = answer[(int) i].substring(0, (int) j) + "*" + answer[(int) i].substring((int) (j + 1));
////         }
//
////         return answer;
////     }
//// }
//import java.util.ArrayList;
//import java.util.List;
//
//class Point {
//    long x;
//    long y;
//
//    public Point(long x, long y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//class Solution {
//    public String[] solution(int[][] line) {
//        String[] answer = {};
//        int n = line.length;
//        List<Point> points = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                long a = line[i][0];
//                long b = line[i][1];
//                long e = line[i][2];
//                long c = line[j][0];
//                long d = line[j][1];
//                long f = line[j][2];
//                long adbc = a * d - b * c;
//                if (adbc == 0) {
//                    continue;
//                }
//                long bfed = b * f - e * d;
//                if (bfed % adbc != 0) {
//                    continue;
//                }
//                long ecaf = e * c - a * f;
//                if (ecaf % adbc != 0) {
//                    continue;
//                }
//                long x = bfed / adbc;
//                long y = ecaf / adbc;
//                points.add(new Point(x, y));
//            }
//        }
//        long minX = points.get(0).x;
//        long minY = points.get(0).y;
//        long maxX = points.get(0).x;
//        long maxY = points.get(0).y;
//
//        points.stream().forEach(a -> {
//            System.out.println(a.x + " " + a.y);
//
//        });
//        for (int i = 0; i < points.size(); i++) {
//            Point p = points.get(i);
//            minX = Math.min(minX, p.x);
//            minY = Math.min(minY, p.y);
//            maxX = Math.max(maxX, p.x);
//            maxY = Math.max(maxY, p.y);
//        }
//        long width = maxX - minX + 1;
//        long height = maxY - minY + 1;
//        StringBuilder sb = new StringBuilder();
//        answer = new String[(int) height];
//        for (int i = 0; i < width; i++) {
//            sb.append(".");
//        }
//        for (int i = 0; i < height; i++) {
//            answer[i] = sb.toString();
//        }
//        for (int k = 0; k < points.size(); k++) {
//            Point p = points.get(k);
//            long j = p.x - minX;
//            long i = maxY - p.y;
//            answer[(int) i] = answer[(int) i].substring(0, (int) j) + "*" + answer[(int) i].substring((int) (j + 1));
//        }
//        return answer;
//    }
//}