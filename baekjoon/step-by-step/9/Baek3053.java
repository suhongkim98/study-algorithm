import java.util.Scanner;
 //https://www.acmicpc.net/problem/3053
public class Main {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		double R = sc.nextDouble();	// 반지름 R
		sc.close();
		
		System.out.println(String.format("%.6f",R * R * Math.PI));	// 유클리드 원의 넓이
		System.out.println(String.format("%.6f",R * R * 2));	// 유클리드 원의 넓이
	}
}
