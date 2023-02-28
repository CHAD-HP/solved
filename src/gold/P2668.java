package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2668 {

    static int[] arr = new int[101];
    static boolean[] visited = new boolean[101];
    static List<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        for(int i=1; i <= n; i++){
            visited[i] = true;
            makeList(i, i);
            visited[i] = false;
        }
        list.sort(Integer::compareTo);
        System.out.println(list.size());
        list.stream().forEach(System.out::println);
    }

    private static void makeList(int start, int end){
        if(!visited[arr[start]]){
            visited[arr[start]] = true;
            makeList(arr[start], end);
            visited[arr[start]] = false;
        }
        if(arr[start] == end) list.add(end);
    }
}
