package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2477 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        int[] dirCount = new int[5];
        Melon[] melons = new Melon[6];

        for(int i=0; i < 6; i++){
            String[] items = br.readLine().split(" ");
            int dir = Integer.parseInt(items[0]);
            int length = Integer.parseInt(items[1]);

            dirCount[dir]++;
            melons[i] = new Melon(dir, length);

            if(dir <= 2){
                maxWidth = Math.max(maxWidth, length);
            }else {
                maxHeight = Math.max(maxHeight, length);
            }
        }

        for(int i=0; i < 6; i++){
            if(dirCount[melons[(i+1) % 6].dir] == 1 ||
                    (i == 0 ? dirCount[melons[5].dir] == 1 :
            dirCount[melons[i-1].dir] == 1)){
                melons[i].length = 0;
            }
        }

        int minusArea = 0;

        for (Melon melon : melons) {
            if(melon.length == 0 || dirCount[melon.dir] == 1) continue;
            minusArea = minusArea == 0 ? minusArea = melon.length : minusArea * melon.length;
        }

        System.out.println(N * (maxHeight * maxWidth - minusArea));
    }

    static class Melon {
        int dir;
        int length;

        public Melon(int dir, int length) {
            this.dir = dir;
            this.length = length;
        }
    }
}
