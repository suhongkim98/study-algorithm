import java.util.*;
//https://www.acmicpc.net/problem/3009
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int firstX = scanner.nextInt();
        int firstY = scanner.nextInt();
        int secX = 0,secY = 0;
        int countX = 1, countY = 1;
        int resultX = 0, resultY = 0;
        for(int i = 0 ; i < 2 ; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(firstX == x) {
                countX++;
            } else {
                secX = x;
            }
            if(firstY == y) {
                countY++;
            } else {
                secY = y;
            }
        }
        if(countX == 2) {
            resultX = secX;
        } else {
            resultX = firstX;
        }
        if(countY == 2) {
            resultY = secY;
        } else {
            resultY = firstY;
        }
        System.out.println(resultX + " " + resultY);
        scanner.close();
    }
}
