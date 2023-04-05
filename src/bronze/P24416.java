package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P24416 {
    static int[] dp;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[1] = dp[2] = 1;
        fib1(N);
        System.out.print(count);
        count = 0;
        fib2(N);
        System.out.print(" " + count);
    }

    private static int fib1(int n){
        if(n ==1  || n == 2) {
            count++;
            return 1;
        }
        return (fib1(n-1) + fib1(n-2));
    }

    private static int fib2(int n){
        if(n == 1 || n == 2) return 1;
        for(int i=3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            count++;
        }

        return dp[n];
    }
}
