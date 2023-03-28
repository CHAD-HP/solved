package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11054 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[]arr = new int[N];
        int[][] dp = new int[N][2];
        int max = Integer.MIN_VALUE;
        int len = arr.length;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int l = 0;
        while (st.hasMoreElements()) {
            arr[l++] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i < len; i++){
            dp[i][1] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[i][1] < dp[j][1] + 1){
                    dp[i][1] = dp[j][1] + 1;
                }
            }
        }

        for(int i = len - 1; i >= 0; i--){
            dp[i][0] = 1;
            for(int j = len - 1; j > i; j--){
                if(arr[j] < arr[i] && dp[i][0] < dp[j][0] + 1){
                    dp[i][0] = dp[j][0] + 1;
                }
            }
        }

        for(int i=0; i < len; i++){
            max = Math.max(max, dp[i][0] + dp[i][1]);
        }
        System.out.println(max - 1);
    }
}
