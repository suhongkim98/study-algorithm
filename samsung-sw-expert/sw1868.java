import java.util.Scanner;
import java.io.FileInputStream;

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
		    int[][] map = new int[size][size]; //폭탄: -1
		    boolean[][] visit = new boolean[size][size];
		    for(int i = 0 ; i < size ; i++) {
		        String row = sc.next();
		        for(int j = 0 ; j < size ; j++) {
		            if(row.charAt(j) == '.') {
		                map[i][j] = 0;
		            } else map[i][j] = -1;
		        }
		    }
		    Stack<Point> stack = new Stack<>();
		    for(int i = 0 ; i < size ; i++) {
		        for(int j = 0 ; j < size ; j++) {
		            if(map[i][j] == 0) {
		                stack.pushStack(new Point(i, j));
		            }
		        }
		    }
		    //맵그리기
		    while(!stack.isEmptyStack()) {
		        Point point = stack.popStack();
		        if(visit[point.x][point.y]) continue;
		        visit[point.x][point.y] = true;
		        Queue<Point> q = new Queue<>();
		        int[] dirX = {-1,-1,-1,0,0,1,1,1};
		        int[] dirY = {0,1,-1,1,-1,0,1,-1};
		        for(int i = 0 ; i < 8 ; i++) {
		            Point newPoint = new Point(point.x + dirX[i], point.y + dirY[i]);
		            if(newPoint.x < 0 || newPoint.x > size - 1 || newPoint.y < 0 || newPoint.y > size -1) {
		                continue;
		            }
		            q.addQueue(newPoint);
		        }
		        int bombCount = 0;
		        while(!q.isEmptyQueue()) {
		            Point queuePoint = q.removeQueue();
		            if(map[queuePoint.x][queuePoint.y] == -1) {
		                bombCount++;
		            }
		        }
		        if(bombCount != 0) {
		            map[point.x][point.y] = bombCount;
		        } 
		    }
		    visit = new boolean[size][size];
		    int count = 0;
		    //맵은 그려졌으니 이제 카운트하자
		    //값이 0인 곳을 찾아 0끼리 bfs하며 0인접까지 visit true로 바꾸고 count + 1
		    //그다음 visit false인 폭탄 아닌 포인트 갯수만큼 count 업
		    for(int i = 0 ; i < size ; i++) {
		        for(int j = 0 ; j < size ; j++) {
		            if(visit[i][j]) continue;
		            if(map[i][j] == 0) {
		                Point point = new Point(i,j);
		                Queue<Point> q = new Queue<>();
		                visit[i][j] = true;
		                count++;
		                q.addQueue(point);
		                while(!q.isEmptyQueue()){
		                    Point queuePoint = q.removeQueue();
		                    int[] dirX = {-1,-1,-1,0,0,1,1,1};
            		        int[] dirY = {0,1,-1,1,-1,0,1,-1};
            		        for(int k = 0 ; k < 8 ; k++) {
            		            Point newPoint = new Point(queuePoint.x + dirX[k], queuePoint.y + dirY[k]);
            		            if(newPoint.x < 0 || newPoint.x > size - 1 || newPoint.y < 0 || newPoint.y > size -1) {
            		                continue;
            		            }
            		            if(map[newPoint.x][newPoint.y] == 0 && !visit[newPoint.x][newPoint.y]) {
            		                q.addQueue(newPoint);
            		            }
            		            visit[newPoint.x][newPoint.y] = true;
            		        }
		                }
		            }
		        }
		    }
		    
		    for(int i = 0 ; i < size ; i++) {
		        for(int j = 0 ; j < size ; j++) {
		            if(visit[i][j]) continue;
		            if(map[i][j] != -1) count++;
		        }
		    }
		    System.out.println("#" + test_case + " " + count);
		}
	}
}
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Node<T> {
    T value;
    Node<T> next;
    public Node(T value) {
        this.value = value;
    }
}
class Queue<T> {
    Node<T> head;
    Node<T> tail;
    public void addQueue(T value) {
        Node<T> node = new Node(value);
        if(tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
    public T removeQueue() {
        if(head == null) return null;
        Node<T> node = head;
        if(head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return node.value;
    }
    public boolean isEmptyQueue() {
        return head == null;
    }
}
class Stack<T> {
    Node<T> top;
    public boolean isEmptyStack() {
        return top == null;
    }
    public T popStack() {
        if(top == null) return null;
        Node<T> node = top;
        top = top.next;
        return node.value;
    }
    public void pushStack(T value) {
        Node<T> node = new Node(value);
        if(top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }
}
