package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2579 {
    static int[] stair;
    static int[][] mem;
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        stair = new int[N];
        mem = new int[N][3];
        for(int i=0; i < N; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        ch4d(0, 0, 1);
        if(N != 1)
            ch4d(0, 1, 1);

        System.out.println(MAX);
    }

    private static void ch4d(int score, int pos, int stepCount){
        if(mem[pos][stepCount] > stair[pos] + score) return;
        if(pos == stair.length - 1){
            MAX = Math.max(score + stair[pos], MAX);
            return;
        }

        mem[pos][stepCount] = score + stair[pos];

        if(stepCount < 2)
            ch4d(score + stair[pos], pos + 1, stepCount + 1);
        if(pos + 2 < stair.length)
            ch4d(score + stair[pos], pos + 2, 1);
    }
}
