package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P15650 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] items = br.readLine().split(" ");
        int N = Integer.parseInt(items[0]), M = Integer.parseInt(items[1]);
        StringBuilder sb = new StringBuilder();
        doIt(sb, N, M, 1, "");
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static void doIt(StringBuilder sb, int N, int M, int pos, String s){
        if(s.replace(" ", "").length() == M){
            sb.append(s.substring(1)).append("\n");
        }

        for(int i=pos; i <= N; i++){
            doIt(sb, N, M, i + 1, s + " " + i);
        }
    }
}
