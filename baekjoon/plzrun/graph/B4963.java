import java.awt.*;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            if(x == 0 && y == 0) break;

            int[][] map = new int[x][y];
            boolean[][] visit = new boolean[x][y];
            int result = 0;

            for(int i = 0 ; i < x ; i++) {
                String[] row = br.readLine().split(" ");
                for(int j = 0 ; j < y ; j++) {
                    map[i][j] = Integer.parseInt(row[j]);
                }
            }


            Queue<Point> q = new LinkedList<>();
            for(int i = 0 ; i < x ; i++) {
                for(int j = 0 ; j < y ; j++) {
                    if(!visit[i][j] && map[i][j] == 1) {
                        result++;
                        visit[i][j] = true;
                        q.add(new Point(i, j));

                        while (!q.isEmpty()) {
                            int[] xList = {1,-1,0,0,1,1,-1,-1}; // 8방면 탐색
                            int[] yList = {0,0,1,-1,1,-1,1,-1};
                            Point p = q.poll();
                            for(int k = 0 ; k < 8 ; k++) {
                                Point newPoint = new Point(p.x + xList[k], p.y + yList[k]);
                                if(newPoint.x < 0 || newPoint.x >= map.length) continue;
                                if(newPoint.y < 0 || newPoint.y >= map[0].length) continue;

                                // 조건에 해당할 때만 큐에 삽입
                                if(!visit[newPoint.x][newPoint.y] && map[newPoint.x][newPoint.y] == 1) {
                                    visit[newPoint.x][newPoint.y] = true;
                                    q.add(newPoint);
                                }
                            }
                        }
                    }
                }
            }
            bw.write(result + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}

