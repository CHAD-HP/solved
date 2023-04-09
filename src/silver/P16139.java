package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class P16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[26][input.length() + 1];
        for (int i = 0; i < 26; i++) {
            dp[i][0] = 0;
        }
        String tempChar;
        for (int i = 0; i < input.length(); i++) {
            tempChar = input.charAt(i) + "";
            int asc = tempChar.charAt(0)-97;
            dp[asc][i+1]++;
            for (int j = 0; j < 26; j++) {
                dp[j][i+1]+=dp[j][i];
            }
        }
        int[] interval = new int[2];
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            tempChar = st.nextToken();
            int asc = tempChar.charAt(0)-97;
            interval[0] = Integer.parseInt(st.nextToken());
            interval[1] = Integer.parseInt(st.nextToken());
            output.append(dp[asc][interval[1]+1] - dp[asc][interval[0]] + "\n");
        }
        System.out.println(output);
    }
}


//public class P16139 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        char[] arr = br.readLine().toCharArray();
//        int N = Integer.parseInt(br.readLine());
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        char target = st.nextToken().charAt(0);
//
//        int l = Integer.parseInt(st.nextToken());
//        int r = Integer.parseInt(st.nextToken());
//
//        int[][] sum = new int[arr.length][arr.length];
//
//        StringJoiner sj = new StringJoiner("\n");
//        for(int i=0, len = arr.length; i < len; i++){
//            for(int j = i; j < len; j++){
//                if(arr[j] == target)
//                    sum[i][j] = j == 0 ? 1 : sum[i][j-1] + 1;
//                else
//                    sum[i][j] = j == 0 ? 0 : sum[i][j-1];
//            }
//        }
//
//        sj.add(sum[l][r]+"");
//
//        for(int i = 1, len = arr.length; i < N; i++){
//            st = new StringTokenizer(br.readLine());
//            st.nextToken();
//            l = Integer.parseInt(st.nextToken());
//            r = Integer.parseInt(st.nextToken());
//            sj.add(sum[l][r]+"");
//        }
//        System.out.println(sj);
//    }
//}
