package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9251_fail {
    static int max = Integer.MIN_VALUE;
    static char[] str;
    static char[] comp;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().toCharArray();
        comp = br.readLine().toCharArray();
        dp = new int['Z' + 1][comp.length];
        for(int i=0; i < str.length; i++){
            ch4d("", i, 0);
        }

        System.out.println(max);
    }

    private static int ch4d(String s, int strIdx, int compIdx){
        if(strIdx >= str.length || compIdx >= comp.length){
            max = Math.max(max, s.length());
            return s.length();
        }
        if(s.length() < dp[comp[compIdx]][compIdx] && dp[comp[compIdx]][compIdx] != 0) return dp[comp[compIdx]][compIdx];

        int ret = 0;
        for (int i = compIdx; i < comp.length; i++) {
            if(comp[i] == str[strIdx]){
                ret = Math.max(ret, ch4d(s + str[strIdx], strIdx + 1, i + 1));
            }
        }
        ch4d(s, strIdx + 1, compIdx);
        return dp[comp[compIdx]][compIdx] = ret;
    }
}
