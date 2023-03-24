package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10844 {
    static final int DIV = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[10][N];
        for(int i=1; i < 10; i++)
            arr[i][0] = 1;

        for(int i=1; i < N; i++){
            arr[0][i] = arr[1][i-1];
            arr[9][i] = arr[8][i-1];
            for(int j=1; j <= 8; j++){
                arr[j][i] = (arr[j-1][i-1] + arr[j+1][i-1]) % DIV;
            }
        }

        int total = 0;
        for(int i=0; i <= 9; i++){
            total = (total + arr[i][N-1]) % DIV;
        }

        System.out.println(total);
    }
}
