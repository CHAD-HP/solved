package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][K + 1];

        st = new StringTokenizer(br.readLine(), " ");
        int w1 = Integer.parseInt(st.nextToken());
        int v1 = Integer.parseInt(st.nextToken());
        for(int i=0; i < K+1; i++){
            if(i >= w1) dp[0][i] = v1;
        }

        for(int i=1; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for(int j=0; j < K+1; j++){
                if(j < W) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W] + V);
            }
        }

        System.out.println(dp[N-1][K]);
    }
}
