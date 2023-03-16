package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9184 {
    static int[][][] abc = new int[51][51][51];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();;
        while(!"-1 -1 -1".equals(s)){
            String[] lines = s.split(" ");
            int a = Integer.parseInt(lines[0]), b = Integer.parseInt(lines[1]),
                    c = Integer.parseInt(lines[2]);
            int sum = ch4d(a, b, c);
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, sum);
            s = br.readLine();
        };
    }

    private static int ch4d(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0){
            return abc[0][0][0] = 1;
        }
        if(abc[a][b][c] != 0){
            return abc[a][b][c];
        }
        if(a > 20 || b > 20 || c > 20) {
            return abc[a][b][c] = ch4d(20, 20, 20);
        }
        if(a < b && b < c){
            return abc[a][b][c] = ch4d(a, b, c-1) + ch4d(a, b-1, c-1)
                    - ch4d(a, b-1, c);
        }
        return abc[a][b][c] = ch4d(a-1, b, c) + ch4d(a-1, b-1, c) +
                ch4d(a-1, b, c-1) - ch4d(a-1, b-1, c-1);
    }
}
