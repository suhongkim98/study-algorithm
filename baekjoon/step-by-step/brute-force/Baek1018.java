import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        final byte BLACK = 0;
        final byte WHITE = 1;
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        byte[][] map = new byte[N][M]; // black 0, white 1
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < N ; i++) {
            String row = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = row.charAt(j) == 'B' ? BLACK : WHITE;
            }
        }

        for(int i = 0 ; i + 8 - 1 < N ; i++) {
            for(int j = 0 ; j + 8 - 1 < M ; j++) {
                //시작지점이 블랙일 때
                byte bit = BLACK;
                int count = 0;
                for(int a = 0 ; a < 8 ; a++) {
                    for(int b = 0 ; b < 8 ; b++) {
                       if(map[a + i][b + j] != bit) count++;
                       bit = bit == BLACK ? WHITE : BLACK;
                    }
                    bit = bit == BLACK ? WHITE : BLACK;
                    if(count > min) break;
                }
                if(count < min) min = count;

                //시작지점이 화이트일 때
                bit = WHITE;
                count = 0;
                for(int a = 0 ; a < 8 ; a++) {
                    for(int b = 0 ; b < 8 ; b++) {
                        if(map[a + i][b + j] != bit) count++;
                        bit = bit == BLACK ? WHITE : BLACK;
                    }
                    bit = bit == BLACK ? WHITE : BLACK;
                    if(count > min) break;
                }
                if(count < min) min = count;
            }
        }
        bw.write(String.valueOf(min));

        bw.flush();
        br.close();
        bw.close();
    }
}
