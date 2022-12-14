//package Softeer;
//
//import java.io.*;
//import java.util.*;
//
///**
// * 좌석 N * M
// * 현재 k 개의 좌석이 차있고, 이 중 i 번째 좌석은 (Xi, Yi)
// * 좌석( X, Y ) 의 안전도는 Dx,y , Math.sqrt((xi-X)^2 + (yi-Y)^2) 이다.
// * 즉, 다른 사람까지 거리 중 가장 가까운 거리이다. 상하좌우에 붙어 앉을 수 없다.
// */
//public class SeatManagement {
//    public static int[][] map;
//    public static int N, M, Q;
//    public static boolean[][] isCanSeat;
//    public static HashMap<Integer, int[]> hsm = new HashMap<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//        N = Integer.parseInt(str[0]); // 1
//        M = Integer.parseInt(str[1]); // 3
//        Q = Integer.parseInt(str[2]); // 10
//
//        int cnt = 0; // 비어있는지 비어있지 않은지 확인하기 위한 카운트 변수
//        map = new int[N + 1][M + 1]; // map
//        isCanSeat = new boolean[N + 1][M + 1]; // 방문 가능한지
//
//        for (int i = 0; i < Q; i++) { // 10번 반복
//            str = br.readLine().split(" ");
//            String InOrOut = str[0];
//            int id = Integer.parseInt(str[1]);
//
//            if (InOrOut.equals("Out")) {
//                if (!hsm.containsKey(id)) {
//                    System.out.println(id + " didn't eat lunch.");
//                } else {
//                    int[] ints = hsm.get(id);
//                    if (ints[0] == -1 && ints[1] == -1) {
//                        System.out.println(id + " already left seat.");
//                    } else {
//                        // 떠났다
//                        System.out.println(id + " leaves from the seat ("
//                                + ints[0] + ", " + ints[1] + ")");
//                        isCanSeat[ints[0]][ints[1]] = false;
//                        makeSeatCan(ints[0], ints[1]);
//                        hsm.put(id, new int[]{-1, -1});
//                        cnt--;
//                    }
//                }
//            } else {
//                if (hsm.containsKey(id)) { // 이미 포함할 때,
//                    int[] ints = hsm.get(id);
//                    if (ints[0] == -1 && ints[1] == -1) {
//                        System.out.println(id + " already ate lunch.");
//                    } else
//                        System.out.println(id + " already seated.");
//                } else {
//                    if (cnt == 0) { // 다 비어있을 때,
//                        hsm.put(id, new int[]{1, 1});
//                        isCanSeat[1][1] = true;
//                        makeSeatCannot(1, 1);
//                        System.out.println(id + " gets the seat (" + 1 + ", " + 1 + ")");
//                        cnt++;
//                    } else { // 다 비어있지 않을 때
//                        int[] seatIdx = getSeatIdx();
//                        if (seatIdx[0] == -1 && seatIdx[0] == -1) {
//                            System.out.println("There are no more seats.");
//                        } else {
//                            System.out.println(id + " gets the seat (" + (seatIdx[0]) + ", " + (seatIdx[1]) + ")");
//                            hsm.put(id, new int[]{seatIdx[0], seatIdx[1]});
//                            isCanSeat[seatIdx[0]][seatIdx[1]] = true;
//                            makeSeatCannot(seatIdx[0], seatIdx[1]);
//                            cnt++;
//
////                            for (Integer in : hsm.keySet()) {
////                                int[] ins = hsm.get(in);
////                                System.out.println(ins[0] + " " + ins[1]);
////                            }
////
////                            for (int i2 = 1; i2 < N + 1; i2++) {
////                                for (int j2 = 1; j2 < M + 1; j2++) {
////                                    System.out.print(isCanSeat[i2][j2] + " ");
////                                }
////                                System.out.println();
////                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        for (int i = 1; i < N + 1; i++) {
//            for (int j = 1; j < M + 1; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        for (int i2 = 1; i2 < N + 1; i2++) {
//            for (int j2 = 1; j2 < M + 1; j2++) {
//                System.out.print(isCanSeat[i2][j2] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    private static int getSafety(int i, int j, int[] ints) {
////        return Math.sqrt(((ints[0] - i) * (ints[0] - i)) + ((ints[1] - j) * (ints[1] - j)));
//        int sum = ((ints[0] - i) * (ints[0] - i)) + ((ints[1] - j) * (ints[1] - j));
//        return sum;
//    }
//
//    private static int dist(int i, int j) {
//    }
//
//    public static int[] getSeatIdx() {
//        int max = Integer.MIN_VALUE;
//        int r = -1;
//        int c = -1;
//
//        for (int i = 1; i < N + 1; i++) {
//            for (int j = 1; j < M + 1; j++) {
//                if (!isCanSeat[i][j]) { // 이고, Min 이라면**
//                    int dis = dist(i,j);
//                    if (dis > max) {
//                        max = dis;
//                    }
//                }
//            }
//        }
//        return new int[]{r, c};
//    }
//
////    public static int[] getSeatIdx() {
////        int max = Integer.MIN_VALUE;
////        int r = -1;
////        int c = -1;
////
////        for (Integer in : hsm.keySet()) {
////            int[] ints = hsm.get(in);
////            if (ints[0] != -1 && ints[1] != -1) {
////                for (int i = 1; i < N + 1; i++) {
////                    for (int j = 1; j < M + 1; j++) {
////                        if (!isCanSeat[i][j]) { // 이고, Min 이라면**
////                            if (max < getSafety(i, j, ints)) {
////                                max = getSafety(i, j, ints);
////                                r = i;
////                                c = j;
//////                                System.out.println("(" + r + ", " + c + ", " + String.format("%.2f", max) + ")");
//////                                System.out.println("(" + r + ", " + c + ", " + max + ")");
////                            } else if (max == getSafety(i, j, ints)) {
////                                if (r == i) {
////                                    if (c > j) {
////                                        r = i;
////                                        c = j;
////                                    }
////                                } else {
////                                    if (r > i) {
////                                        r = i;
////                                        c = j;
////                                    }
////                                }
////                            }
////                        }
////                    }
////                }
////            }
////        }
////        return new int[]{r, c};
////    }
//
//
//
//    private static void makeSeatCannot(int row, int col) {
//        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
//        for (int[] d : dir) {
//            int nr = row + d[0];
//            int nc = col + d[1];
//            if (nr >= 1 && nc >= 1 && nr < N + 1 && nc < M + 1 && !isCanSeat[nr][nc]) {
//                isCanSeat[nr][nc] = true;
//            }
//        }
//    }
//
//    private static void makeSeatCan(int row, int col) {
//        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
//        for (int[] d : dir) {
//            int nr = row + d[0];
//            int nc = col + d[1];
//            if (nr >= 1 && nc >= 1 && nr < N + 1 && nc < M + 1 && isCanSeat[nr][nc]) {
//                isCanSeat[nr][nc] = false;
//            }
//        }
//    }
//}
