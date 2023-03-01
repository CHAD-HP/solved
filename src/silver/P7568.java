package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class P7568 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Big> brute = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i < N; i++){
            String[] line = br.readLine().split(" ");
            Big big = new Big(line[0], line[1]);
            for (Big b : brute) {
                if(b.height > big.height && b.weight > big.weight){
                    big.rank++;
                }else if(b.height < big.height && b.weight < big.weight){
                    b.rank++;
                }

            }
            brute.add(big);
        }

        StringJoiner sj = new StringJoiner(" ");
        for (Big big : brute) {
            sj.add(big.rank+"");
        }
        System.out.println(sj);
    }

    static class Big {
        int weight;
        int height;
        int rank;

        public Big(String weight, String height) {
            this.weight = Integer.parseInt(weight);
            this.height = Integer.parseInt(height);
            this.rank = 1;
        }
    }
}
