package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9461 {
    static long[] tri = new long[101];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        tri[1] = 1;
        tri[2] = 1;
        tri[3] = 1;
        tri[4] = 2;
        tri[5] = 2;
        for(int i=0; i < tc; i++){
            int N = Integer.parseInt(br.readLine());
            ch4d(N);
            System.out.println(tri[N]);
        }
    }

    private static long ch4d(int N){
        if(tri[N] != 0) return tri[N];

        return tri[N] = ch4d(N - 2) + ch4d(N-3);
    }
}
