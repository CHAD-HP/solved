package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P14889 {
    static int N;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i=0; i < N; i++){
            String[] items = br.readLine().split(" ");
            for(int j=0; j < N; j++){
                board[i][j] = Integer.parseInt(items[j]);
            }
        }

        doIt(board, new ArrayList<>(), 0);

        System.out.println(min);
    }

    private static void doIt(int[][] board, List<Integer> item, int bit){
        if(item.size() == N){
            int start = sum(board, item, 0);
            int link = sum(board, item, item.size() / 2);
            min = Math.min(min, Math.abs(start - link));
            return;
        }

        for(int i=0; i < N; i++){
            if((bit & 1 << i) == 1 << i) continue;
            item.add(i);
            doIt(board, item, bit | 1 << i);
            item.remove(item.size() - 1);
        }
    }

    private static int sum(int[][] board, List<Integer> item, int start){
        int sum = 0;
        int end = start + item.size() / 2;
        for(int i=start; i < end - 1; i++){
            for(int j=i + 1; j < end; j++){
                sum += board[item.get(i)][item.get(j)] + board[item.get(j)][item.get(i)];
            }
        }
        return sum;
    }
}
