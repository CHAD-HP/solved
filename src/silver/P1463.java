package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1463 {
    static int[] arr;
    static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        arr[1] = 0;

        for(int i = 2; i < N+1; i++){
            arr[i] = arr[i-1] + 1;
            if(i % 2 == 0) arr[i] = Math.min(arr[i], arr[i/2] + 1);
            if(i % 3 == 0) arr[i] = Math.min(arr[i], arr[i/3]  + 1);
        }

        System.out.println(arr[N]);
    }
}
