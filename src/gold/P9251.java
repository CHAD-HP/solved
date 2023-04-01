package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for(int i=0; i <= arr1.length; i++){
            for(int j = 0; j <= arr2.length; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(arr1[i-1] == arr2[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        System.out.println(dp[arr1.length][arr2.length]);
    }
}

