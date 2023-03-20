package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {
    static int[][] rgb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        rgb = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        rgb[0][0] = Integer.parseInt(st.nextToken());
        rgb[0][1] = Integer.parseInt(st.nextToken());
        rgb[0][2] = Integer.parseInt(st.nextToken());

        for(int i=1; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j < 3; j++){
                int n = Integer.parseInt(st.nextToken());
                for(int k=0; k < 3; k++){
                    if(j == k) continue;
                    rgb[i][j] = rgb[i][j] == 0 ? rgb[i-1][k] + n :
                            rgb[i-1][k] + n < rgb[i][j] ? rgb[i-1][k] + n : rgb[i][j];
                }
            }
        }

        System.out.println(Math.min(Math.min(rgb[N-1][0], rgb[N-1][1]), rgb[N-1][2]));
    }
}
