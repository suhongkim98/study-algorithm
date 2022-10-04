import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

/*
초기 아기상어 크기: 2, 자신 크기와 같은 수의 물고기 먹을 때마다 크기 +1

1초마다 상하좌우로 이동

bfs로 먹을 수 있는 가장 가까운 물고기거리를 구해 이동
- 가까운 거리란 해당 물고기까지 이동하는데 걸린 거리이다.
- 자신과 크기가 작거나 같은 길만 이동 가능
- 작은 것은 먹기
- 먹은 곳은 값이 0이 된다
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        Shark shark = null;
        int totalCount = 0; // 먹어야하는 상어의 수
        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 9) shark = new Shark(new Point(i, j));
                if(map[i][j] != 0 && map[i][j] != 9) totalCount++;
            }
        }

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int time = 0; // 경과시간
        int curCount = 0; // 현재 먹은 물고기 수
        map[shark.point.x][shark.point.y] = 0;
        while (curCount != totalCount) {
            // 못먹는다면 엄마에게 도움이 필요
            Queue<Node> q = new ArrayDeque<>();
            q.add(new Node(shark.point, 0)); // 시작점 넣기
            boolean[][] visit = new boolean[N][N];
            visit[shark.point.x][shark.point.y] = true;

            // 다음 먹어야하는 물고기 위치 찾기
            PriorityQueue<Node> canEatQueue = new PriorityQueue<>((e1, e2) -> {
                // 가까운 것 우선으로 하게끔
                if(e1.moveCount < e2.moveCount) return -1;
                else if(e1.moveCount > e2.moveCount) return 1;
                // 거리가 가까운 것이 같다면
                if(e1.point.x < e2.point.x) return -1; // 가장 위에 있는 것
                else if(e1.point.x > e2.point.x) return 1;

                // 가장 위에 있는 물고기가 여러마리라면
                if(e1.point.y < e2.point.y) return -1;
                else if(e1.point.y == e2.point.y) return 0;
                return 1;
            });
            while (!q.isEmpty()) {
                Node node = q.poll();
                if(map[node.point.x][node.point.y] != 0) {
                    if(shark.size > map[node.point.x][node.point.y]) {
                        // 먹을 수 있다면 후보군으로 삽입
                        canEatQueue.add(node);
                    }
                }

                for(int i = 0 ; i < 4 ; i++) {
                    Point newPoint = new Point(node.point.x + dx[i], node.point.y + dy[i]);
                    if(newPoint.x < 0 || newPoint.x >= map.length) continue;
                    if(newPoint.y < 0 || newPoint.y >= map[0].length) continue;
                    if(visit[newPoint.x][newPoint.y]) continue;

                    // 갈수 있다면 삽입
                    if(shark.size >= map[newPoint.x][newPoint.y]) {
                        visit[newPoint.x][newPoint.y] = true;
                        q.add(new Node(newPoint, node.moveCount + 1));
                    }
                }
            }
            if(canEatQueue.size() == 0) {
                // 엄마 도움~
                break;
            } else {
                // 후보군 중에서 가장 가까운 것 먹기
                Node node = canEatQueue.poll();
                // 시간 반영
                time += node.moveCount;

                map[node.point.x][node.point.y] = 0;
                shark.eat();
                shark.point = node.point;
                curCount++; // 먹은 카운트 반영
            }
        }
        bw.write(time + "");
        br.close();
        bw.close();
    }
}
class Node {
    Point point;
    int moveCount;
    public Node(Point point, int moveCount) {
        this.point = point;
        this.moveCount = moveCount;
    }
}

class Shark {
    Point point;
    int size;
    int eat; // 현재 사이즈에서 먹은 수
    public Shark(Point point) {
        this.point = point;
        size = 2;
        eat = 0;
    }
    public void eat() {
        eat++;
        if(eat == size) {
            size++;
            eat = 0;
        }
    }
}
