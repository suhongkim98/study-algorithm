import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		    int size = sc.nextInt();
		    int[][] map = new int[size][size];
		    int min = Integer.MAX_VALUE; // 길 중에서 합이 최소인 값
		    PriorityQueue<Point> path = new PriorityQueue<>();
		    boolean[][] visit = new boolean[size][size];
		    
		    for(int i = 0 ; i < size ; i++) {
		        String row = sc.next();
		        for(int j = 0 ; j < size ; j++) {
		            map[i][j] = Character.getNumericValue(row.charAt(j));
		        }
		    }
		    Point start = new Point(0,0);
		    visit[0][0] = true;
		    path.add(start);
		    //우선순위 큐로 bfs해서 목적지까지 가며 합을 찾는다.
		    //현재 합이 min보다 크면 즉시 종료
		    //목적지에 도달하면 min변수와 해당 목적지까지 가는데 걸린 합과 비교
		    //더 짧은 거리면 min업데이트
		    while(!path.isEmpty()) {
		        Point cur = path.poll();
		        if(cur.x == size - 1 && cur.y == size - 1) {
		            //목적지 도착
		            if(min > cur.sum) min = cur.sum; // 최소합 업데이트
		            continue; // 뻗어나가지 않음
		        }
		        int[] dirX = {1,-1,0,0};
		        int[] dirY = {0,0,1,-1};
		        for(int i = 0 ; i < 4 ; i++) {
		            if(cur.x + dirX[i] < 0 || cur.x + dirX[i] > size - 1 || cur.y + dirY[i] < 0 || cur.y + dirY[i] > size - 1) continue;
		            Point newPoint = new Point(cur.x + dirX[i], cur.y+dirY[i]);
		            if(visit[newPoint.x][newPoint.y]) continue;
		            int sum = cur.sum + map[newPoint.x][newPoint.y];
		            if(min < sum) continue; // 최소를 초과하면 종료
		            // 합 업데이트
		            newPoint.sum = sum; 
		            visit[newPoint.x][newPoint.y] = true;
		            path.add(newPoint); // 우선순위 큐에 삽입
		        }
		    }
		    System.out.println("#" + test_case+ " " + min);
		}
	}
}
class Point implements Comparable<Point>{
    int x;
    int y;
    int sum;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        sum = 0;
    }
    @Override
    public int compareTo(Point p) {
        if(this.sum > p.sum) return 1;
        else if(this.sum == p.sum) return 0;
        else return -1;
    }
}
