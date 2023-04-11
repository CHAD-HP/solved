package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class P11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N * N + 1];
        int[] sum = new int[N * N + 1];
        for(int i=1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j <= N; j++){
                var a = Integer.parseInt(st.nextToken());
                arr[(i - 1) * N + j] = a;
                sum[(i * N) + j] = i == 0 && j == 0 ? a :
                        sum[i * N + j - 1] + a;
            }
        }

        StringJoiner sj = new StringJoiner("\n");
        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()),
                    y1 = Integer.parseInt(st.nextToken()),
                    x2 = Integer.parseInt(st.nextToken()),
                    y2 = Integer.parseInt(st.nextToken());
            if(x1 == 1 && x1 == x2 && y1 == 1 && y1 == y2) sj.add(arr[0] + "");
            else if(x1 == x2 && y1 == y2) sj.add(arr[(x2-1) * N + y2 - 1]+"");
            else if(x1 == 1 && y1 == 1) sj.add(sum[(x2-1) * N + y2 - 1] + "");
            else sj.add((sum[(x2-1) * N + y2 - 1] - sum[(x1-1) * N + y1 - 1]) + "");
        }
        System.out.println(sj);
    }
}
