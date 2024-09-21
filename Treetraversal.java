
// TREE TRAVERSAL
/*
Depth First Search (DFS) is used by PreOrder, InOrder, and PostOrder Tree traversal
Breadth First Search (BFS) is used by LevelOrder Traversal of the tree
*/
import java.util.Queue;
import java.util.LinkedList;

public class Treetraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;// we initialized it with -1 so that we can increment it everytime and take till
                              // entire length.

        public Node buildTree(int[] nodes) {
            // it returns the root node
            index++; // to iterate the array
            if (nodes[index] == -1) {
                return null;// because null will not have any left child or right child. So we return null
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            /*
             * Like this all our nodes will get created recursively.
             * So here, after each node is created, its left subtree will be created, and
             * then its right subtree will be created, and then it will be returned.
             */
            return newNode;// at the end our root node will be returned.
        }
    }

    public static void preorder(Node root) {
        // Base condition: when null occurs.
        if (root == null) {
            // if you want to print -1 whereever null occurs, then you can write here print
            // statement else you can just return
            return;

        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        // Base condition: when null occurs.
        if (root == null) {
            // if you want to print -1 whereever null occurs, then you can write here print
            // statement else you can just return
            return;

        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        // Base condition: when null occurs.
        if (root == null) {
            // if you want to print -1 whereever null occurs, then you can write here print
            // statement else you can just return
            return;

        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");

    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return; // because we don't have anything to print
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root); // Add the root element and then add null into the queue as in the binary tree
                     // root node will be only one and will not have any siblings, we move to the
                     // next level.
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) { // Here we are taking null means next line.
                System.out.println();// If the current node is null we'll just print nextline.
                /*
                 * after removing null, if our queue becomes empty, then we will not re-insert
                 * null in the queue and stop our loop here itself. If queue is not empty, then
                 * we will re-insert null at the end of the queue.
                 */
                if (q.isEmpty()) {// means null node was our last node and now after removing that, our queue is
                                  // empty.
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                // After printing the element, add the children of the current element at the
                // end of the queue(First add left child and then right child. If any of the
                // child is null, then dont add null just continue with the process.)
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] nodes = { 1, 2, 3,4, -1, -1, 5, -1, -1, 99, -1, 6, -1, -1,98,-1,-1 };

        /*
         * int[] nodes = { 1, 2, 3, 4, -1, -1, 5, -1, -1, 99, -1, 6, -1, -1};//This
         * gives error. At the end you should write -1,-1 and also one more element say,98 if you add one more element say, '3'.
         * like this: int[] nodes = { 1, 2, 3, 4, -1, -1, 5, -1, -1, 98, -1, 6, -1,
         * -1,98,-1,-1};
         */
        BinaryTree tree = new BinaryTree(); // tree is an object of the BinaryTree class which we have implemented
                                            // above.
        Node root = tree.buildTree(nodes); /*
                                            * With the help of the object tree of the class BinaryTree, we can access
                                            * all the methods of that class.
                                            */

        System.out.println("Preorder Traversal of the tree: ");
        preorder(root);
        System.out.println();
        System.out.println("Inorder Traversal of the tree: ");
        inorder(root);
        System.out.println();
        System.out.println("Postorder Traversal of the tree: ");
        postorder(root);
        System.out.println();
        System.out.println("Level order Traversal of the tree: ");
        levelOrder(root);
        System.out.println();
    }
}
/*
 * //OUTPUT:
 * 
 * Preorder Traversal of the tree:
 * 1 2 4 5 99 6
 * Inorder Traversal of the tree:
 * 4 2 5 1 99 6
 * Postorder Traversal of the tree:
 * 4 5 2 6 99 1
 * Level order Traversal of the tree:
 * 1
 * 2 99
 * 4 5 6
 * 
 */
