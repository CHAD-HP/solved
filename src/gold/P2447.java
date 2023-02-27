package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2447 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];

        makeStar(arr, 0, 0, n);

        print(arr);
    }
    static void makeStar(char[][] arr, int i, int j, int n){
        if(n == 1) {
            arr[i][j] = '*';
            return;
        }

        for(int a=0; a < 3; a++){
            for(int b=0; b < 3; b++){
                if(a == 1 && b == 1) continue;
                makeStar(arr, i + (a * n/3), j + (b * n/3), n/3);
            }
        }
    }

    static void print(char[][] arr){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == '*') sb.append(arr[i][j]);
                else sb.append(' ');
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
