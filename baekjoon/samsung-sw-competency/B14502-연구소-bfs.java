import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

/*

3개의 벽을 세워야한다.
3차원 반복문 사용하여 조합으로 벽을 세우고
bfs를 돌려 안전영역의 크기를 구한다
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N][M]; // 지도
        List<Point> zeroPoint = new ArrayList<>();

        for(int i = 0 ; i < N ; i++) {
            input = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                // map[i][j]가 0인 경우 해당 지점을 벽 세우기 위해 지점 저장
                if(map[i][j] == 0) zeroPoint.add(new Point(i,j));
            }
        }

        // 3차원 반복문으로 조합으로 3개 뽑아 벽 세우고 dfs 돌리기
        for(int i = 0 ; i < zeroPoint.size() ; i++) {
            for(int j = i + 1 ; j < zeroPoint.size() ; j++) {
                for(int k = j + 1 ; k < zeroPoint.size() ; k++) {
                    // 벽 세우기
                    Point wall1 = zeroPoint.get(i); Point wall2 = zeroPoint.get(j); Point wall3 = zeroPoint.get(k);
                    map[wall1.x][wall1.y] = 1; map[wall2.x][wall2.y] = 1; map[wall3.x][wall3.y] = 1;
                    // dfs 돌리기
                    challenge(map);
                    // 벽 치우기
                    map[wall1.x][wall1.y] = 0; map[wall2.x][wall2.y] = 0; map[wall3.x][wall3.y] = 0;
                }
            }
        }

        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }
    static void printMap(int[][] map) {
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[0].length ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static int result = 0;
    static void challenge(int[][] map) {
        int safeZone = 0; // 안전영역 크기
        boolean[][] visit = new boolean[map.length][map[0].length];
        Queue<Point> q = new ArrayDeque<>();
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        // 바이러스 퍼트리기
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[0].length ; j++) {
                // 바이러스 진원지라면 진원지 주변 0인 곳을 bfs
                if(!visit[i][j] && map[i][j] == 2) {
                    for(int a = 0 ; a < 4 ; a++) {
                        int newX = dx[a] + i;
                        int newY = dy[a] + j;
                        if(newX < 0 || newX >= map.length) continue;
                        if(newY < 0 || newY >= map[0].length) continue;

                        if(!visit[newX][newY] && map[newX][newY] == 0) {
                            visit[newX][newY] = true;
                            q.add(new Point(newX, newY));
                        }
                    }

                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        map[p.x][p.y] = 3; // 퍼진 곳은 되돌리기위해 3으로 설정

                        // 4방면 탐색
                        for(int a = 0 ; a < 4 ; a++) {
                            int newX = dx[a] + p.x;
                            int newY = dy[a] + p.y;
                            if(newX < 0 || newX >= map.length) continue;
                            if(newY < 0 || newY >= map[0].length) continue;

                            if(!visit[newX][newY] && map[newX][newY] == 0) {
                                visit[newX][newY] = true;
                                q.add(new Point(newX, newY));
                            }
                        }
                    }
                }
            }
        }
        // 안전영역 크기 구하기, 비교하기
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[0].length ; j++) {
                if(map[i][j] == 0) safeZone++;
            }
        }
        // 안전 최대값 갱신
        if(result < safeZone) result = safeZone;

        // 다시 map 되돌리기
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[0].length ; j++) {
                if(map[i][j] == 3) map[i][j] = 0;
            }
        }
    }

}

