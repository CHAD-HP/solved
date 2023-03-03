package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class P10815 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<String> set = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toSet());
        br.readLine();
        StringJoiner sj = new StringJoiner(" ");
        Arrays.stream(br.readLine().split(" "))
                .forEach(item -> {
                        if(set.contains(item)) {
                            sj.add("1");
                        }else {
                            sj.add("0");
                        }
                    }
                );
        System.out.println(sj);
    }
}
