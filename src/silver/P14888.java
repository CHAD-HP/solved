package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14888 {
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] items = new int[N];

        String[] line = br.readLine().split(" ");

        for (int i = 0, n = line.length; i < n; i++) {
            items[i] = Integer.parseInt(line[i]);
        }

        String[] cmdLine = br.readLine().split(" ");

        int[] cmds = new int[4];

        for (int i = 0; i < 4; i++) {
            cmds[i] = Integer.parseInt(cmdLine[i]);
        }

        backTrack(items, cmds, items[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void backTrack(int[] items, int[] cmds, int num, int pos){
        if(pos == items.length){
            MIN = Math.min(num, MIN);
            MAX = Math.max(num, MAX);
            return;
        }

        for(int i=0; i < 4; i++){
            if(cmds[i] > 0){
                cmds[i]--;
                backTrack(items, cmds, calc(num, items[pos], i), pos + 1);
                cmds[i]++;
            }
        }
    }

    private static int calc(int x, int y, int cmd){
        if(cmd == 0){
            return x + y;
        }else if(cmd == 1) {
            return x - y;
        }else if(cmd == 2){
            return x * y;
        }else {
            return x / y;
        }
    }

}
