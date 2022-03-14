package chap05.tree;
/*
Insertion of Node
o Deletion of Node
o Inorder Traversal (Recursive and Iterative)
o Preorder Traversal (Recursive and Iterative)
o Postorder Traversal (Recursive and Iterative)
o Level Order Traversal
o Reverse Level Order traversal
o Searching of Value
o Height of tree
o Diameter of Tree
o Mirror of Tree
o Check tree is balanced or not
o Find minimum value in tree
o Find maximum value in tree
 */
public class BabbarQsEasyBT {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTree.Node(1);
        tree.insert(tree.root,2);
        tree.insert(tree.root,3);
        tree.insert(tree.root,4);
        tree.insert(tree.root,5);
        tree.insert(tree.root,6);
        tree.insert(tree.root,7);
        tree.insert(tree.root,8);

        System.out.print("InOrder Traversal ::");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Breath First Search :: ");
        tree.breathFirstOrder(tree.root);
        System.out.println();

        System.out.print("Pre Order Traversal :: ");
        tree.preOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Post Order Traversal :: ");
        tree.postOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Level Order Traversal :: ");
        tree.breathFirstOrder(tree.root);
        System.out.println();

        System.out.print("Reverse Level Order Traversal :: ");
        tree.reverseLevelOrderBreathFirst(tree.root);
        System.out.println();

        System.out.println("Find element in tree :: " + tree.ifNodeExists(tree.root,3));

        System.out.println("Height of tree :: " + tree.findHeightOfTree(tree.root));

        System.out.println("Diameter of tree :: " + tree.diameterOfBT(tree.root));

        System.out.print("Mirror of Tree :: ");
        BinaryTree mirror = new BinaryTree();
        mirror.root = tree.mirrorBT(tree.root);
        mirror.breathFirstOrder(mirror.root);
        System.out.println();
        System.out.println("Check if tree is Balanced :: " + tree.checkIfTreeIsBalanced(tree));

        System.out.println("Find Min in tree :: " + tree.findMinElementInBT(tree.root));
        System.out.println("Find Max in tree :: " + tree.findMaxElementInBT(tree.root));

    }
}
