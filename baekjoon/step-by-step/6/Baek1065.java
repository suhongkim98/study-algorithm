import java.util.*;
//https://www.acmicpc.net/problem/1065
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int size = scanner.nextInt();
        for(int i = 1 ; i <= size ; i++) {
            int n = i;
            Vector<Integer> list = new Vector<>();
            while(n > 0) {
                list.add(n % 10);
                n /= 10;
            }
            int diff = 10; // max
            int j;
            for(j = 0 ; j < list.size() - 1 ; j++) {
                if(diff == 10) {
                    diff = list.get(j) - list.get(j+1);
                } else if(diff != list.get(j) - list.get(j+1)) {
                    break;
                }
            }
            if(j == list.size() -1) {
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}
