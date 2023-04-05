package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        long[] sum = new long[N+1];
        var a = 1;
        while(st.hasMoreElements()){
            var n = Integer.parseInt(st.nextToken());
            sum[a] = sum[a-1] + n;
            a++;
        }

        for(var i=0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            var start = Integer.parseInt(st.nextToken());
            var end = Integer.parseInt(st.nextToken());

            System.out.println(sum[end] - sum[start - 1]);
        }
    }
}
