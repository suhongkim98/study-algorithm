import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[][] map = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        int finishCount = 0; // 완료되어야하는 토마토 개수
        int currentCount = 0; // 현재 익은 토마토 개수
        int lastDay = 0; // 토마토가 익은 마지막 날
        Queue<Node> q = new ArrayDeque<>();

        for(int i = 0 ; i < N ; i++) {
            input = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 1) {
                    q.add(new Node(new Point(i, j), 0));
                    visit[i][j] = true;
                }
                if(map[i][j] == 1 || map[i][j] == 0) finishCount++;
            }
        }
        // 돌린다.
        while (!q.isEmpty()) {
            Node node = q.poll();
            if(lastDay < node.day) lastDay = node.day; // day 갱신
            currentCount++;


            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};
            for(int i = 0 ; i < 4 ; i++) {
                Point newPoint = new Point(node.point.x + dx[i], node.point.y + dy[i]);
                if(newPoint.x < 0 || newPoint.x >= map.length) continue;
                if(newPoint.y < 0 || newPoint.y >= map[0].length) continue;
                if(visit[newPoint.x][newPoint.y] || map[newPoint.x][newPoint.y] == -1) continue;
                visit[newPoint.x][newPoint.y] = true;
                q.add(new Node(newPoint, node.day + 1));
            }
        }
        if(currentCount == finishCount) bw.write(lastDay + "");
        else bw.write("-1");

        br.close();
        bw.close();
    }
}
class Node {
    Point point;
    int day;
    public Node(Point point, int day) {
        this.point = point;
        this.day = day;
    }
}
