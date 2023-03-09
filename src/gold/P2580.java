package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2580 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[9][9];
        List<int[]> targets = new ArrayList<>();
        for(int i=0; i < 9; i++){
            String[] items = br.readLine().split(" ");
            for(int j=0; j < 9; j++){
                board[i][j] = Integer.parseInt(items[j]);
                if("0".equals(items[j])){
                    targets.add(new int[]{i, j});
                }
            }
        }

        doIt(board, targets, 0);
    }

    private static void doIt(int[][] board, List<int[]> targets, int pos){
        if(pos == targets.size()){
            print(board);
            System.exit(0);
        }

        for(int i=1; i <= 9; i++){
            int[] item = targets.get(pos);
            if(checkCol(board, item[0], i) && checkRow(board, item[1], i)
                && checkSquare(board, item[0], item[1], i)) {
                board[item[0]][item[1]] = i;
                doIt(board, targets, pos + 1);
                board[item[0]][item[1]] = 0;
            }
        }
    }

    private static boolean checkRow(int[][] board, int y, int target){
        for(int i=0; i < 9; i++){
            if(board[i][y] == target){
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(int[][] board, int x, int target){
        for(int i=0; i < 9; i++){
            if(board[x][i] == target){
                return false;
            }
        }
        return true;
    }

    private static boolean checkSquare(int[][] board, int x, int y, int target){
        int x1 = x / 3 * 3;
        int y1 = y / 3 * 3;
        for(int i=0; i < 3; i++){
            for(int j=0; j < 3; j++){
                if(board[i+x1][j+y1] == target){
                    return false;
                }
            }
        }
        return true;
    }

    private static void print(int[][] board){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < 9; i++){
            for(int j=0; j < 9; j++){
                sb.append(board[i][j]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
