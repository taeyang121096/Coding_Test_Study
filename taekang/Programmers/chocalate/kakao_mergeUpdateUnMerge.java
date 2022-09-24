package Programmers.chocalate;

public class kakao_mergeUpdateUnMerge {
    public static String[][] map = new String[50][50];
    public static int dx,dy;
    public static String tmp = "";
    public static void main(String[] args) {
        String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4",
                "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        String[] answer = {};

        for(int i = 0; i < commands.length; i++){
            String[] str = commands[i].split(" ");
            String command = str[0];

            if(str.length > 3){ // UPDATE, MERGE,
                if(command.equals("UPDATE")){
                    int r = Integer.parseInt(str[1]) - 1;
                    int c = Integer.parseInt(str[2]) - 1;
                    String tmp = str[3];
                    map[r][c] = tmp;
                } else if(command.equals("MERGE")){
                    int r1 = Integer.parseInt(str[1]) - 1;
                    int c1 = Integer.parseInt(str[2]) - 1;
                    int r2 = Integer.parseInt(str[3]) - 1;
                    int c2 = Integer.parseInt(str[4]) - 1;
                    if(map[r1][c1] != null && map[r2][c2] != null){ //
                        tmp = map[r1][c1];
                    } else if(map[r1][c1] != null || map[r2][c2] != null){ // 둘중 하나가 null
                        if(map[r1][c1] != null){
                            tmp = map[r1][c1];
                        } else {
                            tmp = map[r2][c2];
                        }
                    }

                    for(int x = r1; x <=r2; x++){
                        for(int y = c1; y <= c2; y++){
                            map[x][y] = tmp;
                        }
                    }
                }
            } else {

            }
        }
        for(int i = 0; i < 50; i++){
            for(int j = 0; j < 50; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
