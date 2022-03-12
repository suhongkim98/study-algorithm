import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        for(int i = 0 ; i < N ; i++) {
            String row = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        Queue<Node> q = new LinkedList<>();
        visit[0][0] = true;
        q.add(new Node(0,0,1));
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.a == map.length - 1 && node.b == map[0].length - 1) {
                // 도착
                bw.write(node.count + "");
            }

            int[] dirA = {1,-1,0,0};
            int[] dirB = {0,0,1,-1};
            for(int i = 0 ; i < 4 ; i++) {
                int newA = node.a + dirA[i];
                int newB = node.b + dirB[i];

                if(newA < 0 || newA > map.length - 1) continue;
                if(newB < 0 || newB > map[0].length - 1) continue;
                if(map[newA][newB] == 1 && !visit[newA][newB]) {
                    visit[newA][newB] = true;
                    q.add(new Node(newA,newB,node.count + 1));
                }
            }
        }
        bw.close();
        br.close();
    }

}
class Node {
    int a;
    int b;
    int count;
    public Node(int a,int b,int count) {
        this.a = a;
        this.b = b;
        this.count = count;
    }
}

