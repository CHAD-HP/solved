package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P2565 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] pole = new int[N][2];
        int[] dp = new int[N];

        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            pole[i][0] = Integer.parseInt(st.nextToken());
            pole[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pole, Comparator.comparingInt(o -> o[0]));

        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(pole[i][1] > pole[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int sub = 0;
        for (int i = 0; i < N; i++) {
            sub = Math.max(sub, dp[i]);
        }

        System.out.println(N - sub);
    }
}
