package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P15649 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] items = br.readLine().split(" ");
        int N = Integer.parseInt(items[0]), M = Integer.parseInt(items[1]);
        Set<Integer> set = new HashSet<>();
        for(int i=1; i <= N; i++){
            set.add(i);
        }

        StringBuilder sb = new StringBuilder();
        backTrack(sb, set, N, M, "");
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static void backTrack(StringBuilder sb, Set<Integer> set, int N, int M, String s){
        if(s.replace(" ", "").length() == M){
            sb.append(s.substring(1)).append("\n");
            return;
        }

        for(int i=1; i <= N; i++){
            if(set.contains(i)){
                set.remove(i);
                backTrack(sb, set, N, M, s + " " + i);
                set.add(i);
            }
        }
    }
}
