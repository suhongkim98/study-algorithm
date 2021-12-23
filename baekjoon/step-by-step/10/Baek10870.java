import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(get(n));
		
	}
	public static int get(int n) {
	    if(n == 0) return 0;
	    if(n == 1) return 1;
	    return get(n - 1) + get(n - 2);
	}
}
