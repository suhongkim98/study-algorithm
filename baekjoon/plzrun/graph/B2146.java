import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

class Main {

    /*
    섬마다 번호를 매긴다.
    각 원점에서 bfs 돌려서 다른 섬에 부딫히면 최소값 갱신
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 섬 번호매기기, 시작은 1
        int labeling = 0;
        boolean[][] visit = new boolean[N][N];
        List<Point> target = new ArrayList<>(); // 나중에 탐색해야하는 섬 점들
        for(int i = 0 ; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    // 방문하지 않은 노드면 bfs 돌려서 섬에 라벨링하기
                    labeling++;


                    Queue<Point> q = new ArrayDeque<>();
                    visit[i][j] = true;
                    q.add(new Point(i,j));


                    while (!q.isEmpty()) {
                        Point point = q.poll();
                        map[point.x][point.y] = labeling; // 라벨링
                        target.add(new Point(point.x, point.y));

                        for(int k = 0 ; k < 4 ; k++) {
                            Point newPoint = new Point(point.x + dx[k], point.y + dy[k]);
                            if(newPoint.x < 0 || newPoint.x >= map.length) continue;
                            if(newPoint.y < 0 || newPoint.y >= map[0].length) continue;
                            if(visit[newPoint.x][newPoint.y]) continue;
                            if(map[newPoint.x][newPoint.y] == 1) {
                                visit[newPoint.x][newPoint.y] = true;
                                q.add(newPoint);
                            }
                        }
                    }
                }
            }
        }

        // 최소값 갱신하기
        int result = Integer.MAX_VALUE;
        for(Point point : target) {
            Queue<Node> q = new ArrayDeque<>();
            int startNumber = map[point.x][point.y];

            visit = new boolean[N][N];
            visit[point.x][point.y] = true;
            q.add(new Node(new Point(point.x,point.y), 0));

            while (!q.isEmpty()) {
                Node node = q.poll();
                if(map[node.point.x][node.point.y] != 0 && map[node.point.x][node.point.y] != startNumber) {
                    if(result > node.count) result = node.count;
                }

                for(int i = 0 ; i < 4 ; i++) {
                    Point newPoint = new Point(node.point.x + dx[i], node.point.y + dy[i]);
                    if(newPoint.x < 0 || newPoint.x >= map.length) continue;
                    if(newPoint.y < 0 || newPoint.y >= map[0].length) continue;
                    if(visit[newPoint.x][newPoint.y]) continue;

                    visit[newPoint.x][newPoint.y] = true;
                    if(map[newPoint.x][newPoint.y] == startNumber) {
                        q.add(new Node(newPoint, node.count));
                    } else {
                        q.add(new Node(newPoint, node.count + 1));
                    }
                }
            }
        }
        bw.write((result - 1) + "");
        br.close();
        bw.close();
    }
}

class Node {
    Point point;
    int count; // 이동한 거리
    public Node(Point point, int count) {
        this.point = point;
        this.count = count;
    }
}
