import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.LongStream;

/**
 * Created by merrillm on 9/28/16.
 *
 * Worlds 2016: "Ceiling Function"
 */
class CeilingFunction {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int N = scn.nextInt();
        int L = scn.nextInt();
        
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            long[] layers = LongStream.generate(scn::nextLong).limit(L).toArray();
            set.add(makeTree(layers));
        }
        
        System.out.println(set.size());
    }
    
    static class Node {
        Long value = null;
        Node left = null;
        Node right = null;
        
        Node(long value) {
            this.value = value;
        }
    }
    
    static String makeTree(long[] layers) {
        Node root = new Node(layers[0]);
        for (int i = 1; i < layers.length; i++) {
            insert(root, layers[i]);
        }
        
        String ret = interp(root, "", 0);
//        StringBuilder sb = new StringBuilder();
//
//        for (boolean b : ret)
//            sb.append(b ? "T" : "F");
//
//        return sb.toString();
        return ret;
    }
    
    static String interp(Node root, String ret, int index) {
        if (root == null) {
            return ret;
        }
        
        if (root.left != null) {
            ret += "L";
            ret = interp(root.left, ret, index * 2 + 1);
            ret += "^";
    
        }
        
        if (root.right != null) {
            ret += "R";
            ret = interp(root.right, ret, index * 2 + 2);
            ret += "^";
        }
        
        return ret;
    }
    
    static void insert(Node root, long value) {
        if (root.value < value) {
            if (root.left == null) {
                root.left = new Node(value);
            } else {
                insert(root.left, value);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(value);
            } else {
                insert(root.right, value);
            }
        }
    }
}
