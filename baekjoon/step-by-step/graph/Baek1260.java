import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//graph
//bfs dfs
public class Main {
    static int size = 0;
    static int[][] map;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);
        map = new int[N][N];
        size = N;
        visit = new boolean[N];

        for(int i = 0 ; i < M ; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]) - 1;
            int des = Integer.parseInt(input[1]) - 1;
            map[start][des] = 1;
            map[des][start] = 1;
        }
        dfs(V - 1);
        System.out.println();

        visit = new boolean[N]; //init
        Queue<Integer> q = new LinkedList<>();
        visit[V - 1] = true;
        q.add(V - 1);

        while (!q.isEmpty()) {
            int index = q.poll();
            System.out.print((index + 1) + " ");
            for(int i = 0 ; i < size ; i++) {
                if(map[index][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }

        bw.close();
        br.close();
    }
    static void dfs(int index) {
        visit[index] = true;
        System.out.print((index + 1) + " ");
        for(int i = 0 ; i < size ; i++) {
            if(map[index][i] == 1 && !visit[i]) dfs(i);
        }
    }
}
