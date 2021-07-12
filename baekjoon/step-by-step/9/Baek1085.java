import java.util.*;
//https://www.acmicpc.net/problem/1085
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int minX = w - x < x ? w - x : x;
        int minY = h - y < y ? h - y : y;
        if(minX > minY) {
            System.out.println(minY);
        } else {
            System.out.println(minX);
        }
        scanner.close();
    }
}
