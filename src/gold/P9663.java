package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9663 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        int possible = isPossible(board, 0);
        System.out.println(possible);
    }

    private static int isPossible(int[][] board, int y){
        int ret = 0;
        for(int x = 0; x < N; x++){
            if(board[x][y] == 0){
                if(y == N-1) {
                    ret +=1;
                    continue;
                }
                paint(board, x, y, 1);
                ret += isPossible(board, y + 1);
                paint(board, x, y, -1);
            }
        }
        return ret;
    }

    private static void paint(int[][] board, int x, int y, int doPaint){
        int x1 = x, y1 = y;
        while (x1 >= 0 && y1 >= 0) {
            board[x1--][y1--] += doPaint;
        }
        x1 = x; y1 = y;
        while(x1 < N && y1 < N){
            board[x1++][y1++]  += doPaint;
        }
        x1 = x; y1 = y;
        while(x1 >= 0 && y1 < N){
            board[x1--][y1++]  += doPaint;
        }
        x1 = x; y1 = y;
        while(x1 < N && y1 >= 0){
            board[x1++][y1--] += doPaint;
        }
        x1 = 0; y1 = y;
        while(x1 < N){
            board[x1++][y1] += doPaint;
        }
        x1 = x; y1 = 0;
        while(y1 < N){
            board[x1][y1++] += doPaint;
        }
    }
}
