package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2839 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int fiveCount = N / 5;
        int threeCount = (N - fiveCount * 5) / 3;
        while(fiveCount > 0){
            if(fiveCount * 5 + threeCount * 3 == N) break;
            threeCount = (N - --fiveCount * 5) / 3;
        }


        if(fiveCount != 0)
            System.out.println(fiveCount + threeCount);
        else if(N % 3 == 0)
            System.out.println(N / 3);
        else
            System.out.println(-1);
    }
}
