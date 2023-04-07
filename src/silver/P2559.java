package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2559 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        max = Math.max(max, sum);

        for(int i = K; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i] - arr[i - K];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
