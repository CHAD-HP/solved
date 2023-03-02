package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1018 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        char[][] board = new char[N][M];
        String[] BW = {"BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB"};
        String[] WB = {"WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW"};
        for(int i=0; i < N; i++){
            board[i] = br.readLine().toCharArray();
        }
        int minCount = Integer.MAX_VALUE;
        for(int i=0; i <= N - 8; i++){
            for(int j=0; j <= M - 8; j++){
                for(int x = 0; x < 2; x++) {
                    int count = 0;
                    String[] compare = x == 0 ? BW : WB;
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            if (board[i + k][j + l] != compare[k].charAt(l)) count++;
                        }
                    }
                    minCount = Math.min(count, minCount);
                }
            }
        }
        System.out.println(minCount);
    }
}
