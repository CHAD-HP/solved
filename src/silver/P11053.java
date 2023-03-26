package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st =  new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        int[] len = new int[N];
        int i = 1, max = 1;
        arr[0] = Integer.parseInt(st.nextToken());
        len[0] = 1;

        while(st.hasMoreElements()){
            arr[i] = Integer.parseInt(st.nextToken());
            len[i] = 1;

            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && len[i] < len[j] + 1){
                    len[i] = len[j] + 1;
                    max = Math.max(max, len[i]);
                }
            }
            i++;
        }
        System.out.println(max);
    }
}
