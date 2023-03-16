package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1904 {
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        int ret = ch4d(N);
        System.out.println(ret);
    }

    private static int ch4d(int N){
        if(dp[N] != 0) return dp[N];
        return dp[N] = (ch4d(N-1) + ch4d(N-2)) % 15746;
    }
}
