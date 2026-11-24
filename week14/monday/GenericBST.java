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

        GenericBST<String> stringBST = new GenericBST<>();
        GenericBST<Pokemon> pokemonBST = new GenericBST<Pokemon>();
    }
}

class Pokemon implements Comparable<Pokemon>{
    private String name;
    private int hp;

    @Override
    public int compareTo(Pokemon o) {
        // one pokemon is > than another...
        if (this.hp > o.hp){
            return 1; // <- any positive integer
        } else if (this.hp < o.hp) {
            return -1; // <- any neg integer
        }

        return 0; // <-- this and o are ==

        // if i wanted to define this as this > o by name (String)
        // return this.name.compareTo(o.name);
    }
}

class GenericBST<T extends Comparable<T>> {
    /*
    There's some left over copy/paste issues.. you don't need to use BinarySearchTree.Node... you should change all of those to just Node
    .. in fact... probably best to just delete the entire BinarySearchTree class and use this class (GenericBST) as your starter code
    */

    private Node root;

    class Node {
        T data;
        Node left, right;
    }

    public void insert(T item) {
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

    private void insert(T item, Node root) {
        if (item > root.data) {  // <-- this needs to be converted to if (item.compareTo(root.data) > 0)
            if (root.right == null) {
                // i've fallen off the tree
                // very similar to how we did this in linked list
                BinarySearchTree.Node node = new Node();
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
                BinarySearchTree.Node node = new BinarySearchTree.Node();
                node.data = item;
                root.left = node;
                return;
            }
            insert(item, root.left);
        }
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
