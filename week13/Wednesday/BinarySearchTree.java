import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        Random rand = new Random();
        rand.setSeed(0);
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 1; i <= 5; i++) {
            tree.insert(rand.nextInt(100));
        }

        System.out.println(tree.inorder());

        System.out.println();
    }
}

class BinarySearchTree {
    // linked node implementation
    // very similar to a linked list...

    Node root;

    public void insert(int item) {
        // perform a search
        // when I fall off the tree
        // insert the item there

        // some decisions we're making
        // no duplicates allowed

        if (root == null) {
            // tree is empty
            // need to handle this as a special case
            root = new Node();
            root.data = item;
            return;
        }

        insert(item, root);

    }

    private void insert(int item, Node root) {
        if (item > root.data) {
            if (root.right == null) {
                // i've fallen off the tree
                // very similar to how we did this in linked list
                Node node = new Node();
                node.data = item;
                root.right = node;
                return; // <----- this is a base case so don't recurse
            }
            // the item belongs to the right subtree
            insert(item, root.right);
        } else {
            // the item belongs to the left subtree
            // design decision so far.. equal will end up here...
            if (root.left == null) {
                Node node = new Node();
                node.data = item;
                root.left = node;
                return;
            }
            insert(item, root.left);
        }
    }

    public String inorder() {
        if (root == null) {
            return ("[ ]");
        } else {
            return inorder(root, "");
        }
    }

    @Override
    public String toString() {
        return inorder();
    }


    private String inorder(Node root, String output) {
        // left
        if (root.left != null)
            output = preorder(root.left, output);
        // visit
        // System.out.println(root.data + " ");
        output += root.data + " ";
        //right
        if (root.right != null)
            output = preorder(root.right, output);
        return output;
    }


    class Node {
        Node left, right;
        int data;
    }
}
