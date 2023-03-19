package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = dp[0][0];
        int max = dp[0][0];
        int i = 1;
        while(st.hasMoreElements()){
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = dp[i-1][1] + dp[i][0] >= dp[i][0] ? dp[i-1][1] + dp[i][0] : dp[i][0];
            max = Math.max(dp[i][1], max);
            i++;
        }
        System.out.println(max);
    }
}
