package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] tri = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        tri[0][0] = Integer.parseInt(st.nextToken());

        for(int i=1; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");

            tri[i][0] = tri[i-1][0] + Integer.parseInt(st.nextToken());
            for(int j=1; j <= i; j++){
                int n = Integer.parseInt(st.nextToken());
                tri[i][j] = Math.max(tri[i-1][j-1] + n, tri[i-1][j] + n);
            }
        }

        int max = 0;
        for(int i=0; i <= N; i++){
            max = Math.max(tri[N-1][i], max);
        }
        System.out.println(max);
    }
}
