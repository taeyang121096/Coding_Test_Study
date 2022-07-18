package Programmers;

public class friends4Blocks {
    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        char[][] map = new char[board.length][board[0].length()];
        boolean[][] visited = new boolean[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        boolean flag = false;
        while (!flag) {
            flag = true;
            // 만약 있으면 flag = false;
            for (int i = 0; i < map.length - 1; i++) {
                // map[0][0] ..
                for (int j = 0; j < map[0].length - 1; j++) {
                    if (i < map.length - 2 && j < map[0].length - 2) { // i < 4 j <4
                        if (map[i][j] == map[i + 1][j] && map[i][j] == map[i][j + 1]
                                && map[i][j] == map[i + 1][j + 1] && map[i][j] != 64) {
                            visited[i][j] = true;
                            isTrue(map[i][j], visited, i, j, map);
                            isTrue(map[i][j], visited, i + 1, j, map);
                            isTrue(map[i][j], visited, i, j + 1, map);
                            isTrue(map[i][j], visited, i + 1, j + 1, map);
                            flag = false;
                        }
                    } else {
                        if (map[i][j] == map[i + 1][j] && map[i][j] == map[i][j + 1]
                                && map[i][j] == map[i + 1][j + 1] && map[i][j] != 64) {
                            visited[i][j] = true;
                            isTrue(map[i][j], visited, i, j, map);
                            flag = false;
                        }
                    }
                }
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (visited[i][j]) {
                        map[i][j] = 64;
                    }
                }
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("--------");

            changeMap(map);

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("--------");
        }
//        for(int i = 0; i < map.length; i++){
//            for(int j = 0; j < map[0].length; j++){
//                if(map[i][j] == 64){
//                    answer++;
//                }
//            }
//        }
    }



    static public void changeMap(char[][] map) {
        for (int i = 0; i < map.length - 1; i++) {
            char c = 0;
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 64 && map[i + 1][j] == 64) {
                    c = map[i][j];
                    map[i + 1][j] = c;
                    map[i][j] = 64;
                }
            }
        }
    }

    static public void isTrue(char c, boolean[][] visited, int i, int j, char[][] map) {
        if (map[i + 1][j] == c && map[i][j + 1] == c && map[i + 1][j + 1] == c) {
            visited[i + 1][j] = true;
            visited[i][j + 1] = true;
            visited[i + 1][j + 1] = true;
        }
    }
}
