import java.util.Scanner;
import java.io.FileInputStream;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while(sc.hasNextInt()) {
		    int size = sc.nextInt();
		    count++;
		    sc.nextLine(); // 개행제거
		    Node[] nodes = new Node[size];
		    for(int i = 0 ; i < size ; i++) {
		        nodes[i] = new Node();
		    }
		    for(int i = 0 ; i < size ; i++) {
		        String[] input = sc.nextLine().split(" ");
		        Node node = nodes[Integer.parseInt(input[0]) - 1];
		        node.word = input[1].charAt(0);
		        if(input.length > 2) {
		            node.left = nodes[Integer.parseInt(input[2]) - 1];
		        }
		        if(input.length > 3) {
		            node.right = nodes[Integer.parseInt(input[3]) - 1];
		        }
		    }
		    System.out.print("#" + count + " ");
		    inorder(nodes[0]);
		    System.out.println();
		}
		    
	}
	static void inorder(Node node) {
	    if(node != null) {
	        inorder(node.left);
	        System.out.print(node.word);
	        inorder(node.right);
	    }
	}
}

class Node {
    char word;
    Node left;
    Node right;
    boolean visit;
}
