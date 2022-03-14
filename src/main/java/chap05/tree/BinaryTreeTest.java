package chap05.tree;

public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.insertRecursively(tree.root,1);
        tree.insertRecursively(tree.root,2);
        tree.insertRecursively(tree.root,3);
        tree.insertRecursively(tree.root,4);
        tree.insertRecursively(tree.root,5);
        tree.insertRecursively(tree.root,6);
        tree.insertRecursively(tree.root,7);
        tree.insertRecursively(tree.root,8);
        System.out.print("Pre Order :: ");
        tree.preOrderTraversal(tree.root);
        System.out.println();

        //Build tree from Pre Order and In Order
        BinaryTree tree1 = new BinaryTree();
        int preOrder[] = {1,2,4,8,5,3,6,7};
        int inOrder[] = {8,4,2,5,1,6,3,7};
        tree1.root = tree1.buildTree(inOrder,preOrder,0,inOrder.length-1);
        System.out.print("Breath First Search :: ");
        tree1.breathFirstOrder(tree1.root);
        System.out.println();

        int[] postOrder = {9,1,2,12,7,5,3,11,4,8};
        int[] inOrder1  = {9,5,1,7,2,12,8,4,3,11};

        BinaryTree tree2 =  new BinaryTree();
        BinaryTree.Index pIndex = new BinaryTree.Index();
        pIndex.index = postOrder.length - 1;
        tree2.root = tree2.buildBTFromPostAndIn(inOrder1,postOrder,0,inOrder1.length-1,pIndex);
        System.out.print("Breath First Search :: ");
        tree2.breathFirstOrder(tree2.root);
        System.out.println();

    }
}
