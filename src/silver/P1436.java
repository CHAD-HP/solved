package silver;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1436 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 666;
        int count = 1;
        while(count < N){
            start++;
            if(String.valueOf(start).contains("666")) count++;
        }

        System.out.println(start);
    }
}
