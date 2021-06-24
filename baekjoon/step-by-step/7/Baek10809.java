import java.util.*;
//https://www.acmicpc.net/problem/10809
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        char[] arr = scanner.next().toCharArray();
        int[] pos = new int[26];
        for(int i = 0 ; i < pos.length ; i++) {
            pos[i] = -1;
        }
        for(int i = 0 ; i < arr.length ; i++) {
            if(pos[arr[i] - 'a'] == -1) {
                pos[arr[i] - 'a'] = i;
            }
        }
        for(int i = 0 ; i < pos.length ; i++) {
            System.out.print(pos[i] + " ");
        }
        scanner.close();
    }
}
