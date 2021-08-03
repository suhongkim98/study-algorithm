
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while(sc.hasNextInt()) {
		    int v = sc.nextInt();
		    count++;
		    sc.nextLine(); // 개행제거
		    Node[] nodes = new Node[2000];
		    for(int i = 0 ; i < 2000 ; i++) {
		        nodes[i] = new Node();
		    }
		    for(int i = 0 ; i < v ; i++) {
		        String[] input = sc.nextLine().split(" ");
		        Node node = nodes[Integer.parseInt(input[0]) - 1];
		        node.word = input[1];
		        if(input.length > 2) {
		            node.left = nodes[Integer.parseInt(input[2]) - 1];
		        }
		        if(input.length > 3) {
		            node.right = nodes[Integer.parseInt(input[3]) - 1];
		        }
		    }
		    System.out.print("#" + count + " " + inorder(nodes[0]));
		    System.out.println();
		}
		    
	}
	static int inorder(Node node) {
	    if(node.left == null || node.right == null) {
	        try {
	            Double.parseDouble(node.word);
	            return 1; // 계산 가능
	        } catch(Exception e) {
	            return 0; // 계산 불가
	        }
	    }
	    int leftVal = inorder(node.left);
	    int rightVal = inorder(node.right);
	    return leftVal == 0 || rightVal == 0 ? 0 : 1;
	}
}

class Node {
    String word;
    Node left;
    Node right;
}
