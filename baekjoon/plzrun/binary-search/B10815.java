import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++) {
            cards[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for(int i = 0 ; i < M ; i++) {
            if(Arrays.binarySearch(cards, Integer.parseInt(input[i])) >= 0) bw.write("1 ");
            else bw.write("0 ");
        }



        br.close();
        bw.close();
    }
}

