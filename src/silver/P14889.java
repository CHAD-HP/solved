package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14889 {
    static int N, board[][], s[], total;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N];
        s = new int[N];
        total = 0;
        for(int i=0; i < N; i++){
            String[] items = br.readLine().split(" ");
            for(int j=0; j < N; j++){
                board[i][j] = Integer.parseInt(items[j]);
                total += board[i][j];
            }
        }

        for(int i=0; i < N; i++){
            for(int j= 0; j < N; j++){
                s[i] += board[i][j] + board[j][i];
            }
        }

        doIt(0, 0,0);
//        doIt( 0,0);

        System.out.println(min);
    }

    private static void doIt(int bit, int count, int pos){
//    private static void doIt(int count, int pos){
        if(count == N / 2){
            getMin(bit);
//            getMin();
            return;
        }

        for(int i=pos; i < N; i++){
//            if(visited[i]) continue;
//            visited[i] = true;
            if(!check(bit, i)) {
                doIt(bit | 1 << i, count + 1, pos + 1);
            }
//            doIt(count + 1, pos + 1);
//            visited[i] = false;
        }
    }

    private static void getMin(int bit){
//    private static void getMin(){
        int link = 0;

        for(int i=0; i < N - 1; i++){
            if(check(bit, i))
//            if(visited[i])
                link += s[i];
        }
        min = Math.min(min, Math.abs(total - link));
        if(min == 0){
            System.out.println(min);
            System.exit(0);
        }
    }

    private static boolean check(int bit, int i){
        return (bit & 1 << i) == 1 << i;
    }
}
