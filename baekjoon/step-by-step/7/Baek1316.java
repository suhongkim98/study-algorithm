import java.util.*;
//https://www.acmicpc.net/problem/1316
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int notGroup = 0;
        for(int i = 0 ; i < size ; i++) {
            int[] count = new int[26];
            char lastChar = 0;
            String input = scanner.next();
            for(int j = 0 ; j < input.length(); j++) {
                if(lastChar == 0 || lastChar == input.charAt(j) || count[input.charAt(j) - 'a'] == 0) {
                    lastChar = input.charAt(j);
                    count[lastChar - 'a']++;
                } else {
                    notGroup++;
                    break;
                }
            }
        }
        System.out.println(size - notGroup);
        scanner.close();
    }
}
