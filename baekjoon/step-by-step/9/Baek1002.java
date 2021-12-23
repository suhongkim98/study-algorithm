import java.util.Scanner;
//https://www.acmicpc.net/problem/1002
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int i = 0 ; i < T ; i++) {
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int r1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			int r2 = scanner.nextInt();
			// 두 점 거리 구하기
			double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

			if(r1 == r2 && Double.compare(distance, 0) == 0) {
				System.out.println(-1);
			} else if(Double.compare(distance,r1) < 0 || Double.compare(distance,r2) < 0) { // 원의 중심이 내에 있을 때
				int big = r1 < r2 ? r2 : r1;
				int small = r1 < r2 ? r1 : r2;
				if(Double.compare(distance + small, big) < 0) {
					System.out.println(0);
				} else if(Double.compare(distance + small, big) == 0) {
					System.out.println(1);
				} else {
				    System.out.println(2);
				}
			} else if(Double.compare(distance, r1 + r2) > 0) {
				System.out.println(0);
			} else if(Double.compare(distance,r1 + r2) == 0) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		}
	}
}
